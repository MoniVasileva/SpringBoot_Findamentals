package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 15,scale = 2)
    private BigDecimal budget;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private String name;
    @Column
    private String town;

}
