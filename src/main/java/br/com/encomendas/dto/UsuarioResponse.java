package br.com.encomendas.dto;

import br.com.encomendas.enums.Perfil;
import br.com.encomendas.model.Usuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        Perfil perfil) {

    public static UsuarioResponse de(Usuario u) {
        return new UsuarioResponse(u.getId(), u.getNome(), u.getEmail(), u.getPerfil());
    }
}
