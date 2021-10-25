package sungmin.hellosungmin.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungmin.hellosungmin.domain.Member;
import sungmin.hellosungmin.repository.JdbcMemberRepository;
import sungmin.hellosungmin.repository.JdbcTemplateMemberRepository;
import sungmin.hellosungmin.repository.MemberRepository;
import sungmin.hellosungmin.repository.MemoryMemberRepository;

import javax.sql.DataSource;

// 자바코드로 직접 빈 스코프를 설정 Controller는 냅둬야함..
@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
