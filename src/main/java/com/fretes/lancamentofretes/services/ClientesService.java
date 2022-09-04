package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.Clientes;
import com.fretes.lancamentofretes.repository.ClientesRepository;
import com.fretes.lancamentofretes.shared.ClienteDTO;
import com.fretes.lancamentofretes.view.model.ClienteRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientesService {

    ModelMapper modelMapper = new ModelMapper();
    
    private final ClientesRepository clientesRepository;
    
    public List<ClienteDTO> getAllClientes() {
        List<Clientes> clientlist = clientesRepository.findAll();

        List<ClienteDTO> clienteDTOs = clientlist.stream()
            .map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).collect(Collectors.toList());

        return clienteDTOs;
    }

    public ClienteDTO getClientesById(Long clientId){
        Optional<Clientes> cliente = clientesRepository.findById(clientId.longValue());
        ClienteDTO clienteDTO = modelMapper.map(cliente.get(), ClienteDTO.class);

        return clienteDTO;
    }

    public ClienteDTO cadastraCliente(ClienteRequest clienteRequest) {
        Clientes cliente = modelMapper.map(clienteRequest, Clientes.class);
        cliente = clientesRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public void deleteClienteById(Long clienteId) {
        clientesRepository.deleteById(clienteId);
    }


}
