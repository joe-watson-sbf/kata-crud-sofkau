import React, {useState} from 'react'
import Todo from '../Todo/Todo';
import TodoList from '../TodoList/TodoList';

const Home = () => {

    const [showTodoList, setShowTodoList] = useState(false);
    const [showTodos, setShowTodos] = useState(false);

    const handleShowTodoList=()=>{
        setShowTodos(false);
        setShowTodoList(!showTodoList);
       
    }

    const handleShowTodos=()=>{
        setShowTodoList(false);
        setShowTodos(!showTodos);
        
    }


    return (

        <div className="home">
            <h1>ToDo App</h1>

            <div className="content">
                <div className="bord-l">

                    <div className="Todo">
                        <button onClick={handleShowTodos}> Todo </button>
                    </div>

                    <div className="todo-list">
                        <button onClick={handleShowTodoList}> Todo List </button>
                    </div>
                </div>

                {showTodoList &&
                     
                    <TodoList/>
                } 

                {
                    showTodos && 
                    <Todo/>
                }
            </div>
        </div>
    )
}

export default Home;
