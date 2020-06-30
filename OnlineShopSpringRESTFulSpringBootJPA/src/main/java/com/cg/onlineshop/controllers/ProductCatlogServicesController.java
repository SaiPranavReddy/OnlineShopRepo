package com.cg.onlineshop.controllers;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.beans.ProductList;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.services.OnlineShopServices;

import ch.qos.logback.core.util.SystemInfo;
@RestController
public class ProductCatlogServicesController {

	@Autowired
		private OnlineShopServices onlineShopServices ;
	
	@RequestMapping(method=RequestMethod.GET, value={"/sayHello"},produces={"application/text"})
	public ResponseEntity<String> getHelloMessage(){
		return new ResponseEntity<String>("Hello World From RestFulWebService", HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value={"/allProductDetailsJSON"},
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers ="Accept=application/json")
	public ResponseEntity<ArrayList<Product>> getAllProductDetailsJSON(){
		ArrayList<Product> productsList = onlineShopServices.getAllProductDetails();
		return new ResponseEntity<>(productsList,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/allProductDetailsXML"},produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<ProductList> getAllProductDetailsXML(){
		ArrayList<Product> products = onlineShopServices.getAllProductDetails();
		ProductList productList= new ProductList(products);
		return new ResponseEntity<>(productList,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/productDetailsRequestParam"},produces=MediaType.APPLICATION_JSON_VALUE, 
			headers ="Accept=application/json")
	public ResponseEntity<Product> getProductDetailsRequestParam(@RequestParam("productId") int productId) 
			throws ProductDetailsNotFoundException{
		Product product = onlineShopServices.getProductDetails(productId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}

	@RequestMapping(value={"/productDetailsPathVariable/{productId}"},produces=MediaType.APPLICATION_JSON_VALUE,headers ="Accept=application/json")
	public ResponseEntity<Product> getProductDetailsPathVariable(@PathVariable("productId") int productId) throws ProductDetailsNotFoundException{
		Product product = onlineShopServices.getProductDetails(productId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptProductDetails",method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptProductDetails(@ModelAttribute Product product){
		onlineShopServices.acceptProductDetails(product);
		return new ResponseEntity<>("Product details successfully added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteProductDetails",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProductDetails(@RequestParam("productId") int productId) throws ProductDetailsNotFoundException{
		onlineShopServices.removeProdcutDetails(productId);
		return new ResponseEntity<>("Product details with productCode "+productId+" successfully deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateProductDetails",method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> updateProductDetails(@ModelAttribute Product product) throws ProductDetailsNotFoundException{
		onlineShopServices.updateProductDetails(product);
		return new ResponseEntity<>("Product details with productCode "+product.getProductId()+" successfully updated",HttpStatus.OK);
	}
	
	@RequestMapping(value="/addProductDetailsBulkJSON", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProductDetailsBulkJSON(@RequestBody ArrayList<Product> products){
		onlineShopServices.acceptBulkProductsDetails(products);
		return new ResponseEntity<>("Products details successfully added",HttpStatus.OK);
		
	}
}
