package com.fretes.lancamentofretes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fretes.lancamentofretes.models.Eixo;
import com.fretes.lancamentofretes.repository.EixoRepository;
import com.fretes.lancamentofretes.shared.EixoDTO;
import com.fretes.lancamentofretes.view.model.EixoRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EixoService {


    ModelMapper modelMapper = new ModelMapper();

    private final EixoRepository eixoRepository;



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

    public Eixo getEixoEntityById( Long id) {
        
        Optional<Eixo> eixo = eixoRepository.findById(id);

        if (eixo.isEmpty()) {
            // throw
        }

        return eixo.get();
    }

    public EixoDTO createEixo(EixoRequest eixoRequest) {
        

        Eixo eixo = modelMapper.map(eixoRequest, Eixo.class);

        eixoRepository.save(eixo);

        EixoDTO eixoDto = modelMapper.map(eixo, EixoDTO.class);
        eixoDto.setEixoId(eixo.getEixoId());
        return eixoDto;
        
    }

    public void deleteEixoById(Long id) {
        eixoRepository.deleteById(id);        
    }
}
