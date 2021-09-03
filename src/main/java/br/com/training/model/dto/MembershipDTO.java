package br.com.training.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MembershipDTO {

    private Long id;

    @NotNull
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate bithDate;

    @Digits(integer = 3, fraction = 2)
    private Double weight;

    private String level;

    private String goal;
    
    private String description;

}
