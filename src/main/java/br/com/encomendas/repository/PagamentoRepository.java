package br.com.encomendas.repository;

import br.com.encomendas.model.Pagamento;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Optional<Pagamento> findByIdExterno(String idExterno);
}
