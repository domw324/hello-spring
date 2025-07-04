package hello.hello_spring.repository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat; // static import -> 클래스명 생략 가능
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hello_spring.domain.Member;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach // 각 테스트 메소드 실행 후 자동으로 실행
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		// Assertions.assertEquals(member, result); // 방법 1: assertEquatls(expected:기대값, actual:실제값)
		assertThat(member).isEqualTo(result); // 방법 2: assertThat(actual:기대값).isEqualTo(expected:실제값)
	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member result = repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		List<Member> result = repository.findAll();
		assertThat(result.size()).isEqualTo(2);
	}
}
