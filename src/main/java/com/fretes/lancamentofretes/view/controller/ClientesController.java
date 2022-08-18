package com.fretes.lancamentofretes.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.models.Clientes;
import com.fretes.lancamentofretes.services.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    
    @Autowired
    ClientesService clientesService;


    @PostMapping
    public Clientes cadastraCliente(@RequestBody Clientes cliente) {
        clientesService.cadastraCliente(cliente);
        return cliente;
    }

    @GetMapping
    public List<Clientes> getAllClientes() {
        return clientesService.getAllClientes();
    }

    @GetMapping("/{clienteId}")
    public Clientes getAllClientes(@PathVariable Long clienteId) throws Exception {
        return clientesService.getClientesById(clienteId);
    }

    @DeleteMapping("/{clienteId}")
    public void deleteClienteById(@PathVariable Long clienteId) {
        clientesService.deleteClienteById(clienteId);
    }
}
