package com.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @SequenceGenerator(name="user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Integer userId;
    @NotNull(message = "user firstName Should not be null")
    private String firstName;
    @NotNull(message = "user lastName Should not be null")
    private String lastName;
    private String dob;
    @NotNull(message = "user email Should not be null")
    private String email;
    @NotNull(message = "user password Should not be null")
    private String password;
    private String phoneNumber;

}
