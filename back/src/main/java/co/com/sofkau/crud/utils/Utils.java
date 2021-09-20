package co.com.sofkau.crud.utils;

import co.com.sofkau.crud.todo.dto.TodoDTO;
import co.com.sofkau.crud.todolist.dto.TodoListDTO;
import co.com.sofkau.crud.todolist.entity.TodoList;
import co.com.sofkau.crud.utils.exception.BusinessException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utils {



    public static void validataTodoListDTO(TodoListDTO todoListDTO){
        if(todoListDTO.getNombre().isBlank()){
            throw new BusinessException("El nombre de la lista no debe ser vacio!!!");
        }
        removeSpace(todoListDTO);
    }

    public static void validataTodoDTO(TodoDTO todoDTO){
        if(todoDTO.getTarea().isBlank()){
            throw new BusinessException("La tarea no debe ser vacia!!!");
        }
        removeSpace(todoDTO);
    }

    private static void removeSpace(TodoDTO todoDTO){
        String str = todoDTO.getTarea();
        todoDTO.setTarea(quitarEspacios(str));
    }

    private static void removeSpace(TodoListDTO todoListDTO){
        String str = todoListDTO.getNombre();
        todoListDTO.setNombre(quitarEspacios(str));
    }

    private static String quitarEspacios(String cadena) {
        String regex = "\\s+";
        Pattern patron = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher validador = patron.matcher(cadena);
        return validador.replaceAll(" ").trim();
    }

}
