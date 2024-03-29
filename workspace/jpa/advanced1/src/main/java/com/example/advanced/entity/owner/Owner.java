package com.example.advanced.entity.owner;

import com.example.advanced.audit.Period;
import com.example.advanced.entity.board.Reply;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_OWNER")
public class Owner extends Period {

    @Id @GeneratedValue
    private Long id;
    @NotNull private String ownerName;
    @NotNull private String ownerPhoneNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "OWNER_ID")
    List<Pet> pets = new ArrayList<>();
}
