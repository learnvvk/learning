package com.vvk.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity(name="user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {

    @Id
    @Column(name="user_id")
    private Integer userId;

    @NotEmpty
    @Column(name="user_name", length = 100)
    private String userName;

    @NotEmpty
    private String email;

    @NotEmpty(message = "About must not be empty")
    private String userAbout;
}
