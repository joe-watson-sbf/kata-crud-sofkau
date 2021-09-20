import React from 'react';
import Task from '../../../Todo/ListarTodo/Task/Task';
import {Accordion} from 'react-bootstrap';

const ItemLista = ({todos}) => {
    return (
        <>
            {
                todos && todos.map((todo)=>{
                    return(
                        <Accordion.Body key={todo.id+89}>
                            <Task todo={todo} />
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
                            veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                            commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
                            velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id
                            est laborum.
                        </Accordion.Body>
                    )
                })
            }
        </>
    )
}

export default ItemLista
