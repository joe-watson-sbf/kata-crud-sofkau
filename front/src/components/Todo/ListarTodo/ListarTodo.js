import React, {useState} from 'react';
import Task from './Task/Task';
import Options from './Options/Options';
import Form from '../../Form/Form';

const ListarTodo = (props) => {

    const [edit, setEdit] = useState(false);
    const [newTodo, setNewTodo] = useState();

    const handleTaskCompleted=(todo)=>{
        props.handleCompleted(+todo.target.id);
    }

    const handleRemoveTask=(event)=>{
        props.handleRemove(+event.target.id);
    }

    const handleOnSubmit = (event) => {
        event.preventDefault();
        setEdit(false);
        const data = {
            id: newTodo.id,
            tarea: event.target.task.value,
            completed: newTodo.completed
        }
        props.sendData(data);
        event.target.reset();
    }

    const handleEdit=(todo)=>{
        setEdit(true);
        setNewTodo(todo);
    }

    return (
        <ul className="list-group">
            {
                edit ? <form className="form" onSubmit={event => handleOnSubmit(event)}>
                            <input name="task" autoFocus placeholder={newTodo.tarea} required/>
                            <button type="submit">Update</button>
                        </form>
             : 
                <Form message={"Add task"} add={props.handleSave} btnText={"Add"}/>
            }
            
            {props.lista && props.lista.map((todo, index) => {
                return(
                    <div className="task"  key={index}  
                        style={todo.completed ? {backgroundColor:'#356986'} : {'textDecoration':'none'} }>
                        
                        <Task todo={todo} handleTaskCompleted={handleTaskCompleted}/>
                        <Options todo ={todo} handleEdit={handleEdit} handleRemoveTask={handleRemoveTask} />
                    </div>
                )
            })}
        </ul>
    )
}

export default ListarTodo;
