package br.com.mercadinho.Mercadinho.Controller;

import br.com.mercadinho.Mercadinho.Model.Product;
import br.com.mercadinho.Mercadinho.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    ProductRepository repository;

    @GetMapping("/product")
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @GetMapping("product/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
    }

    @PatchMapping("/product/{id}")
    public HttpEntity<? extends Object> updateProduct(@PathVariable Long id, @RequestBody Product newProduct ) {
        Optional<Product> oldProduct = repository.findById(id);
        if(oldProduct.isPresent()) {
            Product product = oldProduct.get();
            product.setDescription(newProduct.getDescription());
            product.setProvider(newProduct.getProvider());
            product.setPrice(newProduct.getPrice());
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

