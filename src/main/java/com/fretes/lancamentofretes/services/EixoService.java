package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.Clientes;
import com.fretes.lancamentofretes.models.Eixo;
import com.fretes.lancamentofretes.repository.EixoRepository;
import com.fretes.lancamentofretes.shared.ClienteDTO;
import com.fretes.lancamentofretes.shared.EixoDTO;
import com.fretes.lancamentofretes.view.model.EixoRequest;

@Service
public class EixoService {


    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    EixoRepository eixoRepository;

    @Autowired
    ClientesService clientesService;


    public List<EixoDTO> getAllEixos() {
        
        List<Eixo> eixos = eixoRepository.findAll();

        return eixos.stream()
            .map(eixo -> modelMapper.map(eixo, EixoDTO.class))
            .collect(Collectors.toList());
    }

    
    public EixoDTO getEixoById( Long id) {
        
        Optional<Eixo> eixo = eixoRepository.findById(id);

        return modelMapper.map(eixo.get(), EixoDTO.class);
    }

    public EixoDTO createEixo(EixoRequest eixoRequest) {


        ClienteDTO clienteDto = clientesService.getClientesById(eixoRequest.getClienteId());

        Clientes cliente = modelMapper.map(clienteDto, Clientes.class);

        

        Eixo eixo = modelMapper.map(eixoRequest, Eixo.class);

        eixo.setCliente(cliente);

        eixoRepository.save(eixo);

        EixoDTO eixoDto = modelMapper.map(eixo, EixoDTO.class);
        eixoDto.setEixoId(eixo.getEixoId());
        return eixoDto;
        
    }

    public void deleteEixoById(Long id) {
        eixoRepository.deleteById(id);        
    }
}
