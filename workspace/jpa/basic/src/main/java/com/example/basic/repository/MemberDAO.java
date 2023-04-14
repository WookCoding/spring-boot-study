package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberDAO {
//    1. application.yml파일에 작성된 Connection 정보를 통해 EntityManageFactory가 생성된다.
//    2. EntityManageFactory를 통해 EntityManager객체가 생성된다.
    @PersistenceContext // EntityManager를 통해서 생성된 Entity객체를 등록되는 영역
    private EntityManager entityManager; // EntityManageFactory를 통해 생성되며, Connection 객체를 통해 SQL문을 제작해준다.

//    등록
    public Member save(Member member){
        entityManager.persist(member);
        return member;
    }

//    PK로 조회
    public Optional<Member> findById(Long id){
//         Optional은 Null이 아니기 때문에 NPE를 방지할 수 있으며,
//         필드로 들어간 엔티티의 NULL 검사를 편하게 할 수 있는 API이다.
//         단, Optional 사용은 리턴 타입에서만 사용하는 것을 권장한다.
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

//    삭제
    public void delete(Member member){
        entityManager.remove(member);
    }
    
}
