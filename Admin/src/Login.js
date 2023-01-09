import React, {Component} from "react";

class Login extends Component{

    constructor(props){
        super(props);
        this.state = {username: '', password:''};
        this.changeHandler = this.changeHandler.bind(this);
        this.handlerSignIn = this.handlerSignIn.bind(this);
    }

    changeHandler = event =>
        this.setState({[event.target.name]: event.target.value});

    handlerSignIn(event){
        event.preventDefault();
        const data = new FormData(event.target);
        console.log(data);
        fetch("http://localhost:8080/login",{
            method: "POST",
            body: data
        })
            .then(response=>{
                if(response.status===200){
                    console.log(response);
                    response.json().then(userId=>{
                        localStorage.setItem("userId", userId);
                        window.location = "Dashboard";
                    })
                }else{
                    alert("Incorrect Username/Password Combination!");
                    window.location = "Login";
                }
            })
    }
        render() {
            return (
                <div>
                    <title>Komponent Admin Panel</title>
                    <meta name="viewport" content="width=device-width, initial-scale=1" />
                    <meta httpEquiv="Content-Type" content="text/html; charset=utf-8" />

                    {/*Google Fonts*/}
                    <link href="//fonts.googleapis.com/css?family=Carrois+Gothic" rel="stylesheet" type="text/css" />
                    <link href="//fonts.googleapis.com/css?family=Work+Sans:400,500,600" rel="stylesheet" type="text/css" />

                    <div className="login-page">
                        <div className="login-main">
                            <div className="login-head">
                                <img className="login-logo" src={require("./img/logo.png")} alt="" />
                            </div>
                            <div className="login-block">
                                <form onSubmit={this.handlerSignIn}>
                                    <input type="text" name="username" placeholder="username" value={this.state.username} onChange={this.changeHandler} required />
                                    <input type="password" name="password" className="lock" placeholder="Password" value={this.state.password} onChange={this.changeHandler}/>
                                    <div className="forgot-top-grids">
                                        <div className="forgot-grid">
                                            <ul>
                                                <li>
                                                    <input type="checkbox" id="brand1" defaultValue />
                                                    <label htmlFor="brand1"><span />Remember me</label>
                                                </li>
                                            </ul>
                                        </div>
                                        <div className="clearfix"> </div>
                                    </div>
                                    <input type="submit" name="Sign In" defaultValue="Login"  />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            );
        }
}

export default Login;