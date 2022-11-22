package com.example.springassignment.repository;

import com.example.springassignment.model.Inventory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    @Query("SELECT c FROM Inventory c WHERE (c.supplier=?1 and c.name like %?2%)")
    public List<Inventory> findAllRecords(String name, String product, PageRequest pageRequest);
    @Query("SELECT c FROM Inventory c WHERE (c.supplier=?1 and c.name like %?2% and CURRENT_TIMESTAMP <= c.exp)")
    public List<Inventory> findAllByName(String name, String product,PageRequest pageRequest);

}
