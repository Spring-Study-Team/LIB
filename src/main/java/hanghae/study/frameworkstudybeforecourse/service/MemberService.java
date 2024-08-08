package hanghae.study.frameworkstudybeforecourse.service;

import hanghae.study.frameworkstudybeforecourse.dto.req.LoginReqDto;
import hanghae.study.frameworkstudybeforecourse.entity.Member;
import hanghae.study.frameworkstudybeforecourse.repository.MemberRepository;
import hanghae.study.frameworkstudybeforecourse.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    public MemberService(MemberRepository memberRepository, JwtUtil jwtUtil) {
        this.memberRepository = memberRepository;
        this.jwtUtil = jwtUtil;
    }

    @Transactional(readOnly = true)
    public void login(HttpServletResponse res, ModelAndView mav, LoginReqDto loginReqDto) {
        log.info("loginReqDto = {}", loginReqDto);
        Member member = memberRepository.findByUserNameAndPw(loginReqDto.getUserName(), loginReqDto.getPw())
                                        .orElseThrow(
                                                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
                                        );

        mav.setViewName("welcome");
        mav.addObject("member", member);

        res.addHeader(JwtUtil.AUTH_HEADER, jwtUtil.createToken(member));
    }
}
