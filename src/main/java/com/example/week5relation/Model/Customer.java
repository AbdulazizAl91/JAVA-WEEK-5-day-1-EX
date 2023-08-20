package com.example.week5relation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String name;
    @OneToOne(cascade = CascadeType.DETACH,mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private Details Details;
}
