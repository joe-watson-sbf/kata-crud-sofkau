package co.com.sofkau.crud.todo.repository;

import co.com.sofkau.crud.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findTodoByListIdIsNull();
    void deleteAllByListId(Long idList);
}