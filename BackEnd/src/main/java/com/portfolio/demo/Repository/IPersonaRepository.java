package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}
