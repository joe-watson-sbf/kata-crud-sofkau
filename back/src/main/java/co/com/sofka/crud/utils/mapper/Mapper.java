package co.com.sofka.crud.utils.factory;

import co.com.sofka.crud.domain.dto.TodoDTO;
import co.com.sofka.crud.domain.dto.TodoListDTO;
import co.com.sofka.crud.domain.model.Todo;
import co.com.sofka.crud.domain.model.TodoList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class Factory {

    /**
     * Convertir un DTO TodoList a una entidad TodoList para GUARDAR
     * En este metodo, el ID no IMPORTA
     * */

    public TodoList dtoToEntitySave(TodoListDTO dto){
        TodoList todoList = new TodoList();
        todoList.setName(dto.getNombre());

        return todoList;
    }

    /**
     * Convertir un DTO TodoList a una entidad TodoList para ACTUALIZAR
     * En este metodo, el ID IMPORTA
     * */
    public TodoList dtoToEntityUpdate(TodoListDTO dto){
        TodoList todoList = new TodoList();

        todoList.setId(dto.getId());
        todoList.setName(dto.getNombre());

        return todoList;
    }

    /**
     * Convertir una entidad TodoList a un DTO TodoList
     * para responder a las peticiones
     * */
    public TodoListDTO entityToDTO(TodoList todoList){
        TodoListDTO todoListDTO = new TodoListDTO();

        todoListDTO.setNombre(todoList.getName());
        todoListDTO.setId(todoList.getId());
        todoListDTO.setTodos(entityToDTO(todoList.getTodos()));

        return todoListDTO;
    }

    public List<TodoListDTO> entityListToDTOlist(Iterable<TodoList> todoListAll){
        List<TodoListDTO> todoListDTOS = new ArrayList<>();

        todoListAll.forEach(todoList -> todoListDTOS.add(entityToDTO(todoList)));

        return todoListDTOS;
    }


    /**
     * Metodo que nos ayuda a a hacer facilmente las
     * conversiones de una lista todoEntity a todoDTO
     * */
    public Collection<TodoDTO> entityToDTO(Collection<Todo> list){
        Collection<TodoDTO> lista = new ArrayList<>();

        list.forEach(todo -> {
            TodoDTO todoDTO = entityToDTO(todo);
            lista.add(todoDTO);
        });

        return lista;
    }

    /**
     * Metodo que nos ayuda a a hacer facilmente las
     * conversiones de una lista todoDTO a todoEntity
     * */
    public Collection<Todo> dtoToEntity(Collection<TodoDTO> list){
        Collection<Todo> lista = new ArrayList<>();

        list.forEach(todoDTO -> {
            Todo todo = dtoToEntitySave(todoDTO);
            lista.add(todo);
        });

        return lista;
    }

    /**
     * Unos metodos helper para las conversiones de las colecciones
     * Pasa un DTO a una Entidad
     * */
    public Todo dtoToEntitySave(TodoDTO todoDTO){
        Todo todo = new Todo();

        todo.setTask(todoDTO.getTarea());
        todo.setCompleted(todoDTO.isCompleted());

        return todo;
    }

    public Todo dtoToEntityUpdate(TodoDTO todoDTO){
        Todo todo = new Todo();

        todo.setId(todo.getId());
        todo.setTask(todoDTO.getTarea());
        todo.setCompleted(todoDTO.isCompleted());

        return todo;
    }

    /**
     * Unos metodos helper para las conversiones de las colecciones
     * Pasa una Entidad a un DTO
     * */
    public TodoDTO entityToDTO(Todo todo){
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setId(todo.getId());
        todoDTO.setTarea(todo.getTask());
        todoDTO.setCompleted(todo.isCompleted());

        return todoDTO;
    }

}
