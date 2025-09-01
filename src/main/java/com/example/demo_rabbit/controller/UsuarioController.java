package com.example.demo_rabbit.controller;

import com.example.demo_rabbit.model.dto.UsuarioRequestDTO;
import com.example.demo_rabbit.model.dto.UsuarioResponseDTO;
import com.example.demo_rabbit.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar-novo-pedido")
    public ResponseEntity<UsuarioResponseDTO> salvarUsuarioEPedido(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.salvarUsuarioEPedido(usuarioRequestDTO));
    }
}
