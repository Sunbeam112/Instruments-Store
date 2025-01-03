package com.example.demo.service;

import com.example.demo.model.Instrument;
import com.example.demo.model.dao.InstrumentDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    private InstrumentDAO instrumentsDAO;


    public InstrumentService(InstrumentDAO instrumentsDAO) {
        this.instrumentsDAO = instrumentsDAO;
    }

    public List<Instrument> getInstruments() {
        return instrumentsDAO.findAll();
    }
}
