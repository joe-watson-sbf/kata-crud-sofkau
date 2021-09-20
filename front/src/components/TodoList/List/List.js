import React from "react";

const List = (props) => {

  const deleteListTodo =(event)=>{
    props.handleDelete(+event.target.id);
  }

  return (
    <div className="list-group">
      { props.listaTodo && props.listaTodo.map(todoList=>{

          return(
            <div className="task" key={todoList.id}>

              <label> {todoList.nombre} </label>

              <div className="btn-group">
                <button 
                    id={todoList.id}
                    onClick={()=> alert("ADD TASK TO LIST")} 
                    className="edit"> + Task
                  </button> 
                  <button 
                    id={todoList.id}
                    onClick={deleteListTodo} 
                    className="remove"> - Task
                  </button> 
              </div>
            </div>
          )
        })
      }
    </div>
  );
}
export default List;