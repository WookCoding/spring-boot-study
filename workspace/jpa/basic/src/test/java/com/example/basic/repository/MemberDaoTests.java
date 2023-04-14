package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import com.example.basic.domain.entity.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional // 필드 안에 있는 모든 메소드에 트랜잭션이 각각 생긴다.
@Rollback(false)
public class MemberDaoTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void saveTests() {
        Member member = new Member();

        member.setMemberName("임종욱");
        member.setMemberEmail("ljw1234@naver.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);
        memberDAO.save(member);
    }

    @Test
    public void updateTest(){
        Member member = new Member();

        member.setMemberName("임종욱2");
        member.setMemberEmail("ljw12345@naver.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        member = memberDAO.save(member);

        member.setMemberAge(21);

        memberDAO.save(member);
    }

    @Test
    public void deleteTests(){
        Member member = new Member();

        member.setMemberName("임종욱3");
        member.setMemberEmail("ljw122345@naver.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        member = memberDAO.save(member);

        memberDAO.delete(member);
    }

    @Test
    public void findByIdTest(){
        Optional<Member> optionalMember = memberDAO.findById(1L);
//        Member member = optionalMember.orElse(new Member());
//        Member member = optionalMember.orElseGet(Member::new);

//        if(optionalMember.isPresent()){
//            optionalMember.get();
//        }

//        optionalMember.ifPresent(member -> assertThat(member.getMemberName()).isEqualTo("임종욱"));// 값이 있을 때만 실행되는 메소드

//        assertThat(member.getMemberName()).isEqualTo("임종욱");
    }
}
