package com.example.advanced.entity.hospital;

import com.example.advanced.audit.Period;
import com.example.advanced.type.PetGenderType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_PETS")
public class Pets extends Period {
    @Id @GeneratedValue
    private Long id;
    private String petName;
    @Enumerated(value = EnumType.STRING)
    @NotNull private PetGenderType petGenderType;
    private String petDisease;
}
