package com.fretes.lancamentofretes.view.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.services.TableClienteService;
import com.fretes.lancamentofretes.view.model.TableClientePostRequest;
import com.fretes.lancamentofretes.view.model.TableClienteResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tableClientes")
@RequiredArgsConstructor
public class TableClienteController {

    private final TableClienteService tableClienteService;
    
    @GetMapping
    public List<TableClienteResponse> getAllTableClientes() {
        return tableClienteService.getAllTableClientes();
    }


    @GetMapping("/{tableClienteId}")
    public TableClienteResponse getTableClientesResponseById(@PathVariable Long tableClienteId) {
        return tableClienteService.getTableClientesResponseById(tableClienteId);
    }

    @PostMapping
    public TableClienteResponse create(@RequestBody TableClientePostRequest tableClientePost) {
        return tableClienteService.create(tableClientePost);
    }
}
