package com.services.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.spring.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> getClients() {
		return getAllClientes();
	}
	
	@GetMapping(path = "/{id}", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente getClient(@PathVariable int id) {
		return new Cliente(id, "Martin", "Cardenas", 79, "VACJ930901", "Lazaro Cardenas 8", "55667788");
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			     produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> saveClientREntity(@RequestBody Cliente cliente) {
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> updateClient(@RequestBody Cliente cliente, @PathVariable int id){
		return new ResponseEntity<Cliente>(cliente, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public  ResponseEntity<String> deleteClient(@PathVariable int id) {
		return new ResponseEntity<String>("Se elimino el cliente "+ id, HttpStatus.OK);
	}
	
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = new ArrayList<>();
		Cliente c = new Cliente(1, "Jesus", "Vazquez", 29, "VACJ930901", "Lazaro Cardenas 8", "55667788");
		Cliente c1 = new Cliente(2, "Marco", "Polo", 49, "VACJ930901", "Lazaro Cardenas 8", "55667788");
		Cliente c2 = new Cliente(3, "Gabriel", "Cardenas", 19, "VACJ930901", "Lazaro Cardenas 8", "55667788");
		Cliente c3 = new Cliente(4, "Martin", "Cardenas", 79, "VACJ930901", "Lazaro Cardenas 8", "55667788");
		clientes.add(c);
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		return clientes;
	}
}
