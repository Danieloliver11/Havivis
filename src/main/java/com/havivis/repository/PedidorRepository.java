package com.havivis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havivis.model.Pedido;

@Repository
public interface PedidorRepository extends JpaRepository<Pedido, Long>{
	

}
