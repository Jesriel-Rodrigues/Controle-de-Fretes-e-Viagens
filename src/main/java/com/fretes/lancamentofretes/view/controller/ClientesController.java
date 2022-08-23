package com.fretes.lancamentofretes.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.services.ClientesService;
import com.fretes.lancamentofretes.shared.ClienteDTO;
import com.fretes.lancamentofretes.view.model.ClienteRequest;
import com.fretes.lancamentofretes.view.model.ClienteResponse;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ClientesService clientesService;


    @PostMapping
    public ClienteResponse cadastraCliente(@RequestBody ClienteRequest clienteRequest) {
        // ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        ClienteDTO clienteDTO = clientesService.cadastraCliente(clienteRequest);
        ClienteResponse clienteResponse = modelMapper.map(clienteDTO, ClienteResponse.class);
        return clienteResponse;
    }

    @GetMapping
    public List<ClienteResponse> getAllClientes() {
        List<ClienteDTO> clienteDTOs = clientesService.getAllClientes();
        return clienteDTOs.stream()
                .map(clienteDTO-> modelMapper.map(clienteDTO, ClienteResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{clienteId}")
    public ClienteResponse getClientesById(@PathVariable Long clienteId){
        ClienteDTO clienteDTO = clientesService.getClientesById(clienteId);
        ClienteResponse clienteResponse = modelMapper.map(clienteDTO, ClienteResponse.class);
        return clienteResponse;
    }

    @DeleteMapping("/{clienteId}")
    public void deleteClienteById(@PathVariable Long clienteId) {
        clientesService.deleteClienteById(clienteId);
    }
}
