import React, {Component} from 'react';
import './App.css';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import Loading from "./Loading";
import { Link } from 'react-router-dom';

class Login extends Component {

    constructor(props) {
        super(props);
       // this.state = {users: [], isLoading: true};
        this.state = {username: '', password: ''};
        this.changeHandler = this.changeHandler.bind(this);
        this.handleSignIn = this.handleSignIn.bind(this);
    }

    changeHandler = event =>
        this.setState({ [event.target.name]: event.target.value });


    handleSignIn(event){
        event.preventDefault();
        const data = new FormData(event.target);
        fetch("/login", {
            method: "POST",
            body: data
        })
        .then(response =>{
            console.log(response.status);
            if(response.status===200){
                response.json().then(userId=>{
                    localStorage.setItem("userId",userId);
                    window.location = "Home";
                });
            }else{
                alert("Incorrect Username/Password Combination!");
               window.location = "Login";
            }
        });
    }

    render(){
        return(
            <div className="authentication" align="center">
                <div>
                    <AppNavbar/>
                </div>
                <br/>
                <br/>
                <br/>
                <form onSubmit={this.handleSignIn} >
                <h2>Sign In</h2>
                <br/>
                <label>Username</label><input type="text" placeholder="username" name="username" value={this.state.username} onChange={this.changeHandler}/>
                <br/>
                <label>Password</label><label/><input type="password" placeholder="Password" name="password" value={this.state.password} onChange={this.changeHandler}/>
                <br/>
                <Button type="submit">Login</Button>
                <br/>
                <a className="dropdown-item" href="registration">Don't have an account? Register Now!</a>
                </form>
            </div>
        );
    }
}
export default Login;