package br.com.encomendas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Padrão único de erro da API: timestamp, status, mensagem e, nas validações (400),
 * a lista de campos inválidos. Regra violada = 409, inexistente = 404.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErroResponse(
        LocalDateTime timestamp,
        int status,
        String mensagem,
        List<CampoErro> campos) {

    public static ErroResponse de(int status, String mensagem) {
        return new ErroResponse(LocalDateTime.now(), status, mensagem, null);
    }

    public static ErroResponse de(int status, String mensagem, List<CampoErro> campos) {
        return new ErroResponse(LocalDateTime.now(), status, mensagem, campos);
    }
}
