
package com.pasteleria.Milsabores.Repository;


import com.pasteleria.Milsabores.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Duoc
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Usuario findByName(String name);
    Usuario findByCorreo(String correo);
}
