package com.cg.onlineshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.daoservices.OnlineShopDAOServices;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;

@Service(value="onlineShopServices")
public class OnlineShopServicesImpl implements OnlineShopServices{
	
	@Autowired
	OnlineShopDAOServices onlineShopDAOServices ;

	@Override
	public Product acceptProductDetails(Product product) {
		return onlineShopDAOServices.save(product);
	}

	@Override
	public ArrayList<Product> getAllProductDetails() {
		return (ArrayList<Product>) onlineShopDAOServices.findAll();
	}

	@Override
	public Product getProductDetails(int productId) throws ProductDetailsNotFoundException {
		return onlineShopDAOServices.findById(productId).orElseThrow(()->new ProductDetailsNotFoundException("Product details for productId "+productId+" not found") );	
	}

	@Override
	public void acceptBulkProductsDetails(ArrayList<Product> products) {
		for (Product product : products) {
			onlineShopDAOServices.save(product);
		}
	}
	@Override
	public void removeProdcutDetails(int productId) throws ProductDetailsNotFoundException {
		onlineShopDAOServices.findById(productId).orElseThrow(()->new ProductDetailsNotFoundException("Product details for productId  "+productId+"  not found") );
		onlineShopDAOServices.deleteById(productId);
	}

	@Override
	public void updateProductDetails(Product product)throws ProductDetailsNotFoundException {
		onlineShopDAOServices.findById(product.getProductId()).orElseThrow(()->new ProductDetailsNotFoundException("Product details for productId  "+product.getProductId()+"  not found") );
		onlineShopDAOServices.save(product);
	}

}
