package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.Clientes;
import com.fretes.lancamentofretes.repository.ClientesRepository;

@Service
public class ClientesService {
    
    @Autowired
    ClientesRepository clientesRepository;
    
    public List<Clientes> getAllClientes() {
        List<Clientes> clientlist = clientesRepository.findAll();
        return clientlist;
    }

    public Clientes getClientesById(Long clientId) throws Exception {
        Optional<Clientes> cliente = clientesRepository.findById(clientId.longValue());

        if (cliente.isEmpty()) {
            throw new Exception("cliente nao existe !");
        }
        return cliente.get();
    }

    public Clientes cadastraCliente(Clientes cliente) {
        clientesRepository.save(cliente);
        return cliente;
    }

    public void deleteClienteById(Long clienteId) {
        clientesRepository.deleteById(clienteId);
    }


}
