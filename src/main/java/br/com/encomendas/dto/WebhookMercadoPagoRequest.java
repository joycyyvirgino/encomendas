package br.com.encomendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Corpo do webhook do Mercado Pago. Só interessa o data.id; o status real é
 * consultado na API do Mercado Pago antes de confirmar o pagamento (RN09).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookMercadoPagoRequest(
        String action,
        String type,
        Data data) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Data(String id) {
    }

    public String idPagamento() {
        return data == null ? null : data.id();
    }
}
