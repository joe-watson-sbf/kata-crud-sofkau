package co.com.sofkau.crud.todolist.service;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import co.com.sofkau.crud.todolist.dto.TodoListDTO;
import javassist.NotFoundException;

import java.util.List;

public interface TodoListService {

    List<TodoListDTO> getAll();
    TodoListDTO save(TodoListDTO todoListDTO);
    TodoListDTO update(TodoListDTO todoListDTO) throws NotFoundException;
    TodoDTO addTodoToList(TodoDTO todoDTO, Long id) throws NotFoundException;
    TodoDTO editTodoInList(TodoDTO todoDTO, Long id) throws NotFoundException;
    void deleteTodoInList(Long idTodo, Long idList) throws NotFoundException;
    void delete(Long id);
}
