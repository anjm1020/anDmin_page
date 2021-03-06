package com.anGit.andminpage.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class ItemDto {

    @Getter @Setter @ToString
    @RequiredArgsConstructor
    public static class EditForm {
        private String name;
        private Integer price;
        private Integer quantity;
    }
}
