package com.portfolio.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter

public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String descripcionEd;

    public Educacion() {
 
    }

    public Educacion(String nombreEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
    }
}
