package co.com.sofkau.crud.todolist.service;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import co.com.sofkau.crud.todo.entity.Todo;
import co.com.sofkau.crud.todo.repository.TodoRepository;
import co.com.sofkau.crud.todolist.dto.TodoListDTO;
import co.com.sofkau.crud.todolist.entity.TodoList;
import co.com.sofkau.crud.todolist.repository.TodoListRepository;
import co.com.sofkau.crud.utils.Utils;
import co.com.sofkau.crud.utils.mapper.Mapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TodoListServiceServiceImp implements TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private Mapper mapper;


    @Override
    public void delete(Long id) {
        todoRepository.deleteAllByListId(id);
        todoListRepository.deleteById(id);
    }


    @Override
    public List<TodoListDTO> getAll() {
        return mapper.entityListToDTOlist(todoListRepository.findAll());
    }

    @Override
    public TodoListDTO save(TodoListDTO todoListDTO) {
        Utils.validataTodoListDTO(todoListDTO);
        TodoList todoList = mapper.dtoToEntitySave(todoListDTO);
        return mapper.entityToDTO(todoListRepository.save(todoList));
    }

    @Override
    public TodoListDTO update(TodoListDTO todoListDTO) throws NotFoundException {
        Utils.validataTodoListDTO(todoListDTO);
        TodoList todoList = todoListRepository.findById(todoListDTO.getId()).orElse(null);
        if (todoList != null) {

            TodoList todoList1 = mapper.dtoToEntityUpdate(todoListDTO);
            todoList1.setTodos(todoList.getTodos());
            todoList1 = todoListRepository.save(todoList1);

            return mapper.entityToDTO(todoList1);
        }
        throw new NotFoundException("No encontrado!");
    }

    @Override
    public TodoDTO addTodoToList(TodoDTO todoDTO, Long id) throws NotFoundException {
        Utils.validataTodoDTO(todoDTO);
        TodoList todoList = todoListRepository.findById(id).orElse(null);
        if (todoList != null) {
            Todo todo = mapper.dtoToEntitySave(todoDTO);
            todo.setListId(id);
            todo = todoRepository.save(todo);
            todoList.getTodos().add(todo);

            return mapper.entityToDTO(todo);
        }
        throw new NotFoundException("No encontrado!");
    }

    @Override
    public TodoDTO editTodoInList(TodoDTO todoDTO, Long id) throws NotFoundException {
        Utils.validataTodoDTO(todoDTO);
        TodoList todoList = this.todoListRepository.findById(id).orElse(null);
        if (todoList != null) {

            List<Todo> updateList = findAndEdit(todoList.getTodos(), todoDTO);
            todoList.setTodos(updateList);
            todoListRepository.save(todoList);
            return todoDTO;
        }
        throw new NotFoundException("No encontrado!");
    }

    @Override
    public void deleteTodoInList(Long idTodo, Long idList) throws NotFoundException {
        TodoList todoList = this.todoListRepository.findById(idList).orElse(null);
        if (todoList != null) {
            List<Todo> updateList = findAndDelete(todoList.getTodos(), idTodo);
            todoList.setTodos(updateList);
            todoListRepository.save(todoList);
        }
        if(todoList==null) throw new NotFoundException("No encontrado!");
    }

    private List<Todo> findAndEdit(List<Todo> todos, TodoDTO todoDTO){
        todos.forEach(todo -> {
            if(Objects.equals(todo.getId(), todoDTO.getId())){
                todo.setTask(todoDTO.getTarea());
                todo.setCompleted(todoDTO.isCompleted());
            }
        });
        return todos;
    }

    private List<Todo> findAndDelete(List<Todo> todos, Long idTodo){
        todos.removeIf(todo1 -> Objects.equals(todo1.getId(), idTodo));
        return todos;
    }


}
