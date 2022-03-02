package com.anGit.andminpage.controller;

import com.anGit.andminpage.domain.Item;
import com.anGit.andminpage.dto.ItemDto;
import com.anGit.andminpage.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("mode", "add");
        return "item/editForm";
    }

    @PostMapping("/add")
    public String saveItem(@ModelAttribute ItemDto.EditForm editForm,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        Item item = new Item(editForm);
        Item saved = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", saved.getId());
        model.addAttribute("item", saved);

        return "redirect:/items/{itemId}";
    }

    @GetMapping("/edit/{itemId}")
    public String editItem(@PathVariable long itemId, Model model) {
        Optional<Item> item = itemRepository.findById(itemId);
        model.addAttribute("item", item.get());
        model.addAttribute("mode", "edit");
        return "item/editForm";
    }

    @PostMapping("/edit/{itemId}")
    public String editSaveItem(@PathVariable long itemId,
                               ItemDto.EditForm editForm,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        Item item = itemRepository.findById(itemId).get();
        item.setName(editForm.getName());
        item.setPrice(editForm.getPrice());
        item.setQuantity(editForm.getQuantity());

        model.addAttribute("item", item);
        redirectAttributes.addAttribute("itemId", item.getId());
        return "redirect:/items/{itemId}";
    }

    @PostConstruct
    public void init() {
//
//        itemRepository.save(new Item("itemA", 1000, 10));
//        itemRepository.save(new Item("itemB", 2000, 20));
//        itemRepository.save(new Item("itemC", 3000, 30));
    }
}
