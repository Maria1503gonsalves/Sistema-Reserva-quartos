package model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log
@Table
@Entity


public class Pagamento {
    @Id
    @GeneratedValue

  private Long idpagamento;
    private Data dataPagamento;
    private String status;

    public Pagamento(Long idpagamento,Data dataPagamento,String status) {
        this.idpagamento = idpagamento;
        this.dataPagamento=dataPagamento;
        this.status=status;
    }
}
