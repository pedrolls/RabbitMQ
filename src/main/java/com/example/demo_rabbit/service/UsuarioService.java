package com.example.demo_rabbit.service;

import com.example.demo_rabbit.mapper.UsuarioMapper;
import com.example.demo_rabbit.model.Usuario;
import com.example.demo_rabbit.model.dto.UsuarioRequestDTO;
import com.example.demo_rabbit.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private RabbitMqService rabbitMqService;

    public void salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        Usuario usuario = UsuarioMapper.INSTANCE.convertUsuarioDTOToUsuario(usuarioRequestDTO);

        usuario = this.usuarioRepository.save(usuario);

        this.rabbitMqService.notificarPedidoPendente(usuario);
    }
}
