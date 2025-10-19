package dbt.sandbox.v2.repository;

import dbt.sandbox.v2.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepositoryV2")
public interface RoleRepository extends CrudRepository<Role, Long> {
}

