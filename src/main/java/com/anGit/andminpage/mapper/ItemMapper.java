package com.anGit.andminpage.mapper;

import com.anGit.andminpage.domain.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {

    @Insert("INSERT INTO " +
            "item(name,price,quantity) " +
            "values(#{name},#{price},#{quantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Item item);

    @Update("UPDATE item " +
            "SET name=#{name}, price=${price}, quantity=#{quantity} " +
            "WHERE id=${id}")
    int update(Item item);

    @Select("SELECT * FROM item")
    List<Item> findAll();

    @Select("SELECT * FROM item WHERE id=#{itemId}")
    Item findById(@Param("itemId") Long id);
}
