package com.fretes.lancamentofretes.view.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.services.TableFretesService;
import com.fretes.lancamentofretes.view.model.TableFretesPostRequest;
import com.fretes.lancamentofretes.view.model.TableFretesResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tableFretes")
@RequiredArgsConstructor
public class TableFretesController {

    private final TableFretesService tableFretesService;
    
    @PostMapping
    public TableFretesResponse create(@RequestBody TableFretesPostRequest tableFretesPostRequest) {
        return tableFretesService.create(tableFretesPostRequest);
    }
}
