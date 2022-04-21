package portfolio.one.Item.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import portfolio.one.Item.service.ItemVO;

@Mapper
@Repository
public interface ItemMapper {
    void save(ItemVO item);
    ItemVO findByItemId(Long id);
}
