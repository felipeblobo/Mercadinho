package br.com.mercadinho.Mercadinho.Repository;

import br.com.mercadinho.Mercadinho.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
