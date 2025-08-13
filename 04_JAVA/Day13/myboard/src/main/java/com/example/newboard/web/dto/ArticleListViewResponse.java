package com.example.newboard.web.dto;

import com.example.newboard.domain.Article;
import lombok.Getter;

/**
 * '게시글 목록 조회' 응답 시 각 게시글의 정보를 담아서 클라이언트에게 보낼 때 사용하는 DTO 입니다.
 * 목록 화면에서는 모든 정보(특히 용량이 큰 content)가 필요하지 않을 수 있습니다.
 * 이처럼 화면에 딱 필요한 데이터만 담아서 보내주면, 네트워크 트래픽을 줄이고 성능을 향상시킬 수 있습니다.
 * 이를 통해 Entity(Article)의 모든 정보가 외부에 불필요하게 노출되는 것을 막는 효과도 있습니다.
 */
@Getter
public class ArticleListViewResponse {

    private final Long id;
    private final String title;

    /**
     * Article 엔티티를 파라미터로 받아서, 목록 표시에 필요한 데이터(id, title)만 추출하여
     * ArticleListViewResponse 객체를 생성하는 생성자입니다.
     * 서비스 계층에서 이 생성자를 호출하여 Entity 리스트를 DTO 리스트로 쉽게 변환할 수 있습니다.
     *
     * @param article 변환할 원본 Article 엔티티 객체
     */
    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
    }
}
