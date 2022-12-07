package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.Product;
import com.pms.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService pps;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct( @RequestBody Product product){
		return new ResponseEntity<Product>(pps.saveProduct(product) , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllproduct")
	public List<Product> getAllproduct(){
		return pps.getAllProducts();
	}
	
	@GetMapping("/getBypid/{pid}")
	public ResponseEntity<Product> getProductByPid(@PathVariable("pid") int pid){
		return new ResponseEntity<Product>(pps.getProductById(pid),HttpStatus.OK);
	}
	@PutMapping("/updateProduct/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") int uid, @RequestBody Product product){
			return new ResponseEntity<Product>(pps.updateProductById(product, uid), HttpStatus.OK);
		}
	
	
		
	@DeleteMapping("/deleteProduct/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") int pid){
		pps.deleteProductById(pid);
		return new ResponseEntity<String>("product Deleted Successfully", HttpStatus.OK);
				}
	
}
