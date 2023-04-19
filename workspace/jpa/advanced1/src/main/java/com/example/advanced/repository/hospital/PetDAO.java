package com.example.advanced.repository.hospital;

import com.example.advanced.entity.hospital.Pets;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class PetDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //    추가
    public Pets save(Pets pet){
        entityManager.persist(pet);
        return pet;
    }

    //    조회
    public Optional<Pets> findById(Long id){
        return Optional.ofNullable(entityManager.find(Pets.class, id));
//        String query = "select p from Pet p join fetch p.owner where p.id = :id";
//        return Optional.ofNullable(
//                entityManager
//                        .createQuery(query, Pet.class)
//                        .setParameter("id", id)
//                        .getSingleResult());
    }

    //    전체 조회
    public List<Pets> findAll(){
        String query = "select p from Pet p join fetch p.owner";
        return entityManager.createQuery(query, Pets.class).getResultList();
    }

    //    삭제
    public void delete(Pets pet){
        entityManager.remove(pet);
    }

}







