package com.example.newboard.web.view;

import com.example.newboard.service.UserService;
import com.example.newboard.web.dto.JoinRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 사용자 인증(로그인, 회원가입)과 관련된
 * 화면(View)을 보여주는 '뷰 컨트롤러(View Controller)'입니다.
 *
 * @Controller: "이 클래스는 웹 요청을 처리하고, 사용자에게 보여줄 화면(View)을 반환하는 컨트롤러입니다."
 *              라고 스프링에게 알려주는 어노테이션입니다.
 */
@Controller
@RequiredArgsConstructor
public class AuthViewController {
    private final UserService userService;

    /**
     * "/login" 경로로 GET 요청이 오면, "login.html" 뷰를 반환합니다.
     * @return "login" 뷰 이름
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * "/join" 경로로 GET 요청이 오면, 회원가입 폼("join.html")을 보여줍니다.
     *
     * @param model View에 데이터를 전달하기 위한 Model 객체
     * @return "join" 뷰 이름
     */
    @GetMapping("/join")
    public String joinForm(Model model) {
        // 타임리프(Thymeleaf)의 th:object를 활용하기 위해,
        // 비어있는 JoinRequest 객체를 "joinRequest"라는 이름으로 모델에 담아 View로 전달합니다.
        model.addAttribute("joinRequest", new JoinRequest());
        return "join";
    }

    /**
     * "/join" 경로로 POST 요청이 오면, 실제 회원가입 로직을 처리합니다.
     *
     * @param joinRequest    @ModelAttribute를 통해 HTTP 요청 파라미터들이 자동으로 바인딩된 JoinRequest DTO 객체.
     *                       @Valid 어노테이션을 통해 JoinRequest에 정의된 유효성 검증(예: @NotBlank, @Email)을 수행합니다.
     * @param br             BindingResult 객체. @Valid 어노테이션의 유효성 검증 결과를 담고 있습니다.
     * @param model          View에 데이터를 전달하기 위한 Model 객체
     * @return               성공 시 로그인 페이지로 리다이렉트, 실패 시 다시 회원가입 폼을 보여줍니다.
     */
    @PostMapping("/join")
    public String join(@Valid @ModelAttribute JoinRequest joinRequest, BindingResult br, Model model) {
        // 1. 유효성 검증(Validation)
        // BindingResult(br)에 에러가 있는지 확인합니다. (예: 필수값이 비어있거나, 이메일 형식이 아니거나)
        if (br.hasErrors()) {
            // 만약 에러가 있다면, 다시 회원가입 폼("join.html")으로 돌려보냅니다.
            // 이때, 사용자가 입력했던 데이터와 유효성 검증 에러 메시지가 자동으로 View에 전달됩니다.
            return "join";
        }

        // 2. 회원가입 서비스 호출
        try {
            // 유효성 검증을 통과했다면, UserService의 join() 메소드를 호출하여 실제 회원가입 로직을 수행합니다.
            userService.join(joinRequest);
        } catch (IllegalArgumentException e) {
            // 3. 예외 처리
            // 만약 서비스 로직에서 이메일 중복과 같은 이유로 IllegalArgumentException이 발생하면,
            // 에러 메시지를 모델에 담아 다시 회원가입 폼으로 돌려보냅니다.
            model.addAttribute("error", e.getMessage());
            return "join";
        }

        // 4. 성공 시 리다이렉트
        // 모든 과정이 성공적으로 끝나면, 로그인 페이지로 리다이렉트(Redirect)합니다.
        return "redirect:/login";
    }
}



