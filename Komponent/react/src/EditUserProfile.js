import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import Footer from "./Footer";

class EditUserProfile extends Component {
    userInfo={
        first_name:'',
        last_name:'',
        username:'',
        email:'',
        password:'',
        cell_phone:'',
        dob:''
    };

    constructor(props){
        super(props);
        this.state = {item: this.userInfo};
        this.state = {user: props.user};
        this.state = {userId: localStorage.getItem("userId")};
        this.onClickHandler = this.onClickHandler.bind(this);
        this.changeHandler = this.changeHandler.bind(this);
    }

    componentDidMount() {
        if (localStorage.getItem("userId")!== 'new') {
            fetch(`/users/${localStorage.getItem('userId')}`)
                .then(response => {
                    return response.json();
                }).then(data => {
                this.setState({item: data});
            })

        }
    }

    changeHandler = event =>
        this.setState({ [event.target.name]: event.target.value });

    onClickHandler(event){
        event.preventDefault();
        const data = new FormData(event.target);
        console.log(data);
        fetch("/users", {
            method: "POST",
            body: data
        });
        window.location = "UserProfile";
    }

    render() {
        const user = this.state.item;
        return(
            <div>{
             user !== undefined?(
                 <div align="center">
                     <form className="updateUserForm" onSubmit={this.onClickHandler}>
                     <h3>Edit Details</h3>
                 <label>First Name</label><input type="text" name="firstName" value={user.first_name} onChange={this.changeHandler}/>
                 <br/>
                 <label>Last Name</label><input type="text" name="lastName" value={user.last_name} onChange={this.changeHandler}/>
                 <br/>
                 <label>User Name</label><input type="text" name="username" value={user.username} onChange={this.changeHandler}/>
                 <br/>
                 <label>E-mail</label><input type="text" name="email" value={user.email} onChange={this.changeHandler}/>
                 <br/>
                 <label>Password</label><input type="password" name="password" value={user.password} onChange={this.changeHandler}/>
                 <br/>
                 <label>Cell Phone</label><input type="text" name="cellphone" value={user.cell_phone} onChange={this.changeHandler}/>
                 <br/>
                 <label>DOB</label><input type="date" name="dob" value={user.dob} onChange={this.changeHandler}/>
                 </form>

                </div>
             ):("")
            }
            </div>

        )
    }

}

export default EditUserProfile;