package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.Clientes;
import com.fretes.lancamentofretes.models.TableCliente;
import com.fretes.lancamentofretes.models.TableFretes;
import com.fretes.lancamentofretes.models.Veiculo;
import com.fretes.lancamentofretes.repository.TableFretesRepository;
import com.fretes.lancamentofretes.view.model.TableFretesPostRequest;
import com.fretes.lancamentofretes.view.model.TableFretesResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TableFretesService {
    
    ModelMapper modelMapper = new ModelMapper();

    private final TableFretesRepository tableFretesRepository;
    private final VeiculoService veiculoService;
    private final ClientesService clientesService;
    

    public List<TableFretesResponse> getAllTableFretes() {

        List<TableFretes> tableFretes = tableFretesRepository.findAll();

        List<TableFretesResponse> tableFretesResponses = tableFretes.stream()
                .map(tblFrete -> modelMapper.map(tblFrete, TableFretesResponse.class))
                .collect(Collectors.toList());

        return tableFretesResponses;
    }

    public TableFretesResponse getTableFretesResponseById(Long tblFreteId) {

        Optional<TableFretes> tableFretes = tableFretesRepository.findById(tblFreteId);


        if (tableFretes.isEmpty()) {
            // adicionar throw
        }
        TableFretesResponse tableFretesResponse = modelMapper.map(tableFretes, TableFretesResponse.class);

        return tableFretesResponse;
    }

    public TableFretes getTableFretesById(Long tblFreteId) {

        Optional<TableFretes> tableFretes = tableFretesRepository.findById(tblFreteId);


        if (tableFretes.isEmpty()) {
            // adicionar throw
        }

        return tableFretes.get();
    }

    public TableFretesResponse create(TableFretesPostRequest tableFretesPostRequest) {

        Veiculo veiculo = veiculoService.getVeiculoById(tableFretesPostRequest.getVeiculoId());

        Clientes cliente = clientesService.getClientesEntityById(tableFretesPostRequest.getClientesId());

        Optional<TableCliente> tableClienteOptional = cliente.getTableClientes().stream()
                .filter(tblCliente -> tblCliente.getEixo().equals(veiculo.getEixo()))
                .findFirst();

        if (tableClienteOptional.isEmpty()) {
            // adicionar throw
        }

        TableCliente tableCliente = tableClienteOptional.get();

        
        Double vlrDiaria = tableCliente.getDiaria() * tableFretesPostRequest.getDiasViagem();

        Double vlrKmRodado = tableCliente.getValorKm() * tableFretesPostRequest.getKmRodado();

        tableFretesPostRequest.setValorFrete(vlrDiaria + vlrKmRodado);

        TableFretes tableFretes = modelMapper.map(tableFretesPostRequest, TableFretes.class);

        tableFretes.setClientes(cliente);
        tableFretes.setVeiculo(veiculo);


        tableFretesRepository.save(tableFretes);

        // TableFretes tableFretes = TableFretes.builder()
        //         .clientes(cliente)
        //         .veiculo(veiculo)
        //         .build();

        return modelMapper.map(tableFretes, TableFretesResponse.class);
    }
}
