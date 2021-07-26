package br.com.mercadinho.Mercadinho.Repository;


import br.com.mercadinho.Mercadinho.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
