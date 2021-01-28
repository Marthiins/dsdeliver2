package com.devsuperior.dsdeliver.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_product")
public class OrderProducts implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	// A chave dessa classe será do tipo ItemPedidoPk, o que parecerá com uma tipo primitivo;
	@EmbeddedId
	private OrderProductPK id = new OrderProductPK();// Chave composta para o JPA;
	
	private Integer amount;
	private Double price;

	public OrderProducts() {
	}

	public OrderProducts(Order order, Product product, Integer amount, Double price) {
		// Aqui recebemos o id da classe order e da classe product, os dois juntos serão o 
		// identificador da ordem;
		id.setOrder(order);
		id.setProduct(product);
		this.amount = amount;
		this.price = price;
	}

	// Calculara o valor total daquele produto;
	public Double getSubTotal() {
		return price * amount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
