package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.Clientes;
import com.fretes.lancamentofretes.repository.ClientesRepository;
import com.fretes.lancamentofretes.shared.ClienteDTO;

@Service
public class ClientesService {

    ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    ClientesRepository clientesRepository;
    
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

    public ClienteDTO cadastraCliente(ClienteDTO clienteDto) {
        Clientes cliente = modelMapper.map(clienteDto, Clientes.class);
        clientesRepository.save(cliente);
        return clienteDto;
    }

    public void deleteClienteById(Long clienteId) {
        clientesRepository.deleteById(clienteId);
    }


}
