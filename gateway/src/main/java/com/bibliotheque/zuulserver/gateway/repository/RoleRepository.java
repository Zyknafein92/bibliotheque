package com.bibliotheque.zuulserver.gateway.repository;

import com.bibliotheque.zuulserver.gateway.model.Role;
import com.bibliotheque.zuulserver.gateway.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleName roleName);

}
