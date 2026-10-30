package br.com.encomendas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public record PedidoRequest(
        @NotBlank @Size(max = 120) String cliente,
        @Size(max = 20) String telefone,
        @NotNull @FutureOrPresent LocalDate dataEntrega,
        @NotEmpty @Valid List<ItemPedidoRequest> itens) {
}
