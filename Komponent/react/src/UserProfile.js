import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import Footer from "./Footer";
import Loading from "./Loading";
import {Button} from "reactstrap";
import {Redirect} from "react-router-dom";

class UserProfile extends Component {

    userInfo={
        first_name:'',
        last_name:'',
        username:'',
        email:'',
        password:'',
        cell_phone:'',
        dob:''
    };

    constructor(props) {
        super(props);
        this.state = {item: this.userInfo};
        this.state = {userId: localStorage.getItem("userId")};
        this.state = {redirectToEditProfile: false};
        this.onChangeHandler = this.onChangeHandler.bind(this);
        this.handleUserUpdate = this.handleUserUpdate.bind(this);

    }

    componentDidMount() {
        if (localStorage.getItem("userId")!== 'new') {
            fetch(`/users/${localStorage.getItem('userId')}`)
                .then(response => {
                    console.log(response)
                    return response.json();
                }).then(data => {
                this.setState({item: data});
            })

        }
    }

    onChangeHandler(event){
        let item = this.state.item;
        item[event.target.name] = event.target.value;
        this.setState({ item });
        // const name = event.target.name;
        // const value = event.target.value;
        // let item = this.state.item;
        // item[name] = value;
        // this.setState({
        //     item
        // });
    }

    handleUserUpdate(event){
        event.preventDefault();
        const data = new FormData(event.target);
        fetch(`/users/${localStorage.getItem('userId')}`, {
            method: "PUT",
            body: data
        });
        window.location = "UserProfile";
    }

    render() {

        const user = this.state.item;
            return (
                <div>
                    {
                        user !== undefined ? (
                            <div >
                                <div className="container-fluid" align="center" >
                                    <div>
                                        <AppNavbar/>
                                    </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <form onSubmit={this.handleUserUpdate}>
                                    <h1> Personal Details</h1>
                                    <label><b>First Name</b></label>&nbsp;<input type="text" name="first_name" value={user.first_name} onChange={this.onChangeHandler}/>
                                    <br/>
                                    <label><b>Last Name</b></label>&nbsp;<input type="text" name="last_name" value={user.last_name} onChange={this.onChangeHandler}/>
                                    <br/>
                                    <label><b>Username</b></label>&nbsp;<input type="text" name="username" value={user.username} onChange={this.onChangeHandler}/>
                                    <br/>
                                    <label><b>Email</b></label>&nbsp;<input type="email" name="email" value={user.email} onChange={this.onChangeHandler}/>
                                    <br/>
                                    <label><b>Password</b></label>&nbsp;<input type="password" name="password" value={user.password} onChange={this.onChangeHandler}/>
                                    <br/>
                                    <label><b>Cellphone</b></label>&nbsp;<input type="text" name="cell_phone" value={user.cell_phone} onChange={this.onChangeHandler}/>
                                    <br/>
                                    <label><b>DOB</b></label>&nbsp;<input type="text" name="dob" value={user.dob} onChange={this.onChangeHandler}/>
                                    <br/>
                                    <Button type="submit">
                                        Update Profile
                                    </Button>
                                    </form>
                                </div>
                            </div>
                        ) : ("")

                    }
                </div>
            );

    }

}

export default UserProfile;