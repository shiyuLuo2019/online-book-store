package com.bookstore.bookstore.service;


import com.bookstore.bookstore.domain.BillingAddress;
import com.bookstore.bookstore.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
