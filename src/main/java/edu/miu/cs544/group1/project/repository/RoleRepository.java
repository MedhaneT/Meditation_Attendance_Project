package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.Role;
import edu.miu.cs544.group1.project.domain.enumerated.RoleCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByCode(RoleCode code);
}
