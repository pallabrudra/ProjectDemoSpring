package com.pms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.Order;
import com.pms.service.OrderService;


@RestController
public class OrderController {
	@Autowired
	private OrderService os;
	
	//save order in db table using rest api PostMapping
	@PostMapping("/saveOrder")
	public ResponseEntity<Order> saveOrder( @RequestBody Order order){
		return new ResponseEntity<Order>(os.placedOrder(order) , HttpStatus.CREATED);
	}
	
	// fetch order details from db table using rest api GetMapping
	@GetMapping("/getAllorder")
	public List<Order> getAllorders(){
		return os.getAllOrders();
	}
	
	// fetch order details from db table using rest api GetMapping based on oid
	@GetMapping("/getByoid/{oid}")
	public ResponseEntity<Order> getOrderByid(@PathVariable("oid") int oid){
		return new ResponseEntity<Order>(os.getOrderById(oid),HttpStatus.OK);
	}
	
	
		
		//delete order details in db table using rest api PutMapping based on oid
	@DeleteMapping("/deleteOrder/{oid}")
	public ResponseEntity<String> deleteOrder(@PathVariable("oid") int oid){
		os.deleteOrderById(oid);
		return new ResponseEntity<String>("Order Deleted Successfully", HttpStatus.OK);
				}
//	get order details by order name 
	@GetMapping("/getByOrderName/{oname}")
	public List<Order> getOrderByOrderName(@PathVariable String oname){
		return os.getOname(oname);
	}
	
	
	
}
