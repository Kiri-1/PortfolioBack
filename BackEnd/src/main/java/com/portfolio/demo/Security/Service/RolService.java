
package com.portfolio.demo.Security.Service;

import com.portfolio.demo.Security.Entity.Rol;
import com.portfolio.demo.Security.Enums.RolNombre;
import com.portfolio.demo.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 */

@Service
@Transactional /* si una operacion falla hace un rolback y que no impacte en la base de datos, que siga como estaba antes */

public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    /*para guardar cambios*/
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
