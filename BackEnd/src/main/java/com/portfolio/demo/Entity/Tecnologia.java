package com.portfolio.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Tecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreT;
    private String descripcionT;
    private int porcentajeT;

    public Tecnologia() {
    }

    public Tecnologia(String nombreT, String descripcionT, int porcentajeT) {

        this.nombreT = nombreT;
        this.descripcionT = descripcionT;
        this.porcentajeT = porcentajeT;
    }
    

}
