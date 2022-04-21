package portfolio.one.board.service;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
public class BoardVO {

    private int boardIdx;
    @NotEmpty
    private String title;
    @NotEmpty
    private String contents;
    private int hitCnt;
    private String creatorId;
    private Timestamp createdDatetime;
    private String updaterId;
    private Timestamp updatedDatetime;
    private Boolean updateYn;

}
