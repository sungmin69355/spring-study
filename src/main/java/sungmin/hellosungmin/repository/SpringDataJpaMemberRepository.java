package sungmin.hellosungmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungmin.hellosungmin.domain.Member;

import java.util.Optional;

//스프링이 인터페이스를 찾아서 구현
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
