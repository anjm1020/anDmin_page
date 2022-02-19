package com.anGit.andminpage.repository;


import com.anGit.andminpage.domain.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    private final ItemRepository itemRepository = new MemoryItemRepository();

    @BeforeEach
    void beforeEach() {
        ((MemoryItemRepository) itemRepository).clearStore();
    }

    @Test
    @DisplayName("save item on memoryRepository")
    void saveItem() {
        Item itemA = new Item("itemA", 1000, 10);

        Item saved = itemRepository.save(itemA);

        assertThat(saved).isEqualTo(itemA);
    }

    @Test
    @DisplayName("find item on memoryRepository")
    void findItem() {
        Item itemA = new Item("itemA", 1000, 10);
        itemRepository.save(itemA);
        Item itemB = new Item("itemB", 2000, 20);
        itemRepository.save(itemB);

        Optional<Item> found = itemRepository.findById(itemA.getId());

        assertThat(found.get()).isEqualTo(itemA);
    }

    @Test
    @DisplayName("find all item on memortRepository")
    public void findAll() {
        Item itemA = new Item("itemA", 1000, 10);
        itemRepository.save(itemA);
        Item itemB = new Item("itemB", 2000, 20);
        itemRepository.save(itemB);

        List<Item> list = itemRepository.findAll();

        assertThat(list.size()).isEqualTo(2);
        assertThat(list).contains(itemA, itemB);
    }
}