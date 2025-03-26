package com.security.demo.service;


import com.security.demo.dto.ItemDTO;
import org.springframework.data.domain.Page;


public interface ItemService {

    ItemDTO createItem(ItemDTO itemDTO);

    Page<ItemDTO> getAllItems(int page, int size);

    ItemDTO updateItem(Long id, ItemDTO itemDTO);

    Boolean deleteItem(Long id);
}
