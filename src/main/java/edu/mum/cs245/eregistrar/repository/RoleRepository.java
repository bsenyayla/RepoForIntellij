package edu.mum.cs245.eregistrar.repository;

import edu.mum.cs245.eregistrar.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
