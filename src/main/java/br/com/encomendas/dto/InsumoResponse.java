package br.com.encomendas.dto;

import br.com.encomendas.enums.UnidadeMedida;
import br.com.encomendas.model.Insumo;
import java.math.BigDecimal;

public record InsumoResponse(
        Long id,
        String nome,
        UnidadeMedida unidade,
        BigDecimal estoqueAtual,
        BigDecimal estoqueMinimo,
        boolean abaixoDoMinimo) {

    public static InsumoResponse de(Insumo i) {
        return new InsumoResponse(
                i.getId(),
                i.getNome(),
                i.getUnidade(),
                i.getEstoqueAtual(),
                i.getEstoqueMinimo(),
                i.getEstoqueAtual().compareTo(i.getEstoqueMinimo()) < 0);
    }
}
