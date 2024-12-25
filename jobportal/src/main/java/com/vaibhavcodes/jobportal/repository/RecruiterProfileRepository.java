package com.vaibhavcodes.jobportal.repository;

import com.vaibhavcodes.jobportal.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterProfileRepository  extends JpaRepository<RecruiterProfile,Integer> {
}
