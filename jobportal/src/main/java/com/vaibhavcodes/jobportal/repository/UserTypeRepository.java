package com.vaibhavcodes.jobportal.repository;

import com.vaibhavcodes.jobportal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UsersType,Integer> {
}
