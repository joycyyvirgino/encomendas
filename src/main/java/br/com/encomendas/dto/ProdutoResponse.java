package br.com.encomendas.dto;

import br.com.encomendas.model.Produto;
import java.math.BigDecimal;
import java.util.List;

public record ProdutoResponse(
        Long id,
        String nome,
        BigDecimal preco,
        boolean ativo,
        List<ItemReceitaResponse> receita) {

    public static ProdutoResponse de(Produto p) {
        return new ProdutoResponse(
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.isAtivo(),
                p.getReceita().stream().map(ItemReceitaResponse::de).toList());
    }
}
