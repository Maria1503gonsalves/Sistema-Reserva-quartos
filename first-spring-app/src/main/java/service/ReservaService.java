package service;

import model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.ClienteRepository;
import repositorios.ReservaRepository;

import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva novaReserva(Reserva reserva) {
        return reservaRepository.save(reserva);

    }

    public Optional<Reserva> consultarReserva(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva atualizarReserva(Long id, Reserva reservaAtualizada) {
        Reserva reserva = buscarReservapeloNome(id);
        reserva.setIdReserva(reservaAtualizada.getIdReserva());
        reserva.setClientes(reservaAtualizada.getClientes());
        reserva.setPagamentos(reservaAtualizada.getPagamentos());
        reserva.setDataChekin(reservaAtualizada.getDataChekin());
        reserva.setQuartos(reservaAtualizada.getQuartos());
        reserva.setDataCheckout(reservaAtualizada.getDataCheckout());


        return reserva;
    }

public Reserva buscarReservapeloNome(Long id){
        return reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
    }

public void excluirReserva(Long id){
        reservaRepository.deleteById(id);

}


}
