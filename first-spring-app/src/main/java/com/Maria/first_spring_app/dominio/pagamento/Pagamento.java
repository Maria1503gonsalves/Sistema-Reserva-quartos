package com.Maria.first_spring_app.dominio.pagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Pagamento {
    @Id
    @GeneratedValue
    private UUID Idpagamento;
    private double valor;
    private Date dataPagamento;
    private Double status;

}
