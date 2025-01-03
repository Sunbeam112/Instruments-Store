package com.example.demo.model.dao;

import com.example.demo.model.Instrument;
import org.springframework.data.repository.ListCrudRepository;

public interface InstrumentDAO extends ListCrudRepository<Instrument, Long>{

}
