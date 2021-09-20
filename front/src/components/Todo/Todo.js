import React, {useState, useEffect} from 'react';
import axios from 'axios';
import ListarTodo from './ListarTodo/ListarTodo';

const Todo = () => {

    const [todos, setTodos] = useState([]);

    const fetchAllTodo = async ()=>{
        const response = await axios.get("http://localhost:8080/api/todo");
        if(response.status===200){
            setTodos(response.data);
        }
    }

    const handleSave = (name)=>{
        const data = {"tarea": name, "completed": false};
        axios.post("http://localhost:8080/api/todo", data)
        .then(response=>{
            console.log("TODO SAVED! ::: ", response.status);
            fetchAllTodo();
        })
        .catch(error=>{
            console.log("ERROR SAVING: ---> ", error);
        })
    }

    const handleUpdateCompleted = (id)=>{
        const data = findTodoById(id);
        data.completed = !data.completed;
        axios.put("http://localhost:8080/api/todo", data)
        .then(response=>{
            console.log("COMPLETE UPDATE! ::: ", response.status)
            fetchAllTodo();
        })
        .catch(error=>{
            console.log("ERROR UPDATING: ---> ", error);
        })
    }

    const handleDelete = (id)=>{
        axios.delete(`http://localhost:8080/api/todo/${id}`)
        .then(response=>{
            console.log("TODO DELETED! ::: ", response.status)
            fetchAllTodo();
        })
        .catch(error=>{
            console.log("ERROR DELETING : ", error);
        })
    }

    
    const handleUpdate = (data)=>{
        axios.put("http://localhost:8080/api/todo", data)
        .then(response=>{
            console.log("COMPLETE UPDATE! ::: ", response.status)
            fetchAllTodo();
        })
        .catch(error=>{
            console.log("ERROR UPDATING: ---> ", error);
        })
    }
    

    const findTodoById=(id)=>{
        let todoFound = todos.filter(todo => todo.id === id);
        return todoFound[0];
    }


    useEffect(()=>{
       fetchAllTodo();
    }, []);


    return (
        <div>

           {todos &&
                <div className="main">
                    <div className="header">
                        <h1>Tareas</h1>
                    </div>
                    <div className="main-content">
                            
                            <ListarTodo 
                                lista={todos} 
                                handleCompleted={handleUpdateCompleted}
                                handleRemove={handleDelete}
                                handleSave={handleSave}
                                sendData = {handleUpdate}
                            />
                            
                    </div>
                </div>
            }

        </div>
    )
}

export default Todo;
