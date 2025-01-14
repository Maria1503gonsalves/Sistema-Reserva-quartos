package repositorios;


import model.SistemaSeguranca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaSegurancaRepository extends CrudRepository<SistemaSeguranca,Long> {
}
