package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //어노테이션 선언시 스프링 컨테이너에서 관리 컨테이너에서 관리하니 스프링관련된 기능들이 작동하는것이다.
public class MemberController {

    private final MemberService memberService;


    //컨트롤러가 서비를 통해 회원가입을하고 조회할 수 있어야함 이것을 의존관계라한다.
    //이 작업을 스프링스럽게 해보자.
    @Autowired  //스프링 컨테이너에 등록합시다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
