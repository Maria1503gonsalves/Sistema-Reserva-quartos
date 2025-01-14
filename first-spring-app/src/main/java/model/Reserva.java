package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Entity
@Table
@Log
@Getter
@Setter

public class Reserva {
    @Id
    @GeneratedValue
  private Long idReserva;
  private Data dataCheckout;
  private Data dataChekin;

    public Reserva(Long idReserva,Data dataCheckout,Data dataChekin) {
        this.idReserva = idReserva;
        this.dataCheckout=dataCheckout;
        this.dataChekin=dataChekin;
    }

@ManyToMany
    @JoinColumn(name = "cliente_id")
private Cliente clientes;

    @ManyToMany
    @JoinColumn(name = "quarto_id")
    private Quarto quartos;

    @OneToMany
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamentos;

}
