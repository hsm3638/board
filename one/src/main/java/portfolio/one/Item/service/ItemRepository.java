package portfolio.one.Item.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import portfolio.one.Item.dao.ItemMapper;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final Map<Long, ItemVO> store = new HashMap<>();
    private final ItemMapper itemMapper;

    private long sequence = 0L;

    public ItemVO save(ItemVO item) {
        item.setId(++sequence);
        log.info("save: item={}", item);
        itemMapper.save(item);
        return item;
    }
    
    public ItemVO findById(Long id) {
        return itemMapper.findByItemId(id);
    }

}
