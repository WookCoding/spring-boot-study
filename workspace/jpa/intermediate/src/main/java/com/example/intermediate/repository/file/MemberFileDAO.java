package com.example.intermediate.repository.file;

import com.example.intermediate.entity.file.MemberFile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberFileDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public MemberFile save(MemberFile memberFile){
        entityManager.persist(memberFile);
        return memberFile;
    }

//    조회
    public Optional<MemberFile> findById(Long id){
//        상속관계에 있어서는 하나의 엔티티를 조회하더라도 자동으로 부모 테이블과 JOIN된다.
        return Optional.ofNullable(entityManager.find(MemberFile.class, id));
    }

//    전체 조회
    public List<MemberFile> findAll(){
//        상속관계에 있어서는 하나의 엔티티를 조회하더라도 자동으로 부모 테이블과 JOIN된다.
        String query = "select m from MemberFile m";
        return entityManager.createQuery(query, MemberFile.class).getResultList();
    }

//    삭제
    public void delete(MemberFile memberFile){
        entityManager.remove(memberFile);
    }

}

