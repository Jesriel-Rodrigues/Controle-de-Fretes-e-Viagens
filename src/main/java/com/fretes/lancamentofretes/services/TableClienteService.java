package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.entities.Clientes;
import com.fretes.lancamentofretes.models.entities.Eixo;
import com.fretes.lancamentofretes.models.entities.TableCliente;
import com.fretes.lancamentofretes.repository.TableClienteRepository;
import com.fretes.lancamentofretes.view.model.TableClientePostRequest;
import com.fretes.lancamentofretes.view.model.TableClienteResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TableClienteService {

    ModelMapper modelMapper = new ModelMapper();
    
    private final TableClienteRepository tableClienteRepository;
    private final ClientesService clientesService;
    private final EixoService eixoService;

    public List<TableClienteResponse> getAllTableClientes() {

        List<TableCliente> tableClientes = tableClienteRepository.findAll();
        
        return tableClientes.stream()
                    .map(tableCliente -> modelMapper.map(tableCliente, TableClienteResponse.class))
                    .collect(Collectors.toList());
    }


    public TableClienteResponse getTableClientesResponseById(Long tableClienteId) {

        Optional<TableCliente> tableCliente  = tableClienteRepository.findById(tableClienteId);

        if (tableCliente.isEmpty()) {
            // adicionar throw
        }

        return modelMapper.map(tableCliente.get(), TableClienteResponse.class);
    }

    public TableCliente getTableClientesById(Long tableClienteId) {

        Optional<TableCliente> tableCliente  = tableClienteRepository.findById(tableClienteId);

        if (tableCliente.isEmpty()) {
            // adicionar throw
        }

        return tableCliente.get();
    }

    public TableClienteResponse create(TableClientePostRequest tableClientePost) {
        
        Clientes cliente = clientesService.getClientesEntityById(tableClientePost.getClientesId());

        Eixo eixo = eixoService.getEixoEntityById(tableClientePost.getEixoId());

        TableCliente tableCliente = modelMapper.map(tableClientePost, TableCliente.class);

        tableCliente.setClientes(cliente);

        tableCliente.setEixo(eixo);

        tableClienteRepository.save(tableCliente);

        TableClienteResponse tableClienteResponse = modelMapper.map(tableCliente, TableClienteResponse.class);

        return tableClienteResponse;
    }
}
