package service;

import model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import repositorios.PagamentoRepository;

import java.util.Optional;

@Service
public class PagamentoService {


    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento novoPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Optional<Pagamento> consultarPagamento(Long id) {
        return pagamentoRepository.findById(id);
    }

    public Pagamento buscarPagamentoPeloId(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }


    public Pagamento atualizarPagamento(Long id ,Pagamento pagamentoAtualizado){
        Pagamento pagamento=buscarPagamentoPeloId(id);
        pagamento.setValor(pagamentoAtualizado.getValor());
        pagamento.setDataPagamento(pagamentoAtualizado.getDataPagamento());
        pagamento.setIdpagamento(pagamentoAtualizado.getIdpagamento());

        return pagamentoRepository.save(pagamento);
    }

    public void excluirPagamento(Long id){
        pagamentoRepository.deleteById(id);

    }
}