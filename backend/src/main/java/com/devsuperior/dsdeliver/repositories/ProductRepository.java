package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{ //Essa IDE faz todo o crud , o T é a chave primaria e o ID

	List<Product> findAllByOrderByNameAsc();//Metodo findAllBy buscar todo mundo por name asc(ordem crescente) Desc(Ordem decrescente
}
