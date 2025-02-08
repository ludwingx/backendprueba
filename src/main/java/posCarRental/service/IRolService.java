package posCarRental.service;

import posCarRental.entity.Rol;

import java.util.List;

public interface IRolService {

    Rol saveRol(Rol rol);

    Rol getByRoleId(Long id);

    List<Rol> findAllRoles();

    Rol updateRole(Long id, Rol rol);

    void deleteByRolId(Long id);
}
