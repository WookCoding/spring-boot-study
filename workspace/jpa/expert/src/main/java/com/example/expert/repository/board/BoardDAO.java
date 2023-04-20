package com.example.expert.repository.board;

import com.example.expert.board.Board;
import com.example.expert.board.Like;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BoardDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public Board save(Board board){
        entityManager.persist(board);
        return board;
    }

//    조회
    public Optional<Board> findById(Long id) {
//        String query = "select b from Board b join fetch b.likes where b.id = :id";

//        return Optional.ofNullable(entityManager.createQuery(query, Board.class).setParameter("id", id).getSingleResult());

        return Optional.ofNullable(entityManager.find(Board.class, id));
    }

//    전체 조회
    public List<Board> findAll() {
        String query = "select b from Board b join fetch b.likes";
        return entityManager.createQuery(query, Board.class).getResultList();
        // board 갯수 만큼 select가 돌아야하는데 board안에 리스트 만큼 더 돔
    }

//    board 삭제
    public void delete(Board board) {
        entityManager.remove(board);
    }

//    like 삭제
    public void delete(Like like) {
        entityManager.remove(like);
    }
}
