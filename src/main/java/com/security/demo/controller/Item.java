package com.security.demo.controller;

import com.security.demo.dto.ItemDTO;
import com.security.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<ItemDTO> response = itemService.getAllItems(pageNo, pageSize);
        return ResponseEntity.ok(response);
    }



}
