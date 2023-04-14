package com.example.basic.domain.entity;

import com.example.basic.domain.entity.type.MemberType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name="TBL_MEMBER")
public class Member {
    @Id @GeneratedValue
    private Long id;
    @NotNull // JAVA에서의 Validation(DB와 상관 없음)
    private String memberName;
    @Column(unique = true, nullable = false)// DBMS에서의 NOT NULL 제약조건 추가 (JAVA와 상관 없음)
    private String memberEmail;
    @NotNull
    private String memberPassword;
    private int memberAge;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;
}