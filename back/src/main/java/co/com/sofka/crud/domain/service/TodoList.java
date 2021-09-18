package co.com.sofka.crud.domain.service;

import co.com.sofka.crud.domain.dto.TodoListDTO;
import co.com.sofka.crud.utils.respuesta.Respuesta;

public interface TodoList {
    Respuesta deleteById(Long id);
    TodoList getById(Long id);
    Iterable<TodoListDTO> getAllTodo();
    Respuesta save(TodoListDTO todoListDTO);
    Respuesta update(TodoListDTO todoListDTO);
}
