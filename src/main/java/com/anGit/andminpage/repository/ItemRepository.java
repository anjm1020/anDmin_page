package com.anGit.andminpage.repository;

import com.anGit.andminpage.domain.Item;
import com.anGit.andminpage.dto.ItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);
    Item update(Item item);
    boolean delete(Long id);
    Optional<Item> findById(Long id);
    List<Item> findAll();
}
