package com.anGit.andminpage.controller;

import com.anGit.andminpage.domain.Item;
import com.anGit.andminpage.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String itemList(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "item/itemlist";
    }

    @GetMapping("/{itemId}")
    public String itemInfo(@PathVariable long itemId, Model model) {
        Optional<Item> item = itemRepository.findById(itemId);
        model.addAttribute("item", item.get());
        return "item/item";
    }

    @PostConstruct
    public void init() {

        itemRepository.save(new Item("itemA", 1000, 10));
        itemRepository.save(new Item("itemB", 2000, 20));
        itemRepository.save(new Item("itemC", 3000, 30));
    }
}
