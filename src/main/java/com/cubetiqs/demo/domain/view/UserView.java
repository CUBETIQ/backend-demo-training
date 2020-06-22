package com.cubetiqs.demo.domain.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {
        "email",
        "id"
})
public class UserView implements Serializable {
    private Long id;
    private String email;
}
