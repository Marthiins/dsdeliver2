package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service // registrar componente para injetar outros componentes no controlador
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() { // Criar uma funçao para retornar a lista de produtos
		List<Order> list = repository.findOrdersWithProducts();// Buscar Dados repositorio repository banco de dados
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList()); // como converti a lista para
																						// //stream uso o .collect para
																						// desconverter
	}

	/*
	 * @Transactional public OrderDTO insert(OrderDTO dto) { //vai retornar somente
	 * o pedido e não uma lista Order order = new Order(null, dto.getAddress(),
	 * dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
	 * // salvar o pedido no banco de dados tem que ser na ordem dos atributos for
	 * (ProductDTO p : dto.getProducts()) { Product product =
	 * productRepository.getOne(p.getId());
	 * order.getProducts().add(product);//Associar os pedidos com os produtos no DTO
	 * 
	 * } order = repository.save(order); return new OrderDTO(order); }
	 * 
	 * @Transactional public OrderDTO setDelivered(Long id) { Order order =
	 * repository.getOne(id); // getOne não vai no banco de dados nesse instancia
	 * order.setStatus(OrderStatus.DELIVERED); order = repository.save(order);
	 * return new OrderDTO(order);
	 * 
	 * }
	 */

}
