package hanghae.study.frameworkstudybeforecourse.controller;

import hanghae.study.frameworkstudybeforecourse.dto.req.LoginReqDto;
import hanghae.study.frameworkstudybeforecourse.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public void login(HttpServletResponse res, ModelAndView mav, LoginReqDto loginReqDto) {
        memberService.login(res, mav, loginReqDto);
    }
}