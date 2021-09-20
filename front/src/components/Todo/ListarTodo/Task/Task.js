import React from 'react';

const CheckBox = ({todo, handleTaskCompleted}) => {

    const copyTodo = todo;
    const handleTypeInput=()=>{
        console.log('Completed : ', copyTodo.completed);
    }

    return (
        <label  style={
                todo.completed ?
                {textDecoration:"line-through"} : {'textDecoration':'none'} } >

            <input type="checkbox" id={todo.id} checked={todo.completed}  
                onChange={handleTaskCompleted}
                onClick = {handleTypeInput}
            /> 
            {todo.tarea}
        </label>
        
    )
}

export default CheckBox
