package portfolio.one.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import portfolio.one.board.dao.BoardMapper;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper boardMapper;

    public List<BoardVO> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    public BoardVO selectBoardDetail(int boardIdx) {
        return boardMapper.selectBoardDetail(boardIdx);
    }

    public void insertBoard(BoardVO board) {
        boardMapper.insertBoard(board);
    }

    public void updateBoard(BoardVO board) {
        boardMapper.updateBoard(board);
    }

    public void updateHitCnt(int boardIdx) {
        boardMapper.updateHitCnt(boardIdx);
    }

    public void deleteBoard(int boardIdx) {
        boardMapper.deleteBoard(boardIdx);
    }
}
