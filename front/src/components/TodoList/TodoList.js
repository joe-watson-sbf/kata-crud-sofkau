import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Form from '../Form/Form';
import List from './List/List';

const TodoList = () => {

    const [todoList, setTodoList] = useState([]);

    const fetchAllTodoList = async ()=>{
        const response = await axios.get("http://localhost:8080/api/todolist");
        if(response.status===200 && response.data){ 
            setTodoList(response.data);
        }
    }

    const handleSave = (name)=>{
        const data = {"nombre" : name};
        axios.post("http://localhost:8080/api/todolist", data)
        .then(response=>{
            console.log("TODO SAVED! ::: ", response.status);
            fetchAllTodoList();
        })
        .catch(error=>{
            console.log("ERROR: ---> ", error);
        })
    }

/*
    const handleAddTaskToList = (idList, data)=>{

        axios.post(`http://localhost:8080/api/todolist/${idList}`, data)
        .then(response=>{
            console.log("TODO SAVED! ::: ", response.status);
            fetchAllTodoList();
        })
        .catch(error=>{
            console.log("ERROR: ---> ", error);
        })
    }
    */

    const handleDelete=(id)=>{
        axios.delete(`http://localhost:8080/api/todolist/${id}`)
        .then(response=>{
            console.log("TODO DELETED! ::: ", response.status)
            fetchAllTodoList();
        })
        .catch(error=>{
            console.log("ERROR DELETING : ", error);
        })
    }

    /*

    const handleUpdateCompleted = (id)=>{
        const data = findTodoById(id);
        data.completed = !data.completed;
        axios.put("http://localhost:8080/api/todo", data)
        .then(response=>{
            console.log("COMPLETE UPDATE! ::: ", response.status)
            fetchAllTodoList();
        })
        .catch(error=>{
            console.log("ERROR UPDATING: ---> ", error);
        })
    }
    

    const findTodoById=(id)=>{
        let todoFound = todoList.todos.filter(todo => todo.id === id);
        return todoFound[0];
    }
    */



    useEffect(()=>{
        fetchAllTodoList();
    }, []);



    return (
        <div>
            {todoList &&
                    <div className="bord-r"> 
                        <h1>Todo List</h1>
                        <Form message="Add todo list" btnText="Add" add={handleSave}/>
                        <List listaTodo={todoList} handleDelete={handleDelete}/>
                    </div>
                } 
        </div>
    )
}

export default TodoList
