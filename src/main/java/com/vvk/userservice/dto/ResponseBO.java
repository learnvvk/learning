package com.vvk.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBO<T> {

    @JsonProperty("data")
    T data;

    @JsonProperty("errors")
    List<ErrorBO> errors;

    @JsonProperty("status")
    String status;


}
