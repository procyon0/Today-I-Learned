package hello.hellospring.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@Transactional
@Service
public class MemberService {
//	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/*
	 * 회원 리포지토리의 코드가 회원 서비스 코드를 DI 가능하게 변경한다.
	 */
	private final MemberRepository memberRepository;

	/*
	 * 의존성 주입(DI)
	 * 회원 서비스 스프링 빈 등록
	 */
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/*
	 * 회원 가입
	 */
	public Long join(Member member) throws SQLException {
		validateDuplicateMember(member); // 중복 회원 검증
		memberRepository.save(member);
		return member.getId();
	}

	/*
	 * 중복 회원 검증
	 */
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	/*
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/*
	 * 회원 한 명 조회
	 */
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
