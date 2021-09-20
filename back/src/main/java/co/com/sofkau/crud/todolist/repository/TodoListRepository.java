package co.com.sofkau.crud.todolist.repository;
import co.com.sofkau.crud.todolist.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
