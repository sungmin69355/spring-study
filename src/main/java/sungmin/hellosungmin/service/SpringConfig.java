package sungmin.hellosungmin.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungmin.hellosungmin.domain.Member;
import sungmin.hellosungmin.repository.*;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

// 자바코드로 직접 빈 스코프를 설정 Controller는 냅둬야함..
@Configuration
public class SpringConfig {

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    private EntityManager em;

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
