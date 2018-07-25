package com.bookstore.bookstore.repository;


import com.bookstore.bookstore.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
