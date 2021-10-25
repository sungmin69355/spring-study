package sungmin.hellosungmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungmin.hellosungmin.domain.Member;
import sungmin.hellosungmin.repository.MemberRepository;
import sungmin.hellosungmin.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService { //순수자바 클래스라 스프링이 모른다. @Service를 사용해줘야함

    private final MemberRepository memberRepository;

    //@Autowired 생성자를 통해서 주입한다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long join(Member member){
        //같은 이름이 있는 중복 회원 x
        validateDuplicateMember(member); //중복회원검증
        memberRepository.save(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /*
    * 전체 회원 조회
    */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
