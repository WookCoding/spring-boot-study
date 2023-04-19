package com.example.advanced.repository.owner;

import com.example.advanced.entity.board.Board;
import com.example.advanced.entity.owner.Owner;
import com.example.advanced.entity.owner.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class OwnerDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    // 주인 추가
    public Owner save(Owner owner){
        entityManager.persist(owner);
        return owner;
    }

    // 펫 추가
    public Pet save(Pet pet){
        entityManager.persist(pet);
        return pet;
    }

    // 주인 조회
    public Optional<Owner> findById(Long id){
        String query = "select o from Owners o join fetch o.pets where o.id = :id";
        return Optional.ofNullable(
                entityManager
                        .createQuery(query, Owner.class)
                        .setParameter("id", id)
                        .getSingleResult());
    }

    // 펫 조회
    public Optional<Pet> findPetById(Long id){
        return Optional.ofNullable(entityManager.find(Pet.class, id));
    }

    // 전체 조회
    public List<Owner> findAll(){
        String query = "select o from Owners o";
        return entityManager.createQuery(query, Owner.class).getResultList();
    }

    // 삭제
    public void delete(Owner owner){
        entityManager.remove(owner);
    }
}
