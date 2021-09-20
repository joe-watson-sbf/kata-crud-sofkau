package co.com.sofkau.crud.api;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import co.com.sofkau.crud.todo.service.TodoService;
import co.com.sofkau.crud.todolist.dto.TodoListDTO;
import co.com.sofkau.crud.todolist.service.TodoListService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;
    @Autowired
    private TodoService todoService;

    @GetMapping("api/todolist")
    public List<TodoListDTO> getAllTodoList() {
        return todoListService.getAll();
    }

    @DeleteMapping("api/todolist/{id}")
    public void delete(@PathVariable Long id) {
        todoListService.delete(id);
    }


    @PostMapping("api/todolist")
    public TodoListDTO saveTodoList(@RequestBody TodoListDTO todoListDTO) {
        return todoListService.save(todoListDTO);
    }

    @PutMapping("api/todolist")
    public TodoListDTO updateTodoList(@RequestBody TodoListDTO todoListDTO) throws NotFoundException {
        return todoListService.update(todoListDTO);
    }

    @PostMapping("api/todolist/{idList}")
    public TodoDTO addTodoToList(@RequestBody TodoDTO todoDTO, @PathVariable Long id) throws NotFoundException {
        return todoListService.addTodoToList(todoDTO, id);
    }

    @PutMapping("api/todolist/{id}")
    public TodoDTO updateTodoList(@RequestBody TodoDTO todoDTO, @PathVariable Long id) throws NotFoundException {
        return todoListService.editTodoInList(todoDTO, id);
    }

    @DeleteMapping("api/todolist/{idTodo}/{idList}")
    public void deleteTodoInList(@PathVariable Long idTodo, @PathVariable Long idList) throws NotFoundException {
        todoListService.deleteTodoInList(idTodo, idList);
    }





    /**
     * API TODO_
     * */

    @GetMapping("api/todo")
    public List<TodoDTO> getAllTodo() {
        return todoService.getAll();
    }

    @PostMapping("api/todo")
    public TodoDTO saveTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.guardarTodo(todoDTO);
    }

    @PutMapping("api/todo")
    public TodoDTO updateTodo(@RequestBody TodoDTO todoDTO) throws NotFoundException {
        return todoService.actualizarTodo(todoDTO);
    }

    @DeleteMapping("api/todo/{id}")
    public void deleteById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }
}




