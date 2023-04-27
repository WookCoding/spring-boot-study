package com.example.test.entity.member;

import com.example.test.audit.Period;
import com.example.test.type.MemberStatusType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name="TBL_MEMBER")
public class Member extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String password;
    @Column(unique = true)
    @NotNull private String phoneNumber;
    @NotNull private String name;

    @Enumerated(EnumType.STRING)
    private MemberStatusType MemberStatus;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "MEMBER_ID")
    private List<Challenge> challenges = new ArrayList<>();

}
