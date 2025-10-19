package dbt.sandbox.service;

import dbt.sandbox.model.Role;
import dbt.sandbox.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getRoleList() {
        return (List<Role>) roleRepository.findAll();
    }

    public Role getRole(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

}
