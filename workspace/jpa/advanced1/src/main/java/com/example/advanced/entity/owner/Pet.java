package com.example.advanced.entity.owner;

import com.example.advanced.audit.Period;
import com.example.advanced.type.PetDiseaseType;
import com.example.advanced.type.PetGenderType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_PET")
public class Pet extends Period {
    @Id @GeneratedValue
    private Long Id;
    @NotNull private String petName;
    @Enumerated(EnumType.STRING)
    @NotNull private PetGenderType petGenderType;
    @Enumerated(EnumType.STRING)
    @NotNull private PetDiseaseType petDiseaseType;
}
