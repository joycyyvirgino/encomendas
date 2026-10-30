package br.com.encomendas.dto;

import br.com.encomendas.enums.UnidadeMedida;
import br.com.encomendas.model.ItemReceita;
import java.math.BigDecimal;

public record ItemReceitaResponse(
        Long insumoId,
        String insumo,
        UnidadeMedida unidade,
        BigDecimal quantidade) {

    public static ItemReceitaResponse de(ItemReceita i) {
        return new ItemReceitaResponse(
                i.getInsumo().getId(),
                i.getInsumo().getNome(),
                i.getInsumo().getUnidade(),
                i.getQuantidade());
    }
}
