package com.example.demo.model.dao;


import com.example.demo.model.LocalUser;
import com.example.demo.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder,Long> {

    List<WebOrder> findByUser(LocalUser user);
}
