package com.example.test.Member;

import com.example.test.entity.member.Challenge;
import com.example.test.entity.member.Member;
import com.example.test.repository.MemberDAO;
import com.example.test.type.ChallengeStatusType;
import com.example.test.type.MemberStatusType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void saveTest(){

        Member  member = new Member();


        Challenge challenge1 = new Challenge();
        Challenge challenge2 = new Challenge();

        challenge1.setChallengeContent("테스트 제목1");
        challenge1.setChallengeStatus(ChallengeStatusType.PUBLIC);
        challenge1.setChallengeTitle("테스트 내용!");

        challenge2.setChallengeContent("테스트 제목1");
        challenge2.setChallengeStatus(ChallengeStatusType.PUBLIC);
        challenge2.setChallengeTitle("테스트 내용!2");

        member.setMemberStatus(MemberStatusType.NORMAL);
        member.setName("임종욱");
        member.setPassword("1234");
        member.setPhoneNumber("01012341234");


        member.getChallenges().add(challenge1);
        member.getChallenges().add(challenge2);

        memberDAO.save(member);
    }

//    조회
    @Test
    public void findById() {
        memberDAO.findById(1L).map(Member::toString).ifPresent(log::info);
    }

//    전체 조회
    @Test
    public void findAllTest() {
        memberDAO.findAll().stream().map(Member::toString).forEach(log::info);
    }


}
