package com.vaibhavcodes.jobportal.repository;


import com.vaibhavcodes.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

}
