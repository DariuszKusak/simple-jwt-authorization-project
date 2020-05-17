package com.kusak.dariusz.simplejwtauthorizationproject.repository;

import com.kusak.dariusz.simplejwtauthorizationproject.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
