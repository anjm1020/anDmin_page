package com.anGit.andminpage.domain;

import com.anGit.andminpage.dto.ItemDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Item {

    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(ItemDto.EditForm editForm) {
        name = editForm.getName();
        price = editForm.getPrice();
        quantity = editForm.getQuantity();
    }
}
