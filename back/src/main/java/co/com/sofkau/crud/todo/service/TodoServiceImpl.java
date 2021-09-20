package co.com.sofkau.crud.todo.service;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import co.com.sofkau.crud.todo.entity.Todo;
import co.com.sofkau.crud.todo.repository.TodoRepository;
import co.com.sofkau.crud.utils.Utils;
import co.com.sofkau.crud.utils.mapper.Mapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository repository;
    @Autowired
    private Mapper mapper;


    @Override
    public List<TodoDTO> getAll() {
        return mapper.entityToDTO(repository.findTodoByListIdIsNull());
    }

    @Override
    public TodoDTO guardarTodo(TodoDTO todoDTO) {
        Utils.validataTodoDTO(todoDTO);
        Todo todo = mapper.dtoToEntitySave(todoDTO);
        return mapper.entityToDTO(repository.save(todo));
    }

    @Override
    public TodoDTO actualizarTodo(TodoDTO todoDTO) throws NotFoundException {
        Utils.validataTodoDTO(todoDTO);
        try{
            Todo todo = repository.getById(todoDTO.getId());
            todo.setTask(todoDTO.getTarea());
            todo.setCompleted(todoDTO.isCompleted());
            todo = repository. save(todo);
            return mapper.entityToDTO(todo);
        }catch (Exception ex){
            throw new NotFoundException("No encontrado!");
        }

    }

    @Override
    public void deleteTodoById(Long id) {
        Todo todo = repository.getById(id);
        if(todo.getListId()==null){
            repository.delete(todo);
        }
    }

}
