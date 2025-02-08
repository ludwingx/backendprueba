package posCarRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posCarRental.entity.Rol;
import posCarRental.repository.IRolRepository;
import posCarRental.service.IRolService;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol getByRoleId(Long id) {
        return rolRepository.findById(id).get();
    }

    @Override
    public List<Rol> findAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol updateRole(Long id, Rol rol) {
        Rol updateId = rolRepository.findById(id).get();
        updateId.setName(rol.getName());
        return rolRepository.save(updateId);
    }

    @Override
    public void deleteByRolId(Long id) {
        rolRepository.deleteById(id);
    }
}
