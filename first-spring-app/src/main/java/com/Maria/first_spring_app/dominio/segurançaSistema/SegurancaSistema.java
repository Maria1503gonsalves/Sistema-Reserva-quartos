package com.Maria.first_spring_app.dominio.segurançaSistema;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SegurancaSistema {
    private Double frequencia;
    private Date ultimoBackup;
    private String usuario;
    private String senha;
    private String token;

}
