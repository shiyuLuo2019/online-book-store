package com.bookstore.bookstore.repository;


import com.bookstore.bookstore.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
