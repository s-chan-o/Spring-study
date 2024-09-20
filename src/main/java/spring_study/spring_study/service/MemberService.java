package spring_study.spring_study.service;

import org.springframework.stereotype.Service;
import spring_study.spring_study.domain.Member;
import spring_study.spring_study.repository.MemberRepository;
import spring_study.spring_study.repository.MemoryMemberRepository;
import java.util.Optional;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    public long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                 .ifPresent(m -> {
                     throw new IllegalStateException("이미 존재하는 회원입니다.");
                 });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(long memberId) {
        return memberRepository.findById(memberId);
    }

}
