package co.com.sofka.crud.domain.dto;

import co.com.sofka.crud.domain.model.Todo;
import lombok.Data;
import java.util.List;

@Data
public class TodoListDTO {
    private Long id;
    private String nombre;
    private List<Todo> todos;
}
