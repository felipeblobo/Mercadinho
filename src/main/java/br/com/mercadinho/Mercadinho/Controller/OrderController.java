package br.com.mercadinho.Mercadinho.Controller;

import br.com.mercadinho.Mercadinho.Model.Order;
import br.com.mercadinho.Mercadinho.Repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OrderController {

    OrderRepository repository;

    @GetMapping("/order")
    public List<Order> getOrders(){
        return repository.findAll();
    }


    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return new ResponseEntity<>(repository.save(order), HttpStatus.CREATED);
    }
}
