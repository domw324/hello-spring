package hello.hello_spring.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;

class MemberServiceTest {
	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach
	public void beforeEach() {
		// 의존성 주입(Dependency Injection): 서비스 객체가 자신이 의존하는 리포지토리 객체의 구현체를 직접 생성하지 않고, 외부에서 전달받아 사용하는 설계방식
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void 회원가입() {
		Member member = new Member();
		member.setName("hello");

		Long saveId = memberService.join(member);

		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void 중복_회원_예외() {
		Member member1 = new Member();
		member1.setName("spring");

		Member member2 = new Member();
		member2.setName("spring");

		memberService.join(member1);
		/* 이 부분을 아래처럼 표현 가능하다
		try {
			memberService.join(member2); // 중복 이름 회원 가입 시도
			fail("예외가 발생해야 합니다.");
		} catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
		*/
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // 이렇게 쓰면 try-catch 문 없이 예외 처리 가능
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}

	@Test
	void testFindOne() {

	}

	@Test
	void testJoin() {

	}
}
