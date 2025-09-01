package com.example.demo_rabbit.service;

import com.example.demo_rabbit.mapper.UsuarioMapper;
import com.example.demo_rabbit.model.Usuario;
import com.example.demo_rabbit.model.dto.UsuarioRequestDTO;
import com.example.demo_rabbit.model.dto.UsuarioResponseDTO;
import com.example.demo_rabbit.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private RabbitMqService rabbitMqService;

    public UsuarioResponseDTO salvarUsuarioEPedido(UsuarioRequestDTO usuarioRequestDTO) {

        Usuario usuario = UsuarioMapper.INSTANCE.convertUsuarioDTOToUsuario(usuarioRequestDTO);

        usuario = this.usuarioRepository.save(usuario);

        try {
            this.rabbitMqService.notificarPedidoPendente(usuario);
        } catch (RuntimeException e) {
            usuario.getPedido().setPendente(true);
            this.usuarioRepository.save(usuario);
        }

        return UsuarioMapper.INSTANCE.convertUsuarioToUsuarioResponseDTO(usuario);
    }
}
