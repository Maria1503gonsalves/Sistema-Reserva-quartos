package controller;

import model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repositorios.PagamentoRepository;
import service.PagamentoService;

@RestController


public class PagamentoController {

 @Autowired
 private PagamentoService pagamentoService;

@PostMapping
 public ResponseEntity<Pagamento>novoPagamento(@RequestBody Pagamento pagamento){
    Pagamento novoPagamento=pagamentoService.novoPagamento(pagamento);
   return  ResponseEntity.ok(novoPagamento);


}

}
