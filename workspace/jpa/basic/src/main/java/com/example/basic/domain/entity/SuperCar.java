package com.example.basic.domain.entity;

import com.example.basic.domain.entity.type.SuperCarType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TBL_SUPER_CAR")
public class SuperCar {
    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @NotNull private SuperCarType type;
    @NotNull private String name;
    @NotNull private String color;
    private Integer price;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime releaseDate;
}
