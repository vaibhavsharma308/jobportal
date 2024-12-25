package com.vaibhavcodes.jobportal.entity;


import jakarta.persistence.*;

@Entity
@Table(name="skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String experienceLevel;
    private String name;
    private String yearsOfExperience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_seeker_profile")
    private JobSeekerProfile jobSeekerProfile;
}
