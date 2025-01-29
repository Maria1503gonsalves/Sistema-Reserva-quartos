package controller;

import model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PagamentoService;

import java.util.Optional;

public class PagamentoController {


    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> novoPagamento(@RequestBody Pagamento pagamento){
        Pagamento novoPagamento=pagamentoService.novoPagamento(pagamento);
        return  ResponseEntity.ok(novoPagamento);


    }

    @GetMapping
    public Optional<Pagamento> consultarPagamento(@PathVariable Long id){
        return pagamentoService.consultarPagamento(id);
    }
    @GetMapping
    public ResponseEntity<Pagamento>buscarPagamentoPeloId(@PathVariable Long id){
        Pagamento pagamento=pagamentoService.buscarPagamentoPeloId(id);
        return ResponseEntity.ok(pagamento);

    }
     @PutMapping
    public ResponseEntity<Pagamento>atualizarPagamento(@PathVariable Long id,@RequestBody Pagamento pagamentoAtualizado){
     Pagamento pagamento=pagamentoService.atualizarPagamento(id,pagamentoAtualizado);
     return ResponseEntity.ok(pagamento);
}

@DeleteMapping
    public ResponseEntity<Void>excluirPagamento(@PathVariable Long id){
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
}

}