package co.com.sofkau.crud.todo.entity;

import co.com.sofkau.crud.todolist.entity.TodoList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long listId;
    private String task;
    private boolean completed;

}
