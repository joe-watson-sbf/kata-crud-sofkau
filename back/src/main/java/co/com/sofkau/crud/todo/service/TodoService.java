package co.com.sofkau.crud.todo.service;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import javassist.NotFoundException;
import java.util.List;

public interface TodoService {
    List<TodoDTO> getAll();
    TodoDTO guardarTodo(TodoDTO todoDTO);
    TodoDTO actualizarTodo(TodoDTO todoDTO) throws NotFoundException;
    void deleteTodoById(Long id);
}
