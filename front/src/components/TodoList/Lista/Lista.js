import React from 'react';
import {Accordion} from 'react-bootstrap';
import ItemLista from './ItemLista/ItemLista';

const Lista = ({listaTodo, handleDelete}) => {
    return (
        <div>
            {listaTodo && listaTodo.map((lista, index)=>{
                return(
                    <Accordion key={lista.id} defaultActiveKey="0" flush>
                        <Accordion className="m-2" >
                            <Accordion.Item eventKey={index}>
                                <Accordion.Header>{lista.nombre}</Accordion.Header>
                                    <ItemLista todo={lista.todos}/>
                            </Accordion.Item>
                        </Accordion>
                    </Accordion>
                )

            })
                
            }
        </div>
    )
}

export default Lista
