package br.com.encomendas.repository;

import br.com.encomendas.model.ItemReceita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemReceitaRepository extends JpaRepository<ItemReceita, Long> {
}
