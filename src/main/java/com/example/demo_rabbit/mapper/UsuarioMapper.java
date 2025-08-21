package com.example.demo_rabbit.mapper;

import com.example.demo_rabbit.model.Usuario;
import com.example.demo_rabbit.model.dto.UsuarioRequestDTO;
import org.aspectj.lang.annotation.After;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

//    UsuarioRequestDTO convertUsuarioToUsuarioDTO(Usuario usuario);

    @Mapping(target = "pedido.valorSolicitado", source = "valorSolicitado")
    Usuario convertUsuarioDTOToUsuario(UsuarioRequestDTO usuarioRequestDTO);

    @AfterMapping
    default void aposMapearUsuario(@MappingTarget Usuario usuario){
        if(usuario.getPedido().getUsuario() == null){
            usuario.getPedido().setUsuario(usuario);
        }
    }
}
