package com.cart.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.demo.entity.Cart;
import com.cart.demo.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Long userId, String seatNumber, int baggageCount) {
    	
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setSeatNumber(seatNumber);
        cart.setBaggageCount(baggageCount);
        return cartRepository.save(cart);
    }
}
