package co.com.sofkau.crud.todolist.dto;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import lombok.Data;
import java.util.List;

@Data
public class TodoListDTO {
    private Long id;
    private String nombre;
    private List<TodoDTO> todos;
}
