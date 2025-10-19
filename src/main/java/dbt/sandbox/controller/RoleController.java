package dbt.sandbox.controller;

import dbt.sandbox.model.Role;
import dbt.sandbox.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping()
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        try {
            Role created = roleService.createRole(role);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Role>> getRoleList() {
        try {
            List<Role> roleList = roleService.getRoleList();
            return new ResponseEntity<>(roleList, HttpStatus.CREATED);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") Long id) {
        try {
            Role role = roleService.getRole(id);
            return new ResponseEntity<>(role, HttpStatus.CREATED);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
