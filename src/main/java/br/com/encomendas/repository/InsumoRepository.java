package br.com.encomendas.repository;

import br.com.encomendas.model.Insumo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {

    @Query("select i from Insumo i where i.estoqueAtual < i.estoqueMinimo order by i.nome")
    List<Insumo> findAbaixoDoMinimo();
}
