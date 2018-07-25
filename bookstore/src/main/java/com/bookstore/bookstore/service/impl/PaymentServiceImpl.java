package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.domain.Payment;
import com.bookstore.bookstore.domain.UserPayment;
import com.bookstore.bookstore.service.PaymentService;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
		payment.setType(userPayment.getType());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardNumber(userPayment.getCardNumber());
		payment.setExpiryMonth(userPayment.getExpireMonth());
		payment.setExpiryYear(userPayment.getExpireYear());
		payment.setCvc(userPayment.getCvc());
		
		return payment;
	}

}
