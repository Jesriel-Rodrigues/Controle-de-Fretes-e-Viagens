package com.fretes.lancamentofretes.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.services.EixoService;
import com.fretes.lancamentofretes.shared.EixoDTO;
import com.fretes.lancamentofretes.view.model.EixoRequest;
import com.fretes.lancamentofretes.view.model.EixoResponse;



@RestController
@RequestMapping("/eixos")
public class EixoController {

    ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    EixoService eixoService;

    @GetMapping
    public List<EixoResponse> getAllEixos() {

        List<EixoDTO> eixoDtos = eixoService.getAllEixos();
        
        return eixoDtos.stream()
            .map(eixo -> modelMapper.map(eixo, EixoResponse.class))
            .collect(Collectors.toList());
    }

    @GetMapping("/{eixoId}")
    public EixoResponse getEixoById(@PathVariable Long eixoId) {
        
        return eixoService.getEixoById(eixoId);
    }


    @PostMapping
    public EixoResponse createEixo(@RequestBody EixoRequest eixoRequest) {

        EixoDTO eixoDto = eixoService.createEixo(eixoRequest);
        EixoResponse eixoResponse = modelMapper.map(eixoDto, EixoResponse.class);

        eixoResponse.setEixoId(eixoDto.getEixoId());

        return eixoResponse;
    }
}
