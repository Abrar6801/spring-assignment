package com.example.springassignment.services;

import com.example.springassignment.model.Inventory;
import com.example.springassignment.repository.InventoryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsvServiceImpl implements CsvService{

    private final InventoryRepository inventoryRepository;
    public CsvServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> findAllByName(String id, String product, boolean exp , PageRequest pageRequest) {
        if(exp) {
            return inventoryRepository.findAllRecords(id, product,pageRequest);
        }
        else{
            return inventoryRepository.findAllByName(id, product,pageRequest);
        }

    }
}
