package com.bookstore.bookstore.service;

import com.bookstore.bookstore.domain.Payment;
import com.bookstore.bookstore.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
