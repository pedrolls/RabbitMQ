package com.example.demo_rabbit.mapper;

import com.example.demo_rabbit.model.Usuario;
import com.example.demo_rabbit.model.dto.UsuarioRequestDTO;
import com.example.demo_rabbit.model.dto.UsuarioResponseDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "pedidoId", source = "pedido.id")
    @Mapping(target = "valorSolicitado", source = "pedido.valorSolicitado")
    @Mapping(target = "dataDeSolicitacao", source = "pedido.dataDeSolicitacao")
    UsuarioResponseDTO convertUsuarioToUsuarioResponseDTO(Usuario usuario);

    @Mapping(target = "pedido.valorSolicitado", source = "valorSolicitado")
    Usuario convertUsuarioDTOToUsuario(UsuarioRequestDTO usuarioRequestDTO);

    @AfterMapping
    default void aposMapearUsuario(@MappingTarget Usuario usuario){
        if(usuario.getPedido().getUsuario() == null){
            usuario.getPedido().setUsuario(usuario);
        }
    }
}
