package com.Maria.first_spring_app.dominio.reserva;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.util.Date;
import java.util.UUID;


@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Reserva {
    @Id
    @GeneratedValue
    private UUID idreserva;
    private Date dataCheckout;
    private Date dataCheckin;




}
