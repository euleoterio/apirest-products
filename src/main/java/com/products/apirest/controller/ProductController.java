package com.products.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Products API Rest")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value = "Returns a list of products")
	public List<Product> listOfProducts(){
		return productRepository.findAll();
	}

	@GetMapping("/products/{id}")
	@ApiOperation(value = "Returns a unique product")
	public Product productById(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	@ApiOperation(value = "Save a product")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product")
	@ApiOperation(value = "Delete a product")
	public void deleteProduct(@RequestBody Product product) {
		productRepository.delete(product);
	}
	
	@PutMapping("/product")
	@ApiOperation(value = "Update a product")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
