package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service // registrar componente para injetar outros componentes no controlador
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() { // Criar uma funçao para retornar a lista de produtos
		List<Order> list = repository.findOrdersWithProducts();// Buscar Dados repositorio repository banco de dados
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList()); // como converti a lista para
																						// stream uso o .collect para desconverter
		}
}
