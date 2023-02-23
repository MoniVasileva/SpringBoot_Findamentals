package org.example.domain.models;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.domain.entities.Company;

import java.math.BigDecimal;


@Data
public class CompanyAddModel {
    @Positive
    private BigDecimal budget;
    @Size(min = 10)
    private String description;
    @Size(min = 2, max = 10)
    private String name;
    @Size(min = 2, max = 10)
    private String town;

    public Company toCompany(){
      return   Company.builder()
              .budget(budget)
              .description(description)
              .name(name)
              .town(town)
              .build();
    }
}
