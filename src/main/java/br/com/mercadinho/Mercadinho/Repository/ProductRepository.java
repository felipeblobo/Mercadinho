package br.com.mercadinho.Mercadinho.Repository;

import br.com.mercadinho.Mercadinho.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
