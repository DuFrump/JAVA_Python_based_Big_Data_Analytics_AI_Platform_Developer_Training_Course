package com.example.newboard.web.view;

import com.example.newboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 애플리케이션의 상태를 점검(Probe)하기 위한 테스트용 컨트롤러입니다.
 * @RestController 어노테이션을 사용하여, View 페이지가 아닌 데이터(여기서는 게시글 개수)를 직접 반환합니다.
 */
@RestController
@RequiredArgsConstructor
public class ProbeController {

    private final ArticleRepository repo; // 게시글 개수를 조회하기 위해 ArticleRepository를 주입받습니다.

    /**
     * "/probe/count" 경로로 GET 요청이 오면, 현재 데이터베이스에 저장된 총 게시글의 수를 반환합니다.
     *
     * 이와 같은 엔드포인트는 애플리케이션이 정상적으로 실행되고 데이터베이스와 잘 연결되어 있는지
     * 외부 모니터링 시스템에서 간단히 확인하는 용도(Health Check)로 사용될 수 있습니다.
     *
     * @return 전체 게시글의 수 (long 타입)
     */
    @GetMapping("/probe/count")
    public long count() {
        return repo.count();
    }
}
