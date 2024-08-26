package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 콜백메서드 메서드 끝날 때마다 작동 // 테스트는 메서드는 간의 순서는 없어야 한다. 그래서 다 지워주는 거임
    public void afterEach() {
        repository.clearStore();

    }

    @Test
    public void save() { // 메인메서드 쓰듯이 하면 됨
        Member member = new Member();
        member.setName("spiring");

        repository.save(member); // 레포지토리에 저장

        Member result = repository.findById(member.getId()).get(); // get으로 꺼내고 검증
//        System.out.println("result = " + (result == member)); // 같은지만 확인하는 것 -> assert를 쓰면 글자까지 확인가능
//        Assertions.assertEquals(member, result); // (기대하는 값, 실제값) 오른쪽과 다르면 run했을 때 초록 체크 나옴
        Assertions.assertThat(member).isEqualTo(result);
    }
    @Test // member12 spring 12 가입된 것임.
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();


        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName(("spring1"));
        repository.save(member1);

        Member member2 = new Member();
        member2.setName(("spring2"));
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
