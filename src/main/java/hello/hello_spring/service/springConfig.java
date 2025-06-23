package hello.hello_spring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

@Configuration
public class springConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
