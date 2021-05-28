package com.example.demo;

import lombok.*;

import javax.persistence.*;
import java.time.Year;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mieszkania")
@ToString
@EqualsAndHashCode(of = "id")
public class Mieszkanie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Miasto;
    private String Kraj;
    private Double Cena;
    private String Stan;
    private Double Metraz;
    private Integer Pokoje;
    private String rodzaj;
    private Integer Rok;
    private String ogrzewanie;
    private Boolean klimatyzacja;
    private Boolean Balkon;
   @Transient
    private Double Od;
    @Transient
    private Double Do;
@Transient
    private Float MetrazOd;
@Transient
    private Float MetrazDo;


}

