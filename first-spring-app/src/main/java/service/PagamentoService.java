package service;

import model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import repositorios.PagamentoRepository;

public class PagamentoService {


  @Autowired
  private PagamentoRepository pagamentoRepository;

  public Pagamento novoPagamento (Pagamento pagamento ){

     return  pagamentoRepository.save(pagamento);
  }





}
