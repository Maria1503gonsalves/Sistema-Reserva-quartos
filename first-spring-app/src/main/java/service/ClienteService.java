package service;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import repositorios.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> consultarCliente (Long id){
        return clienteRepository.findById(id);
    }


public List<Cliente> obterTodosClientes(){
        List<Cliente> clientes= new ArrayList<>();
         clienteRepository.findAll().forEach(clientes::add);
         return clientes;

}

public Cliente buscarClientePeloId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

}


    public void excluirCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente>buscarClientePeloNome(String nome){
        return clienteRepository.findByNome(nome);
    }

    }




