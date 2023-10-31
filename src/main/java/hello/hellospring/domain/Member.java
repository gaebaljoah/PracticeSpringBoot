package hello.hellospring.domain;

import javax.persistence.*;

@Entity //jpa가 관리하는 entity라고 표현
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //pk를 mapping @GeneratedValue(strategy = GenerationType.IDENTITY) = sequence 개념
    private Long id;

    @Column(name="username") //컬럼을 매핑
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
