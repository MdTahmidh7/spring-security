package com.security.demo.service.impl;


import com.security.demo.dto.ItemDTO;
import com.security.demo.entity.Item;
import com.security.demo.mapper.ItemMapper;
import com.security.demo.repo.ItemRepository;
import com.security.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {

        Item item = itemMapper.toEntity(itemDTO);
        return itemMapper.toDTO(itemRepository.save(item));
    }

    @Override
    public Page<ItemDTO> getAllItems(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Item> items = itemRepository.findAll(pageable);

        return items.map(itemMapper::toDTO);
    }

    @Override
    public ItemDTO updateItem(Long id, ItemDTO itemDTO) {

        if (!itemRepository.existsById(id)) {
            throw new IllegalArgumentException("Item not found");
        }

        Item item = itemMapper.toEntity(itemDTO);
        //item.setId(id);
        return itemMapper.toDTO(itemRepository.save(item));

    }

    @Override
    public Boolean deleteItem(Long id) {

        Optional<Item> itemOptional = itemRepository.findById(id);

        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setIsDeleted(true);
            itemRepository.save(item);
            return true;
        } else {
            return false;
        }
    }
}
