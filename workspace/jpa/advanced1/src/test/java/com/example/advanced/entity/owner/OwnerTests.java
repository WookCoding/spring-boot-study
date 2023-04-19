package com.example.advanced.entity.owner;

import com.example.advanced.entity.board.Board;
import com.example.advanced.repository.owner.OwnerDAO;
import com.example.advanced.type.PetDiseaseType;
import com.example.advanced.type.PetGenderType;
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
public class OwnerTests {

    @Autowired
    private OwnerDAO ownerDAO;

    @Test
    public void saveTest(){
        Owner owner = new Owner();

        Pet pet1 = new Pet();
        Pet pet2 = new Pet();

        pet1.setPetDiseaseType(PetDiseaseType.CHIHUAHUA);
        pet1.setPetName("뽀삐1");
        pet1.setPetGenderType(PetGenderType.MAN);

        pet2.setPetDiseaseType(PetDiseaseType.BEAGLE);
        pet2.setPetName("장군1");
        pet2.setPetGenderType(PetGenderType.WOMAN);

        owner.getPets().add(pet1);
        owner.getPets().add(pet2);

        owner.setOwnerName("임종욱");
        owner.setOwnerPhoneNumber("01012341234");

        ownerDAO.save(owner);
    }

    @Test
    public void findByIdTest(){
        ownerDAO.findById(1L).map(Owner::toString).ifPresent(log::info);
    }

    @Test
    public void findAllTest(){
        ownerDAO.findAll().stream().map(Owner::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        ownerDAO.findById(1L).ifPresent(owner -> owner.getPets().get(0).setPetDiseaseType(PetDiseaseType.BEAGLE));
    }

    @Test
    public void deleteTest(){
        ownerDAO.findById(1L).ifPresent(ownerDAO::delete);
    }

}
