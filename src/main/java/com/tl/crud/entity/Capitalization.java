package com.tl.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "capitalizations")
public class Capitalization extends BaseEntity {

    @Digits(integer = 9, fraction = 4)
    @Column(name = "capitalization", nullable = false)
    private BigDecimal capitalization;
}