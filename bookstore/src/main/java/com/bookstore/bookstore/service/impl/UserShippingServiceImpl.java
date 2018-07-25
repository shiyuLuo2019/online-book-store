package com.bookstore.bookstore.service.impl;


import com.bookstore.bookstore.domain.UserShipping;
import com.bookstore.bookstore.repository.UserShippingRepository;
import com.bookstore.bookstore.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserShippingServiceImpl implements UserShippingService {
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	@Override
	public UserShipping findById(Long id) {
		Optional<UserShipping> optionalUserShipping = userShippingRepository.findById(id);
		return (optionalUserShipping.isPresent()) ? optionalUserShipping.get() : null;
	}

	@Override
	public void removeById(Long id) {
		userShippingRepository.deleteById(id);
	}

}
