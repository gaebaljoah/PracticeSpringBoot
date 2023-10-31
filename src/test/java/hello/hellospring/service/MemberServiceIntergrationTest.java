package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest //test할떄 스프링부트 테스트 어노테이션만 추가하면됨
//@Transactional //트랜잭셔널 어노테이션 -> 테스트 끝나고 다 롤백시켜버림.
class MemberServiceIntergrationTest {

    //테스트 케이스는 필드 의존성 주입으로 해도 괜찮다.
    //기존 코드들은 생성자 주입이 좋음.
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);
        System.out.println("saveId...?"+saveId);
        //then
        Member findMember = memberService.findOne(saveId).get();
        System.out.println("findMember...?"+findMember);
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void exceptionDuplicateMember(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*
        try {
            memberService.join(member2);
            fail();
        } catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
        }
*/

        //then

    }

}