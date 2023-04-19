package com.example.advanced.entity.member;

import com.example.advanced.repository.member.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.UUID;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class MemberTests {

    @Autowired
    private MemberDAO memberDAO;

//    추가
    @Test
    public void saveTest(){
        Member member=  new Member();
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMemberAddress("경기도 하남시");
        memberAddress.setMemberAddressDetail("미사");
        memberAddress.setMemberPostcode("1234");

        member.setMemberAddress(memberAddress);
        member.setMemberEmail("hds1234@naver.com");
        member.setMemberPassword("1234");
        member.setMemberId("hds1234");

        for (int i = 0; i < 5; i++) {
            File file = new File();

            file.setFileUuid(UUID.randomUUID().toString());
            file.setFileSize(1024L + Long.valueOf(i + 1));
            file.setFilePath("/upload/" + i);
            file.setFileName("이미지" + i + ".png");
            file.setMember(member);
            memberDAO.save(file);
        }
    }

    @Test
    public void findByIdTest(){
        memberDAO.findById(1L).map(File::toString).ifPresent(log::info);
    }

    @Test
    public void findAllTest(){
    }
}
