package com.capg.spring.springPro;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyRestController {
	
	@Autowired
	ProductDAOImpl dao;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	
	@GetMapping("/product/{r1}/{r2}")
	public List<Product> getProdutsByRange(@PathVariable int r1, @PathVariable int r2) {
		return dao.getProductsByRange(r1, r2);
	}
	
	@GetMapping("/product/{searchId}")
	public Product getProductById(@PathVariable int searchId) {
		return dao.getProductById(searchId);
	}
	
	@GetMapping("/product/rating/{r1}/{r2}")
	public List<Product> getProductByRating(@PathVariable int r1, @PathVariable int r2) {
		return dao.getProductsByRating(r1, r2);
	}
	
	@GetMapping("/product")
	public List<Product> getProduct() {
		return dao.getAllProducts();
	}
	
	@GetMapping("/product/delete/{searchId}")
	public boolean deleteProductById(@PathVariable int searchId) {
		return dao.deleteProductById(searchId);
	}
 
}