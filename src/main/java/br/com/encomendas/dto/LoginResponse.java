package br.com.encomendas.dto;

import br.com.encomendas.enums.Perfil;

public record LoginResponse(
        String token,
        String tipo,
        String nome,
        Perfil perfil) {

    public static LoginResponse bearer(String token, String nome, Perfil perfil) {
        return new LoginResponse(token, "Bearer", nome, perfil);
    }
}
