package com.capg.spring.springPro;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl {
	
	List<Product> list = new ArrayList<>();

	public ProductDAOImpl() {
		
		Product p1 = new Product(101, "HP-101",45000, 1);
		Product p2 = new Product(102, "HP-102",15000, 3);
		Product p3 = new Product(103, "HP-103",25000, 5);
		Product p4 = new Product(104, "HP-104",20000, 5);
		Product p5 = new Product(105, "HP-105",145000,2);
		
		list = Arrays.asList(p1,p2,p3,p4,p5);
	
	}
	
	public List<Product> getAllProducts()
	{
		return list;
	}
	
	public List<Product> getProductsByRange(int r1,int r2)
	{
		
		Comparator<Product> comp = (p1,p2)->p1.getProductCost() - p2.getProductCost();
		
		List<Product> productList = list.stream().
		filter((product)->product.getProductCost()>=r1&&product.getProductCost()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	
	public List<Product> getProductsByRating(int r1,int r2)
	{
		
		Comparator<Product> comp = (p1,p2)->p1.getRating() - p2.getRating();
		
		List<Product> productList = list.stream().
		filter((product)->product.getRating()>=r1&&product.getRating()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	
	
	public Product getProductById(int searchid)
	{
		boolean isIdFound = false;
		Product searchedProduct = null;
		for (Product product : list) {
			if(product.getProductId() == searchid)
			{
				isIdFound = true;
				searchedProduct = product;
				break;
			}
		}
		return searchedProduct;
	}
	
	
	
	
	public boolean deleteProductById(int searchId) {
		
		boolean isDeleted = false;
		
		List<Product> productList = list.stream().
				filter((product)->product.getProductId()==searchId).
				collect(Collectors.toList());
		
		list.remove(productList);
		if(productList.isEmpty()) {
			isDeleted =true;
		}
	
		return isDeleted; 
		
		
	}
	
}//end class
