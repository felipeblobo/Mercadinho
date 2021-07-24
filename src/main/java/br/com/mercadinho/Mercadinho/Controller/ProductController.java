package br.com.mercadinho.Mercadinho.Controller;

import br.com.mercadinho.Mercadinho.Model.Product;
import br.com.mercadinho.Mercadinho.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @GetMapping("products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product ) {
        return repository.save(product);

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

