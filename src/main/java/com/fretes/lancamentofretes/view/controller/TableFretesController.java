package com.fretes.lancamentofretes.view.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.services.TableFretesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tableFretes")
@RequiredArgsConstructor
public class TableFretesController {

    private final TableFretesService tableFretesService;
    
}
