package com.anGit.andminpage;

import com.anGit.andminpage.domain.Item;
import com.anGit.andminpage.mapper.ItemMapper;
import com.anGit.andminpage.repository.ItemRepository;
import com.anGit.andminpage.repository.MemoryItemRepository;
import com.anGit.andminpage.repository.MybatisItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

    private final ApplicationContext ac;

    @Bean
    public ItemRepository itemRepository() {
        return new MybatisItemRepository(itemMapper());
    }

    public ItemMapper itemMapper() {
        return ac.getBean(ItemMapper.class);
    }
}
