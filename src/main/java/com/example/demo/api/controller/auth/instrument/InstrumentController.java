package com.example.demo.api.controller.auth.instrument;

import com.example.demo.model.Instrument;
import com.example.demo.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/instrument")
@RestController
public class InstrumentController{

    @Autowired
    private InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping
    public List<Instrument> getAllInstruments() {
        return instrumentService.getInstruments();
    }
}
