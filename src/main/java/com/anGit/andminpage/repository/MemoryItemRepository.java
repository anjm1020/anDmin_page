package com.anGit.andminpage.repository;

import com.anGit.andminpage.domain.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryItemRepository implements ItemRepository{

    private final static ConcurrentMap<Long, Item> store = new ConcurrentHashMap<>();
    private final static AtomicLong sequence = new AtomicLong(1);

    @Override
    public Item save(Item item) {
        item.setId(sequence.get());
        store.put(item.getId(), item);
        sequence.set(sequence.get() + 1);
        return item;
    }

    @Override
    public Item update(Item item) {
        Item updated = store.get(item.getId());
        updated.setName(item.getName());
        updated.setPrice(item.getPrice());
        updated.setQuantity(item.getQuantity());

        return updated;
    }

    @Override
    public boolean delete(Long id) {
        if (!store.containsKey(id)) {
            return false;
        }
        store.remove(id);
        return true;
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * Method For Testing
     */
    public void clearStore() {
        store.clear();
    }
}
