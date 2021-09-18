package co.com.sofka.crud.domain.service;

import co.com.sofka.crud.domain.repository.TodoRepository;
import co.com.sofka.crud.domain.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> getAll(){
        return repository.findAll();
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void deleteById(Long id){
        repository.delete(getById(id));
    }

    public Todo getById(Long id){
         return repository.findById(id).orElseThrow();
    }

}
