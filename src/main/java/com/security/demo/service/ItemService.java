package com.security.demo.service;


import com.security.demo.dto.ItemDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface ItemService {

    ItemDTO createItem(ItemDTO itemDTO);

    Page<ItemDTO> getAllItems(LocalDate filterFromDate,
                              LocalDate filterToDate,
                              int page,
                              int size);

    ItemDTO updateItem(Long id, ItemDTO itemDTO);

    Boolean deleteItem(Long id);

    Page<ItemDTO> getItemsBySearchParam(String searchParam,
                                        int pageNo,
                                        int pageSize);
}
