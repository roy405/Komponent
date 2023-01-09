import AppNavbar from './AppNavbar';
import { Link } from "react-router-dom";
import Loading from "./Loading";
import React, { Component } from 'react';
import {Redirect} from 'react-router-dom';


class Cart extends Component{

    constructor(props){
        super(props);
        this.state={cart:"", cartId:"", redirectToCheckout:false};
        this.changeQuantity = this.changeQuantity.bind(this);
        this.removeItem = this.removeItem.bind(this);
        this.checkoutBtn = this.checkoutBtn.bind(this);

    }

    componentDidMount(){
        fetch(`/cart/${localStorage.getItem('userId')}`)
            .then(response=>{
                return response.json();
            }).then(data=>{
                console.log(data);
                this.setState(({
                    cart:data
                }))
        })
    }


    changeQuantity(value,orderId,prodSizeId,index){

    }

    removeItem(orderId,prodSizeId){

    }

    checkoutBtn(){
        this.setState(({
            redirectToCheckout: true
        }))

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

                            <div className="buttons">
                                <span className="delete-btn"></span>
                                <span className="like-btn"></span>
                            </div>

                            <div className="image" >
                                <img src="" alt=""/>
                            </div>

                            <div className="description" >
                                <span>{prod.name}</span>
                                <span>{prod.description}</span>
                                <span>White</span>
                            </div>

                            <div className="quantity">
                                <button className="plus-btn" type="button" name="button">
                                    <img src="plus.svg" alt=""/>
                                </button>
                                <input type="text" name="name" value="1"/>
                                <button className="minus-btn" type="button" name="button">
                                    <img src="minus.svg" alt=""/>
                                </button>

                                <button>
                                    remove
                                </button>
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

export default Cart;