package com.sathya.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rest.entity.Products;

import com.sathya.rest.repository.ReactRepository;


@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/v1")
public class ReactController {
	@Autowired
	ReactRepository reactRepository;
	
	@PostMapping("/save")
	public ResponseEntity<Products> saveProduct(@RequestBody Products product) {
	    // Save the single product
	    Products savedProduct = reactRepository.save(product);
	    
	    // Return the saved product with HTTP status 201 (Created)
	    return ResponseEntity.status(HttpStatus.CREATED)
	             .header("emp-status", "Form data saved successfully")
	             .body(savedProduct);
	}

	@GetMapping("/getproducts")
	public ResponseEntity<List<Products>> getProducts() {
	    // Fetch all products
	    List<Products> products = reactRepository.findAll();
	    
	    // Return the list of products with HTTP status 200 (OK)
	    return ResponseEntity.ok(products);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<List<Products>> deleteProduct(@PathVariable Long id) {
	    // Try to delete the product by id
	    try {
	        reactRepository.deleteById(id);  // Deletes the product if it exists
	        List<Products> remainingProducts = reactRepository.findAll();  // Get the remaining products
	        return ResponseEntity.ok(remainingProducts);  // Return remaining products after deletion
	    } catch (EmptyResultDataAccessException e) {
	        // This exception is thrown when the product with the given ID is not found
	        return ResponseEntity.notFound().build();  // Return 404 if product is not found
	    }
	}
	@PatchMapping("/products/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products product) {
	    Optional<Products> existingProductOpt = reactRepository.findById(id);

	    if (existingProductOpt.isPresent()) {
	        Products existingProduct = existingProductOpt.get();

	        // Update fields only if they're non-null in the request
	        if (product.getName() != null) {
	            existingProduct.setName(product.getName());
	        }
	        if (product.getCategory() != null) {
	            existingProduct.setCategory(product.getCategory());
	        }
	        if (product.getImage() != null) {
	            existingProduct.setImage(product.getImage());
	        }

	        // Save the updated product to the repository
	        Products updatedProduct = reactRepository.save(existingProduct);

	        // Return the updated product with a 200 OK status
	        return ResponseEntity.ok(updatedProduct);
	    } else {
	        // Return 404 if the product is not found
	        return ResponseEntity.notFound().build();
	    }
	}



}
