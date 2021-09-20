package co.com.sofkau.crud.utils.mapper;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import co.com.sofkau.crud.todo.entity.Todo;
import co.com.sofkau.crud.todolist.dto.TodoListDTO;
import co.com.sofkau.crud.todolist.entity.TodoList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public TodoList dtoToEntitySave(TodoListDTO dto) {
        TodoList todoList = new TodoList();
        todoList.setName(dto.getNombre());
        todoList.setTodos(new ArrayList<>());
        return todoList;
    }

    public TodoList dtoToEntityUpdate(TodoListDTO dto) {
        TodoList todoList = new TodoList();

        todoList.setId(dto.getId());
        todoList.setName(dto.getNombre());
        todoList.setTodos(new ArrayList<>());

        return todoList;
    }

    public TodoListDTO entityToDTO(TodoList todoList) {
        TodoListDTO todoListDTO = new TodoListDTO();

        todoListDTO.setNombre(todoList.getName());
        todoListDTO.setId(todoList.getId());
        todoListDTO.setTodos(entityToDTO(todoList.getTodos()));

        return todoListDTO;
    }

    public List<TodoListDTO> entityListToDTOlist(List<TodoList> todoListAll) {
        List<TodoListDTO> todoListDTOS = new ArrayList();
        todoListAll.forEach((todoList) -> {
            TodoListDTO dto = new TodoListDTO();
            dto.setTodos(entityToDTO(todoList.getTodos()));
            dto.setId(todoList.getId());
            dto.setNombre(todoList.getName());

            todoListDTOS.add(dto);
        });
        return todoListDTOS;
    }

    public List<TodoDTO> entityToDTO(List<Todo> list) {
        List<TodoDTO> lista = new ArrayList();
        list.forEach((todo) -> {
            TodoDTO todoDTO = this.entityToDTO(todo);
            lista.add(todoDTO);
        });
        return lista;
    }

    public List<Todo> dtoToEntity(List<TodoDTO> list) {
        List<Todo> lista = new ArrayList();
        list.forEach((todoDTO) -> {
            Todo todo = this.dtoToEntitySave(todoDTO);
            lista.add(todo);
        });
        return lista;
    }

    public Todo dtoToEntitySave(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setTask(todoDTO.getTarea());
        todo.setCompleted(todoDTO.isCompleted());
        return todo;
    }

    public Todo dtoToEntityUpdate(TodoDTO todoDTO) {
        Todo todo = new Todo();

        todo.setId(todo.getId());
        todo.setTask(todoDTO.getTarea());
        todo.setCompleted(todoDTO.isCompleted());

        return todo;
    }

    public TodoDTO entityToDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setId(todo.getId());
        todoDTO.setTarea(todo.getTask());
        todoDTO.setCompleted(todo.isCompleted());

        return todoDTO;
    }


}
