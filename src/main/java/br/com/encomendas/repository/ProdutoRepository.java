package br.com.encomendas.repository;

import br.com.encomendas.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByAtivoTrue(Pageable pageable);
}
