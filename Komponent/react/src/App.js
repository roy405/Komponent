import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UserList from "./UserList";
import ProductDetail from './ProductDetail';
import Orders from './Orders';
import Login from './Login';
import Registration from './Registration';
import UserProfile from './UserProfile';
import EditUserProfile from './EditUserProfile';
import UserPayment from './UserPayment';
import Cart from './Cart';
import CheckOut from  './CheckOut';

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/login' exact={true} component={Login}/>
            <Route path='/home' exact={true} component={Home}/>
            <Route path='/users' exact={true} component={UserList}/>
            <Route path='/productDetails' exact={true} component={ProductDetail}/>
            <Route path='/orders' exact={true} component={Orders}/>
            <Route path='/registration' exact={true} component={Registration}/>
            <Route path='/userProfile' exact={true} component={UserProfile}/>
            <Route path='/editUserProfile' exact ={true} component={EditUserProfile}/>
            <Route path='/userPayment' exact={true} component={UserPayment}/>
            <Route path='/userCart' exact={true} component={Cart}/>
            <Route path='/checkout' exact={true} component={CheckOut}/>
          </Switch>
        </Router>
    )
  }
}

export default App;