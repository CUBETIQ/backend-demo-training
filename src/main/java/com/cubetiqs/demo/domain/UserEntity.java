package com.cubetiqs.demo.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity<Long> {
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 100)
    private String password;
}
