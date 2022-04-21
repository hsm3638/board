package portfolio.one.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import portfolio.one.board.service.BoardVO;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    List<BoardVO> selectBoardList();
    BoardVO selectBoardDetail(int boardIdx);
    void insertBoard(BoardVO board);
    void updateBoard(BoardVO board);
    void updateHitCnt(int boardIdx);
    void deleteBoard(int boardIdx);
}
