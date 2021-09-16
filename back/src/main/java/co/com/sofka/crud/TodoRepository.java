package co.com.sofka.crud;

import co.com.sofka.crud.domain.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
