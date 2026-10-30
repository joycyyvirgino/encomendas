package br.com.encomendas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public record ProdutoRequest(
        @NotBlank @Size(max = 120) String nome,
        @NotNull @Positive BigDecimal preco,
        @NotEmpty @Valid List<ItemReceitaRequest> receita) {
}
