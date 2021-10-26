package sungmin.hellosungmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungmin.hellosungmin.aop.TimeTraceAop;
import sungmin.hellosungmin.repository.*;

// 자바코드로 직접 빈 스코프를 설정 Controller는 냅둬야함..
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//  public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        // return new JpaMemberRepository(em);
//    }
}
