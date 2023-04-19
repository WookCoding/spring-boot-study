package com.example.expert.inquire;

import com.example.expert.audit.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_QUESTION")
public class Question extends Period {

    @Id @GeneratedValue
    private Long id;
    @NotNull private String questionTitle;
    @NotNull private String questionContents;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.REMOVE)
    private  Answer answer;

}
