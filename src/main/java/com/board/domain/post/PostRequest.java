package com.board.domain.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostRequest {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private Long writerId;
    private Boolean noticeYn;
    private List<MultipartFile> files = new ArrayList<>();
    private List<Long> removeFileIds = new ArrayList<>(); // 삭제할 첨부파일 id List
}
