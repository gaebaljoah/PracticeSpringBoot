package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;//static import Alt+Enter add~ 클릭

public class MemoryMemberRepositoryTest {

    //TDD   : 테스트 주도 개발 -> 테스트 틀을 먼저 생성한 후 구현 클래스 및 메소드를 생성
    //JUnit : 구현 클래스 및 메소드 생성 후 테스트 코드 작성

    MemoryMemberRepository repository = new MemoryMemberRepository();
    //클래스 전체 테스트를 하면 각 메소드마다 서로 영향을 끼치기때문에
    //올바른 테스트를 할 수 없다. 그래서 하나의 메소드가 끝나면 값을 초기화할 메소드를 추가해야한다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();//매우 중요함
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
        System.out.printf(result.toString());
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
        System.out.printf(result.toString());
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("MemeberList...?" + result.get(i).toString());
        }
        assertThat(result.size()).isEqualTo(2);
    }
}
