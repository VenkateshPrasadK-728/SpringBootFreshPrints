package com.SpringBootFreshPrints.SpringBootFreshPrints.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.SpringBootFreshPrints.SpringBootFreshPrints.orders.entities.Order;
import com.SpringBootFreshPrints.SpringBootFreshPrints.orders.entities.OrderItem;
import com.SpringBootFreshPrints.SpringBootFreshPrints.orders.repositories.OrderRepository;
import com.SpringBootFreshPrints.SpringBootFreshPrints.users.entities.UserInfo;
import com.SpringBootFreshPrints.SpringBootFreshPrints.users.repositories.UserRepository;

@Service
public class UserOrdersService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	// To get data of Order table
	public ResponseEntity<List<Order>> getOrderData() {
		// TODO Auto-generated method stub
		try {
			orderRepository.findAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// To get data of userInfo table
	public ResponseEntity<List<UserInfo>> getUserData() {
		// TODO Auto-generated method stub
		try {
			userRepository.findAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// To get Item details by passing orderNumber from Order Table
	public ResponseEntity<Order> getItemByOrderNo(int orderNumber, OrderItem orderItem) {
		// TODO Auto-generated method stub
		try {
			OrderItem obj = new OrderItem();
			obj = (new OrderItem(orderNumber, obj.getOrderDescription(), obj.getOrderNo(), obj.getItems(),
					obj.getOrder()));
			orderRepository.findById(orderNumber);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// To create data into USER_INFO table by passing info
	public ResponseEntity<UserInfo> putUserInfo(UserInfo info) {
		// TODO Auto-generated method stub
		try {
			UserInfo information = (new UserInfo(info.getUserName(), info.getPassword(), info.getFullName(),
					info.getPhoneNo(), info.getEmail()));
			return new ResponseEntity<>(information, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	// To update data of ORDER table by passing orderNumber
	public ResponseEntity<Order> updateOrderInfo(int orderNumber) {
		// TODO Auto-generated method stub
		Optional<Order> optional = orderRepository.findById(orderNumber);

		if (optional.isPresent()) {
			Order info = (Order) optional.get();
			info.setOrderItems((info.getOrderItems()));
			return new ResponseEntity<>(orderRepository.save(info), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// To delete Order Details by passing orderNumber to ORDER Table
	public ResponseEntity<Order> deleteorderDetails(int orderNumber) {
		// TODO Auto-generated method stub
		Optional<Order> optional = orderRepository.findById(orderNumber);
		if (optional.isPresent()) {
			orderRepository.deleteById(orderNumber);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
