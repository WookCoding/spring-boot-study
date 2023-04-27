package com.example.test.entity.member;

import com.example.test.audit.Period;
import com.example.test.type.ChallengeStatusType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_CHALLENGE")
public class Challenge extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String challengeTitle;
    @NotNull private String challengeContent;
    @Enumerated(EnumType.STRING)
    private ChallengeStatusType challengeStatus;
}
