import React, {Component} from 'react';
import './App.css';
import {Button, ButtonGroup, Container, Table} from 'reactstrap';
import AppNavbar from './AppNavbar';

class CheckOut extends Component {

     cartItem = {
         cart_total: '',
         shipping_cost: '',
         taxes: '',
         user: {},
         product: {},
         address: {},

    };

    constructor(props) {
        super(props);
        this.state = {cart: ""};
        this.state = {street1: '', street2: '', state: '', city: '', zip_code: '', country: ''};
        this.state = {payment_method: '', card_type: '', card_number: '', card_expiery: '', card_cvv: ''};
        //this.state = {cart: props.cart, cartId: this.props.location.state.id};
        this.changeHandler = this.changeHandler.bind(this);
        this.handlePlaceOrder = this.handlePlaceOrder.bind(this);
    }

    componentDidMount() {
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

    changeHandler = event =>
        this.setState({[event.target.name]: event.target.value});

    handlePlaceOrder(event) {
        event.preventDefault();
        const data = new FormData(event.target);
        console.log("data ",data.get('street1'));
        const order ={
            cart: {
                user:{
                    id:localStorage.getItem(('userId'))
                },
            },
            user:{
              id: localStorage.getItem(('userId'))
            },
            address:{
                street1:data.get("street1"),
                street2:data.get("street2"),
                state:data.get("state"),
                city:data.get("city"),
                zip_code: data.get("zip_code"),
                country: data.get("country"),
                address_type:""
            },
            payment:{
                payment_method: data.get("payment_method"),
                card_type: data.get("card_type"),
                card_number: data.get("card_number"),
                card_expiery: data.get("card_expiery"),
                card_cvv: data.get("card_cvv")
            }
        };
        console.log(order);
        fetch("/orders",{
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(order)
        }).then(response=> {
            alert("Your Order has been Successfully Placed!");
            window.location = "Home";
        })
    }



    render() {
        const cart = this.state.cart;
        console.log(cart);
        return (
            <div>
                {
                    cart!==undefined?(

                <div className="row">
                    <link rel="stylesheet" href="css/checkout.css"/>
                    <link rel="stylesheet"
                          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
                    <div className="col-75">
                        <div className="container">
                            <form onSubmit={this.handlePlaceOrder}>
                                <div className="row">
                                    <div className="col-50">
                                        <h3>Billing Address</h3>
                                        <label htmlFor="steet1"><i className="fa fa-user"/> Street 1</label>
                                        <input type="text" id="street1" name="street1" placeholder="Street 1"
                                               value={this.state.street1} onChange={this.changeHandler}/>
                                        <label htmlFor="street2"><i className="fa fa-envelope"/> Street 2</label>
                                        <input type="text" id="street2" name="street2" placeholder="Street 2"
                                               value={this.state.street2} onChange={this.changeHandler}/>
                                        <label htmlFor="city"><i className="fa fa-address-card-o"/> City</label>
                                        <input type="text" id="city" name="city" placeholder="City"
                                               value={this.state.city} onChange={this.changeHandler}/>
                                        <label htmlFor="state"><i className="fa fa-institution"/> State</label>
                                        <input type="text" id="state" name="state" placeholder="State"
                                               value={this.state.state} onChange={this.changeHandler}/>
                                        <div className="row">
                                            <div className="col-50">
                                                <label htmlFor="country">Country</label>
                                                <input type="text" id="country" name="country" placeholder="Country"
                                                       value={this.state.country} onChange={this.changeHandler}/>
                                            </div>
                                            <div className="col-50">
                                                <label htmlFor="zip_code">Postal Code</label>
                                                <input type="text" id="zip_code" name="zip_code" placeholder={10001}
                                                       value={this.state.zip_code} onChange={this.changeHandler}/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-50">
                                        <h3>Payment</h3>
                                        <label htmlFor="fname">Accepted Cards</label>
                                        <div className="icon-container">
                                            <i className="fa fa-cc-visa" style={{color: 'navy'}}/>
                                            <i className="fa fa-cc-amex" style={{color: 'blue'}}/>
                                            <i className="fa fa-cc-mastercard" style={{color: 'red'}}/>
                                            <i className="fa fa-cc-discover" style={{color: 'orange'}}/>
                                        </div>
                                        <label htmlFor="payment_method">Payment Method</label>
                                        <input type="text" id="payment_methd" name="payment_method"
                                               placeholder="Card or Cash" value={this.state.payment_method}
                                               onChange={this.changeHandler}/>
                                        <label htmlFor="card_type">Card Type</label>
                                        <input type="text" id="card_type" name="card_type" placeholder="Card Type"
                                               value={this.state.card_type} onChange={this.changeHandler}/>
                                        <label htmlFor="card_number">Card Number</label>
                                        <input type="text" id="card_number" name="card_number"
                                               placeholder="xxxx-xxxx-xxxx-1234" value={this.state.card_number}
                                               onChange={this.changeHandler}/>
                                        <div className="row">
                                            <div className="col-50">
                                                <label htmlFor="card_expiery">Expiry Date</label>
                                                <input type="date" id="card_expiery" name="card_expiery"
                                                       value={this.state.card_expiery} onChange={this.changeHandler}/>
                                            </div>
                                            <div className="col-50">
                                                <label htmlFor="card_cvv">CVV</label>
                                                <input type="text" id="card_cvv" name="card_cvv" placeholder={352}
                                                       value={this.state.card_cvv} onChange={this.changeHandler}/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <label>
                                    <input type="checkbox" defaultChecked="checked" name="sameadr"/> Shipping address
                                    same
                                    as billing
                                </label>
                                <input type="submit" defaultValue="Continue to checkout" className="btn"/>
                            </form>
                        </div>
                    </div>
                    <div className="col-25">
                        <div className="container">
                            <h4>Cart
                                <span className="price" style={{color: 'black'}}>
                <i className="fa fa-shopping-cart"/>
                <b>4</b>
              </span>
                            </h4>
                            <p><a href="#">Shipping</a> <span className="price"></span></p>
                            <p><a href="#">Taxes</a> <span className="price"></span></p>
                            <p><a href="#">Cart Total</a> <span className="price">{cart.cart_total}</span></p>
                            <hr/>
                            <p>Total <span className="price" style={{color: 'black'}}><b>$30</b></span></p>
                        </div>
                    </div>
                </div>
                    ):("")
                }
            </div>
        );
    }


}

export default CheckOut;