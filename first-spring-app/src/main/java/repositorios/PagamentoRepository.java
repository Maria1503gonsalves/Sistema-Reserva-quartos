package repositorios;


import model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PagamentoRepository extends CrudRepository<Pagamento,Long> {



}
