import React from 'react'

const Options = ({todo, handleEdit, handleRemoveTask}) => {
    
    const editarTodo=()=>{
        handleEdit(todo);
    }


    return (
        <div className="btn-group"> 
            { !todo.completed &&
                <button 
                    id={todo.id}
                    onClick={editarTodo}
                    className="edit">
                Edit</button>
            }
            <button style={{textDecoration:'none'}}
                id={todo.id}
                onClick={handleRemoveTask}
                className="remove">
            Remove</button> 
        </div>
    )
}

export default Options
