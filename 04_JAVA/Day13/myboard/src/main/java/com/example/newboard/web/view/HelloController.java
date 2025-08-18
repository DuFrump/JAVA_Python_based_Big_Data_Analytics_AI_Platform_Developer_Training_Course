package com.example.newboard.web.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 간단한 테스트용 'REST 컨트롤러'입니다.
 *
 * @RestController 어노테이션은 @Controller와 @ResponseBody를 합친 것입니다.
 * 이 어노테이션이 붙은 클래스의 모든 메소드는 View(HTML 페이지)를 반환하는 대신,
 * 메소드의 반환값(여기서는 "ok", "잘가요~" 같은 문자열)을 HTTP 응답 본문(Response Body)에
 * 직접 써서 클라이언트에게 전달합니다.
 *
 * 주로 JSON이나 XML 형태의 데이터를 반환하는 RESTful API를 만들 때 사용됩니다.
 */
@RestController
public class HelloController {

    /**
     * "/hello" 경로로 GET 요청이 오면, "ok"라는 문자열을 응답 본문에 담아 반환합니다.
     * @return "ok" 문자열
     */
    @GetMapping("/hello")
    public String hello() {
        return "ok";
    }

    /**
     * "/bye" 경로로 GET 요청이 오면, "잘가요~"라는 문자열을 응답 본문에 담아 반환합니다.
     * @return "잘가요~" 문자열
     */
    @GetMapping("/bye")
    public String bye() {
        return "잘가요~";
    }
}
