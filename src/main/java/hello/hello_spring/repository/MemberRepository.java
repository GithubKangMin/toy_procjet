package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //레포지토리 네가지 기능
    Member save(Member member);// save 회원 저장
    Optional<Member> findById(Long id);// 아이디 찾기
    Optional<Member> findByName(String name);

    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트

}
