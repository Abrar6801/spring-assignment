package com.example.springassignment.services;

import com.example.springassignment.model.Inventory;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CsvService {

    public List<Inventory> findAllByName(String id, String product, boolean exp, PageRequest pageRequest);
}
