package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "employies")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date birthdate;
    @Column
    private String educationLevel;
    @Column
    private String firstName;
    @Column
    private String jobTitle;
    @Column
    private String lastName;
    @Column(precision = 19,scale = 2)
    private BigDecimal salary;
    @OneToOne
    private Company company;

}
