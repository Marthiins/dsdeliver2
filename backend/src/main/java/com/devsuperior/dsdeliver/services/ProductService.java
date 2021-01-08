package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service // registrar componente para injetar outros componentes no controlador
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() { // Criar uma funçao para retornar a lista de produtos
		List<Product> list = repository.findAllByOrderByNameAsc();// Buscar Dados repositorio repository banco de dados
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList()); // como converti a lista para
																						// stream uso o .collect para desconverter
		}
}
