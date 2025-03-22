package com.cart.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.demo.entity.Cart;
import com.cart.demo.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam("userId") Long userId, 
                                          @RequestParam("seatNumber") String seatNumber, 
                                          @RequestParam("baggageCount") int baggageCount) {
        return ResponseEntity.ok(cartService.addToCart(userId, seatNumber, baggageCount));
    }

}
