package com.example.springassignment.controller;

import com.example.springassignment.model.Inventory;
import com.example.springassignment.services.CsvService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/csv")
public class SearchController {
    private final CsvService filterService;

    public SearchController(CsvService filterService) {
        this.filterService = filterService;
    }

    @RequestMapping(value = "service/{id}",method = RequestMethod.GET)
    public List<Inventory> findById(@PathVariable("id")String id, @RequestParam(name = "product" , defaultValue = "") String product,
                                    @RequestParam(name="exp",defaultValue = "true") boolean notexp, @RequestParam(name="page",defaultValue = "0")int page,
                                    @RequestParam(name="size",defaultValue = "10")int size){

        return filterService.findAllByName(id,product,notexp, PageRequest.of(page,size));
    }
}
