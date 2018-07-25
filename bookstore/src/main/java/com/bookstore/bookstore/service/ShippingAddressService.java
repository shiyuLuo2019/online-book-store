package com.bookstore.bookstore.service;


import com.bookstore.bookstore.domain.ShippingAddress;
import com.bookstore.bookstore.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
