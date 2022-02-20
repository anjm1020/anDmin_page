package com.anGit.andminpage.repository;

import com.anGit.andminpage.domain.Item;
import com.anGit.andminpage.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MybatisItemRepository implements ItemRepository {

    private final ItemMapper itemMapper;

    @Override
    public Item save(Item item) {
        int savedId = itemMapper.save(item);
        return item;
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(itemMapper.findById(id));
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }
}
