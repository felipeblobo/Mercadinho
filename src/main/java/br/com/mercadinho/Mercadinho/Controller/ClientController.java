package br.com.mercadinho.Mercadinho.Controller;


import br.com.mercadinho.Mercadinho.Model.Client;
import br.com.mercadinho.Mercadinho.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ClientController {

    ClientRepository repository;

    @GetMapping("/client")
    public List<Client> getClients(){
        return repository.findAll();
    }

    @GetMapping("/client/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client){
        return repository.save(client);
    }

    @PutMapping("/client/{id}")
    public HttpEntity<? extends Object> updateClient(@PathVariable Long id, @RequestBody Client newClient) {
        Optional<Client> oldClient = repository.findById(id);
        if(oldClient.isPresent()){
            Client client = oldClient.get();
            client.setName(newClient.getName());
            client.setCpf(newClient.getCpf());
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Long> deleteClient(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
