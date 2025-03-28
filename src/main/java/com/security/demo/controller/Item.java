package com.security.demo.controller;

import com.security.demo.dto.ItemDTO;
import com.security.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@RestController
public class Item {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    public ResponseEntity<ItemDTO> createNewItem(
            @RequestBody ItemDTO itemDTO
    ){
        ItemDTO response = itemService.createItem(itemDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/items")
    public ResponseEntity<Page<ItemDTO>> getAllItems(
            @RequestParam(required = true) LocalDate filterFromDate,
            @RequestParam(required = true)LocalDate filterToDate,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<ItemDTO> response = itemService.getAllItems(
                filterFromDate,
                filterToDate,
                pageNo,
                pageSize);
        return ResponseEntity.ok(response);
    }

    //create an API for Update Item
    @PutMapping("/item/{id}/update")
    public ResponseEntity<ItemDTO> updateItem(
            @PathVariable Long id,
            @RequestBody ItemDTO itemDTO
    )
    {
        ItemDTO response = itemService.updateItem(id, itemDTO);
        return ResponseEntity.ok(response);
    }

    //API for Delete Item
    @DeleteMapping("/item/{id}/delete")
    public ResponseEntity<Boolean> deleteItem(
            @PathVariable Long id
    )
    {
        Boolean isDeleted = itemService.deleteItem(id);
        return ResponseEntity.ok(isDeleted);
    }

}
