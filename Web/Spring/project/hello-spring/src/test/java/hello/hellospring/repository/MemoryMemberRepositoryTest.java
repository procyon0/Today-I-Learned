package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

public class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		// given
		Member member = new Member();
		member.setName("mokoko");
		
		// when
		repository.save(member);
		
		// then
		Member result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
		
	}
	
	@Test
	public void findByName() {
		// given
		Member member1 = new Member();
		member1.setName("mokoko");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("mokoko2");
		repository.save(member2);
				
		// when
		Member result = repository.findByName("mokoko").get();
		
		// then
		assertThat(result).isEqualTo(member1);
	}
}
