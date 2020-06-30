package com.cg.onlineshop.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshop.beans.Product;

public interface OnlineShopDAOServices extends JpaRepository<Product, Integer>{
	/*public void insertProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int productId);
	public ArrayList<Product> getAllProducts();
	public Product getProduct(int productId);
	void insertBulkProducts(ArrayList<Product>products);*/
	
}
