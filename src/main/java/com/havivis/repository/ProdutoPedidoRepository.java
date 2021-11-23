package com.havivis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havivis.model.ProdutoPedido;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long>{
// apagar se der erro
}
