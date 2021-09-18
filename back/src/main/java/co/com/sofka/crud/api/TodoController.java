package co.com.sofka.crud.api;

import co.com.sofka.crud.domain.dto.TodoDTO;
import co.com.sofka.crud.domain.dto.TodoListDTO;
import co.com.sofka.crud.domain.model.TodoList;
import co.com.sofka.crud.service.TodoListService;
import co.com.sofka.crud.utils.respuesta.Respuesta;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {

    @Autowired
    private TodoListService service;

    @GetMapping("/todolist")
    public List<TodoListDTO> getAllTodo() {
        return service.getAllTodo();
    }

    @DeleteMapping("/todolist/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/todolist/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new Respuesta(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todolist")
    public TodoList save(@RequestBody TodoListDTO todoListDTO) {
        return service.save(todoListDTO);
    }

    @PutMapping("/todolist")
    public ResponseEntity<Object> update(@RequestBody TodoListDTO todoListDTO){
        try{
            return new ResponseEntity<>(service.update(todoListDTO), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new Respuesta(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todo/{id}")
    public ResponseEntity<Object> saveTodo(@RequestBody TodoDTO todoDTO, @PathVariable Long id)  {
        try{
            return new ResponseEntity<>(service.addTodo(todoDTO, id), HttpStatus.OK);
        }catch (NotFoundException exception){
            return new ResponseEntity<>(new Respuesta(exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/todo")
    public ResponseEntity<Object> updateTodo(@RequestBody TodoDTO todoDTO){
        try{
            return new ResponseEntity<>(service.editTodo(todoDTO), HttpStatus.OK);
        }catch (NotFoundException exception){
            return new ResponseEntity<>(new Respuesta(exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
    }

}
