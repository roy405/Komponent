import React, {Component} from "react";
import UserList from "./UserList";

class Product extends Component{

    constructor(props){
        super(props);
        this.state = {name: '', description:'', brand:'', quantity:'', price:'', scaledImage:'', fullImage:''}
        this.changeHandler= this.changeHandler.bind(this);
        this.handleProducts = this.handleProducts.bind(this);
    }
    changeHandler = event =>
        this.setState({[event.target.name]: event.target.value});

    handleProducts(event){
        event.preventDefault();
        const data = new FormData(event.target);
        const product = {
            name:data.get("productName"),
            description: data.get("productDescription"),
            brand: data.get("productBrand"),
            quantity: data.get("productQuantity"),
            price: data.get("productPrice"),
            scaledImage: data.get("productScaled"),
            fullImage: data.get("productFull")

        };
        fetch("/products",{
            method: "POST",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(product)
        }).then(response =>{
            alert("Product has been Successfully Added!")
            window.location="Dashboard"
        })
    }

    render() {
        return (
            <div>
                <title>Straits Admin Panel</title>
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <meta httpEquiv="Content-Type" content="text/html; charset=utf-8" />

                <link href="//fonts.googleapis.com/css?family=Carrois+Gothic" rel="stylesheet" type="text/css" />
                <link href="//fonts.googleapis.com/css?family=Work+Sans:400,500,600" rel="stylesheet" type="text/css" />

                <div className="signup-page-main">
                    <div className="signup-main">
                        <div className="signup-head">
                            <h1>Add a Product</h1>
                        </div>
                        <div className="signup-block">
                            <form onSubmit={this.handleProducts}>
                                <input type="text" name="productName" placeholder="Product Name" required />
                                <input type="text" name="productDescription" placeholder="Product Description" required />
                                <input type="text" name="productBrand" placeholder="Product Brand" required />
                                <input type="text" name="productQuantity" placeholder="Quantity" required />
                                <input type="text" name="productPrice" placeholder="Price" required />
                                <input type="text" name="productScaled" placeholder="Scaled Image Link" required />
                                <input type="text" name="productFull" placeholder="Enlarged Image Link" required />


                                <input type="submit" name="Sign In" defaultValue="Sign up" />
                            </form>
                            <div className="sign-down">
                                <h4>Already have an account? <a href="/"> Login here.</a></h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Product;