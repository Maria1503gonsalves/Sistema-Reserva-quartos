package model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Entity
@Table
@Log
@Getter
@Setter

public class Quarto {
    @Id
    @GeneratedValue
    private Long idQuarto;
    private int numero;
    private String tipo;
    private Double precoDiaria;
    private String status;

    public Quarto(Long idQuarto,int numero,Double precoDiaria,String status,String tipo) {
        this.idQuarto = idQuarto;
        this.numero=numero;
        this.precoDiaria=precoDiaria;
        this.status=status;
        this.tipo=tipo;
    }
}
