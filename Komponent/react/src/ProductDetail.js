import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import Footer from "./Footer";
import Loading from "./Loading";
import {Alert, Button} from "reactstrap";

class ProductDetail extends Component {

    eItem={
        name:'',
        description:'',
        brand:'',
        quantity:'',
        price:'',
        fullImage:''
    };

    constructor(props) {
        super(props);
        console.log(this.props.location.state);
        this.state = {item: this.eItem};
        this.state = {products: [], isLoading: true};
        this.state = {product: props.product, prodId:this.props.location.state.id};
        this.handleSendToCart = this.handleSendToCart.bind(this);
    }

    componentDidMount(){
        if(this.props.match.params.id !== 'new'){
            fetch(`/products/${this.props.location.state.id}`)
            .then(response=>{
                return response.json();
            }).then(data=>{
                this.setState({item: data});
            })
        }
    }

    handleSendToCart(id){
        const data = {
             user:{
                 id:localStorage.getItem("userId")
             },
             product:[
                 {
                     id:id
                 }
             ]
        };
        fetch("/cart", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(response=>{
            console.log(response);
            window.location = "Home";
        });


}


    render() {
        console.log(this.state.item);
        const product = this.state.item;
        return(
            <div>
                {
                    product !== undefined ? (
                        <div>
                            <div className="appNavBar">
                                <AppNavbar/>
                            </div>
                            <br/>
                            <br/>
                            <br/>
                            <div className="productDetails" align="center">
                                <a href="#" className="img-prod"><img className="img-fluid" src={product.fullImage}
                                                                      alt="Colorlib Template"/></a>
                                <br/>
                                <div className="productName">
                                    <h3>{product.name}</h3>
                                </div>
                                <div className="productDescription">
                                    <p>{product.description}</p>
                                </div>
                                <div className="productBrand">
                                    <p>{product.brand}</p>
                                </div>
                                <div className="productQuantity">
                                    <p>{product.quantity}</p>
                                </div>
                                <div className="productPrice">
                                    <p>{product.price}</p>
                                </div>
                                <div>
                                    <Button onClick={()=>this.handleSendToCart(product.id)} className="AddToCart"> Add To Cart</Button>
                                </div>

                            </div>
                        </div>
                    ) : ("")
                }
            </div>
        );
    }


}
export default ProductDetail;