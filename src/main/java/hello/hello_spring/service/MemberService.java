package hello.hello_spring.service;

import java.util.List;
import java.util.Optional;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;

// class 선택하고 `Ctrl+Shift+P` 누르고 "Java:Go to test" 누르면 테스트 파일 생성 가능.
// intelliJ IDE 에서는 더 디테일하게 설정 가능

// @Service // Component scan으로 자동으로 주입방식 해제
public class MemberService {
	private final MemberRepository memberRepository;

	// @Autowired // Component scan: 컨테이너에 있는 MemberService를 가져와서 자동으로 주입
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/* 회원 가입 */
	public Long join(Member member) {
		// 같은 이름이 있는 회원 허용 X
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		/* 이 부분을 아래처럼 표현 가능하다.
		Optional<Member> result = memberRepository.findByName(member.getName());
		result.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
		*/
		memberRepository.findByName(member.getName())
			.ifPresent(m -> { // 이렇게 한번에 쓰면 Optional 타입을 벗겨낼 수 있다.
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}

	/* 전체 회원 조회 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/* 특정 회원 조회 */
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
