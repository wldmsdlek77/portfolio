package com.board.domain.post;

import com.board.common.dto.SearchDto;
import com.board.common.paging.Pagination;
import com.board.common.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor // 클래스 내에 final로 선언된 모든 멤버에 대한 생성자를 만들어 줌
public class PostService {

    private final PostMapper postMapper;

    // 게시글 저장
    @Transactional // 메서드의 실행과 동시에 트랜잭션 실행, 메서드의 정상 종료 여부에 따라 Commit 또는 Rollback
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId(); // 생성된 게시글 id
    }

    // 게시글 상세 조회
    public PostResponse findPostById(final Long id) {
        // 조회수 증가
        postMapper.updateViewCnt(id);
        return postMapper.findById(id);
    }

    // 게시글 수정
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    // 게시글 삭제
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }


    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {

        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
        int count = postMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }
}
