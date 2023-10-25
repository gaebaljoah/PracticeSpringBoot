package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional 사용하면 null이어도 반환가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
                //store를 끝까지 루프 돌리면서 검색하려는 name 과 일치하는 게 있을 경우 그 값을 반환한다.
                //null이면 null반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    
    //test 케이스 작성하기
}
