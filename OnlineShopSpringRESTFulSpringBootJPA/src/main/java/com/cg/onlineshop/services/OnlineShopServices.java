package com.cg.onlineshop.services;

import java.util.ArrayList;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;

public interface OnlineShopServices {
	public Product acceptProductDetails(Product product);
	public ArrayList<Product> getAllProductDetails();
	public Product getProductDetails(int productId)
			throws ProductDetailsNotFoundException;
	public void acceptBulkProductsDetails(ArrayList<Product> products);
	public void removeProdcutDetails(int productId) throws ProductDetailsNotFoundException;
	public void updateProductDetails(Product product)throws ProductDetailsNotFoundException;
}
