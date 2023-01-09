import React, {Component} from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import Footer from "./Footer";
import Loading from "./Loading";
import {Redirect} from "react-router-dom";

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {prodId:"", redirectToDetail:false, products: [], isLoading: true};
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('/products')
            .then(response => response.json())
            .then(data => this.setState({products: data, isLoading: false}));

    }

    clickHandler(id){
        console.log(id);
        this.setState(({
            prodId:id,
            redirectToDetail :true
        }))
        // event.preventDefault();
        // const data = new FormData(event.target);
        //
        // fetch("/login", {
        //     method: "POST",
        //     body: data
        // })
        //     .then(response => response.json())
        // window.location = "ProductDetail";
    }

    render() {

        const {products, isLoading} = this.state;

        if (isLoading) {
            return (
                <Loading/>
            );
        }

        const productsList = products.map(product => {
            return (

                <div className="col-md-3" key={product.id}>
                    <div className="col-sm col-md-6 col-lg-3 ftco-animate fadeInUp ftco-animated">
                        <div className="product">
                            <a href="#" className="img-prod"><img className="img-fluid" src={product.fullImage} alt="Colorlib Template" onClick={()=>this.clickHandler(product.id)}/></a>
                            <div className="text py-3 px-3">
                                <h3 onClick={()=>this.clickHandler(product.id)}><a href="#">{product.name} </a></h3>
                                <div className="d-flex">
                                    <div className="pricing">
                                        <p className="price"><span>{product.price}</span></p>
                                    </div>
                                </div>
                                <hr/>
                                <p className="bottom-area d-flex">
                                    <a href="#" className="add-to-cart"><span>Add to cart <i
                                        className="ion-ios-add ml-1"/></span></a>
                                    <a href="#" className="ml-auto"><span><i
                                        className="ion-ios-heart-empty"/></span></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            );
        });

        return (
            <div>
                {
                    this.state.redirectToDetail?(
                        <Redirect to={{pathname:"/productDetails",state:{id:this.state.prodId}}}/>
                    ):("")
                }
                <AppNavbar/>
                <section className="ftco-section bg-light">
                    <div className="container-fluid">
                        <div className="row">
                            {productsList}
                        </div>
                    </div>
                </section>

                <Footer/>
            </div>
        );
    }
}

export default Home;