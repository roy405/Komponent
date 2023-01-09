import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import Loading from "./Loading";
import { Link } from 'react-router-dom';

class Registration extends Component {

    constructor(props){
        super(props);
        this.state = {firstName: '', lastName: '', username:'',email:'',password:'',cellphone:'',dob:'', };
        this.changeHandler= this.changeHandler.bind(this);
        this.handleSignUp = this.handleSignUp.bind(this);
    }

    changeHandler = event =>
        this.setState({ [event.target.name]: event.target.value });

    handleSignUp(event){
        event.preventDefault();
        const data = new FormData(event.target);
        console.log(data);
        fetch("/users", {
            method: "POST",
            body: data
        }).then(response=>{
            return response.json();
        }).then(data=>{
            alert("registration successful");
            window.location = "Login";
        }).catch(error=>{
            alert("User already registered!");
        })

    }

    render() {
        return(
            <div className="Registration" align="center">
                <div className="NavBar">
                    <AppNavbar/>
                </div>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <form className="RegistrationForm" onSubmit={this.handleSignUp}>
                <h2>Sign Up</h2>
                <label>First Name</label><input type="text" placeholder="First Name" name="firstName" value={this.state.firstName} onChange={this.changeHandler}/>
                <br/>
                <label>Last Name</label><input type="text" placeholder="Last Name" name="lastName" value={this.state.lastName} onChange={this.changeHandler}/>
                <br/>
                <label>User Name</label><input type="text" placeholder="User Name" name="username" value={this.state.username} onChange={this.changeHandler}/>
                <br/>
                <label>E-mail</label><input type="email" placeholder="E-mail" name="email" value={this.state.email} onChange={this.changeHandler}/>
                <br/>
                <label>Password</label><input type="password" placeholder="Password" name="password" value={this.state.password} onChange={this.changeHandler}/>
                <br/>
                <label>Cell Phone</label><input type="text" placeholder="Cell Phone" name="cellphone" value={this.state.cellphone} onChange={this.changeHandler}/>
                <br/>
                <label>DOB</label><input type="date" placeholder="dOB" name="dob" value={this.state.dob} onChange={this.changeHandler}/>
                <br/>
                <Button type="submit">Register</Button>
                </form>
            </div>
        )
    }
}

export default Registration;