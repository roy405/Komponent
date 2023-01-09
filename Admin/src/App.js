import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Login from './Login';
import Registration from "./Registration";
import Dashboard from "./Dashboard";
import Product from "./Product";
import UserList from "./UserList";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Login}/>
              <Route path='/register' exact={true} component={Registration}/>
              <Route path='/dashboard' exact={true} component={Dashboard}/>
              <Route path="/products" exact={true} component={Product}/>
              <Router path="/userList" exact={true} component={UserList}/>
          </Switch>
        </Router>
    )
  }
}

export default App;
