package com.SpringBootFreshPrints.SpringBootFreshPrints.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFreshPrints.SpringBootFreshPrints.config.service.UserService;
import com.SpringBootFreshPrints.SpringBootFreshPrints.jwtauthentication.model.AuthenticationRequest;
import com.SpringBootFreshPrints.SpringBootFreshPrints.jwtauthentication.model.AuthenticationResponse;
import com.SpringBootFreshPrints.SpringBootFreshPrints.jwtauthentication.utils.JwtUtil;
import com.SpringBootFreshPrints.SpringBootFreshPrints.orders.entities.Order;
import com.SpringBootFreshPrints.SpringBootFreshPrints.orders.entities.OrderItem;
import com.SpringBootFreshPrints.SpringBootFreshPrints.services.UserOrdersService;
import com.SpringBootFreshPrints.SpringBootFreshPrints.users.entities.UserInfo;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class SpringBootController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserOrdersService userOrdersService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	// Test Method to check Header level Authentication is working or not
	@GetMapping(value = "/response")
	public String getResponse() {
		return "Welcome! You are receiving response";
	}

	// To create the JWT token by receiving authorization request
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	// To get data of ORDER table
	@GetMapping("/getorderdetails")
	public ResponseEntity<List<Order>> getOrderDetails() {

		return userOrdersService.getOrderData();
	}

	// To get data of USER_INFO table
	@GetMapping("/getuserdetails")
	public ResponseEntity<List<UserInfo>> getUserDetails() {

		return userOrdersService.getUserData();
	}

	// To create data into USER_INFO table by passing info
	@PostMapping("/putuserdata")
	public ResponseEntity<UserInfo> createRecord(@RequestBody UserInfo info) {

		return userOrdersService.putUserInfo(info);
	}

	// To update data of ORDER table by passing orderNumber
	@PutMapping("/updateorderInfoById/{id}")
	public ResponseEntity<Order> updateOrderInfoById(@PathVariable("id") int orderNumber) {
		return userOrdersService.updateOrderInfo(orderNumber);

	}

	// To get Order Details by passing orderNumber to ORDER Table
	@GetMapping("/getItembynumber")
	public ResponseEntity<Order> getItemByOrderNo(@RequestParam(required = false) int orderNumber,
			@RequestBody OrderItem orderItem) {
		return userOrdersService.getItemByOrderNo(orderNumber, orderItem);
	}

	// To delete Order Details by passing orderNumber to ORDER Table
	@DeleteMapping("/deleteorderdetails/{orderNumber}")
	public ResponseEntity<Order> deleteorderbyOrderNo(@PathVariable("orderNumber") int orderNumber,
			@RequestBody(required = false) Order order) {
		return userOrdersService.deleteorderDetails(orderNumber);

	}
}
