package portfolio.one.Item.service;

import lombok.Data;

import java.util.List;

@Data
public class ItemVO {

    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;

}
