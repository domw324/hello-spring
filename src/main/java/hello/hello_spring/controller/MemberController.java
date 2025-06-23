package hello.hello_spring.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hello_spring.service.MemberService;

@Controller
public class MemberController {
	private final MemberService memberService;
	
	// @Autowired // Component scan: 컨테이너에 있는 MemberService를 가져와서 자동으로 주입
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}
