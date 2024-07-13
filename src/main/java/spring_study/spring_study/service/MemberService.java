package spring_study.spring_study.service;

import spring_study.spring_study.domain.Member;
import spring_study.spring_study.repository.MemberRepository;
import spring_study.spring_study.repository.MemoryMemberRepository;

import java.util.Optional;
import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    public long join(Member member) {
        //같은 이름이 있는 중복 회원X
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        memberRepository.save(member);
        return member.getId();
    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findMember(long memberiId) {
        return memberRepository.findById(memberiId);
    }

}
