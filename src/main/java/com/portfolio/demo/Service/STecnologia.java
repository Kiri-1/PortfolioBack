package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Tecnologia;
import com.portfolio.demo.Repository.RTecnologia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class STecnologia {
    @Autowired
    RTecnologia rTecnologia;

    public List<Tecnologia> list() {
        return rTecnologia.findAll();
        /*arma una lista con todas las experiencias que encuentre*/
    }

    public Optional<Tecnologia> getOne(int id) {
        return rTecnologia.findById(id);
    }

    public Optional<Tecnologia> getByNombreT(String nombreT) {
        return rTecnologia.findByNombreT(nombreT);
    }

    public void save(Tecnologia tec) {
        rTecnologia.save(tec);
    }

    public void delete(int id) {
        rTecnologia.deleteById(id);
    }

    public boolean existsById(int id) {
        return rTecnologia.existsById(id);
    }

    public boolean existsByNombreT(String nombreT) {
        return rTecnologia.existsByNombreT(nombreT);
    }
}