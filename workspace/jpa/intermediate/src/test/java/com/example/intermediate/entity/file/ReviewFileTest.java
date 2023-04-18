package com.example.intermediate.entity.file;

import com.example.intermediate.repository.file.ReviewFileDAO;
import com.example.intermediate.type.FileType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class ReviewFileTest {

    @Autowired
    private ReviewFileDAO reviewFileDAO;

    @Test
    public void saveTest(){
        ReviewFile reviewFile = new ReviewFile();
        reviewFile.setFileSize(1024L);
        reviewFile.setFileType(FileType.IMAGE);
        reviewFile.setName("테스트.png");
        reviewFile.setFilePath("2023/04/29");
        reviewFile.setUuid(UUID.randomUUID().toString());

        reviewFileDAO.save(reviewFile);
    }

    @Test
    public void findByIdTest(){
        reviewFileDAO.findById(1L).map(File::toString).ifPresent(log::info);
    }

    @Test
    public void findAllTest() {
        reviewFileDAO.findAll().stream().map(File::getName).forEach(log::info);
    }

    @Test
    public void updateTest() {
        reviewFileDAO.findById(1L).ifPresent(reviewFile -> reviewFile.setName("안녕.png"));
    }

    @Test
    public void deleteTest() {
        reviewFileDAO.findById(1L).ifPresent(reviewFileDAO::delete);
    }
}
