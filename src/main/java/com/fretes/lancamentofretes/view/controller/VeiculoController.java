package com.fretes.lancamentofretes.view.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.services.VeiculoService;
import com.fretes.lancamentofretes.view.model.VeiculoPostRequest;
import com.fretes.lancamentofretes.view.model.VeiculoResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {
    
    private final VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoResponse> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{veiculoId}")
    public VeiculoResponse getVeiculoResponseById(@PathVariable Long veiculoId) {
        return veiculoService.getVeiculoResponseById(veiculoId);
    }

    @PostMapping
    public VeiculoResponse create(@RequestBody VeiculoPostRequest veiculoPostRequest) {
        return veiculoService.create(veiculoPostRequest);
    }

    @DeleteMapping
    public void deleteVeiculo(Long veiculoId) {
        veiculoService.deleteVeiculo(veiculoId);
    }
}
