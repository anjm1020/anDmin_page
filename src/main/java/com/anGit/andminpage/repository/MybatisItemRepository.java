package com.anGit.andminpage.repository;

import com.anGit.andminpage.domain.Item;
import com.anGit.andminpage.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisItemRepository implements ItemRepository {

    private final ItemMapper itemMapper;
//    private static Long sequence = 0L;

    @Override
    public Item save(Item item) {
//        item.setId(++sequence);
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
