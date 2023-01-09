import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import Footer from "./Footer";
import Loading from "./Loading";
import {Redirect} from "react-router-dom";

class Orders extends Component {

    constructor(props){
        super(props);

    }

    render(){
        return(
            <div>
                <div>
                    <AppNavbar/>

                </div>
                <br/>
                <br/>
                <br/>
                {
                    this.state.cart!=="" && this.state.cart.product.map((prod,index)=>{
                        console.log(prod);
                        return(
                            <div className="item" key={index}>
                                <div className="image" >
                                    <img src="" alt=""/>
                                </div>

                                <div className="description" >
                                    <span>{prod.name}</span>
                                    <span>{prod.description}</span>
                                    <span>White</span>
                                </div>
                                <div className="total-price">{prod.price}</div>
                            </div>
                        );
                    })
                }
                <div align="right">
                    <div>
                        <p>Total Price</p>
                    </div>
                    <div>
                        <button onClick={this.checkoutBtn}>
                            Checkout
                        </button>
                    </div>

                </div>
                {
                    this.state.redirectToCheckout?(
                        <Redirect to="/checkout"/>
                    ):("")
                }

            </div>
        )
    }


}
export default Orders;