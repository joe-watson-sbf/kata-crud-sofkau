import React from 'react'

const Form = (props) => {

    const handleAdd = (event)=>{
        event.preventDefault();
        props.add(event.target.task.value);
        event.target.reset();
    }


    return (
        <form className="form" onSubmit={event => handleAdd(event)}>
            <input name="task" placeholder={props.message} value={props.value} required/>
            <button type="submit">{props.btnText}</button>
        </form>
    )
}

export default Form
