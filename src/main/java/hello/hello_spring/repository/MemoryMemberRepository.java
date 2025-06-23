package hello.hello_spring.repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hello.hello_spring.domain.Member;

// @Repository // Component scan으로 자동으로 주입방식 해제
public class MemoryMemberRepository implements MemberRepository {
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id)); // null이 반환될 가능성이 있으면 Optional.ofNullable()
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(member -> member.getName().equals(name))
				.findAny(); // 하나라도 찾으면 반환, 없으면 Optional.empty()
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public void clearStore() {
		store.clear();
		sequence = 0L;
	}
}
