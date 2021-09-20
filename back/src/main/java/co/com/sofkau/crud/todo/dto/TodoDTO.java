package co.com.sofkau.crud.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long id;
    private String tarea;
    private boolean isCompleted;
}
