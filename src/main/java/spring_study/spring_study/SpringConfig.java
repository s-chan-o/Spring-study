package spring_study.spring_study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_study.spring_study.repository.MemberRepository;
import spring_study.spring_study.repository.MemoryMemberRepository;
import spring_study.spring_study.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
