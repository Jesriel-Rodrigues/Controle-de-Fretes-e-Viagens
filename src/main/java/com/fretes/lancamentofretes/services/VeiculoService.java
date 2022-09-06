package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.Eixo;
import com.fretes.lancamentofretes.models.Veiculo;
import com.fretes.lancamentofretes.repository.EixoRepository;
import com.fretes.lancamentofretes.repository.VeiculoRepositoty;
import com.fretes.lancamentofretes.view.model.VeiculoPostRequest;
import com.fretes.lancamentofretes.view.model.VeiculoPutRequest;
import com.fretes.lancamentofretes.view.model.VeiculoResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    ModelMapper modelMapper = new ModelMapper();
    
    private final VeiculoRepositoty veiculoRepositoty;

    private final EixoRepository eixoRepository;


    public List<VeiculoResponse> getAllVeiculos() {

        List<VeiculoResponse> veiculos = veiculoRepositoty.findAll().stream()
            .map(veiculo -> modelMapper.map(veiculo, VeiculoResponse.class))
            .collect(Collectors.toList());
        return veiculos;
    }


    public VeiculoResponse getVeiculoResponseById(Long veiculoId) {
        Optional<Veiculo> veiculo = veiculoRepositoty.findById(veiculoId);

        if (veiculo.isEmpty()) {
            // retornar throw
        }
        return modelMapper.map(veiculo.get(), VeiculoResponse.class);
    }

    public Veiculo getVeiculoById(Long veiculoId) {
        Optional<Veiculo> veiculo = veiculoRepositoty.findById(veiculoId);

        if (veiculo.isEmpty()) {
            // retornar throw
        }
        return veiculo.get();
    }

    public VeiculoResponse create(VeiculoPostRequest veiculoPostRequest) {

        Veiculo veiculo = modelMapper.map(veiculoPostRequest, Veiculo.class);

        Eixo eixo = eixoRepository.findById(veiculoPostRequest.getEixoId()).get();

        veiculo.setEixo(eixo);

        veiculo = veiculoRepositoty.save(veiculo);

        VeiculoResponse veiculoResponse = modelMapper.map(veiculo, VeiculoResponse.class);

        return veiculoResponse;
    }

    public VeiculoResponse update(VeiculoPutRequest veiculoPutRequest, Long veiculoId) {

        Veiculo veiculo = getVeiculoById(veiculoId);

        veiculoPutRequest.setVeiculoId(veiculoId);

        veiculo = modelMapper.map(veiculoPutRequest, Veiculo.class);

        Eixo eixo = eixoRepository.findById(veiculoPutRequest.getEixoId()).get();

        veiculo.setEixo(eixo);

        veiculoRepositoty.save(veiculo);

        return modelMapper.map(veiculo, VeiculoResponse.class);
    }

    public void deleteVeiculo(Long veiculoId) {
        
        Veiculo veiculo = getVeiculoById(veiculoId);

        veiculoRepositoty.delete(veiculo);        
    }
}
