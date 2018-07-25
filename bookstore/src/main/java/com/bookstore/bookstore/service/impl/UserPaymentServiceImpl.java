package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.domain.User;
import com.bookstore.bookstore.domain.UserPayment;
import com.bookstore.bookstore.repository.UserPaymentRepository;
import com.bookstore.bookstore.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	private UserPaymentRepository userPaymentRepository;

	@Override
	public UserPayment findById(Long id) {
		Optional<UserPayment> optionalUserPayment = userPaymentRepository.findById(id);
		return optionalUserPayment.isPresent() ? optionalUserPayment.get() : null;
	}


	@Override
	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}

} 
