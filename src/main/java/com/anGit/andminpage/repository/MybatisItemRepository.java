package com.anGit.andminpage.repository;

import com.anGit.andminpage.domain.Item;
import com.anGit.andminpage.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MybatisItemRepository implements ItemRepository {

    private final ItemMapper itemMapper;

    @Override
    public Item save(Item item) {
        itemMapper.save(item);
        return item;
    }

    @Override
    public Item update(Item item) {
        itemMapper.update(item);
        return item;
    }

    @Override
    public boolean delete(Long id) {
        return itemMapper.delete(id);
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
