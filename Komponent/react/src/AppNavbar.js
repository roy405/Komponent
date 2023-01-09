import React, { Component } from 'react';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }
    render() {
        return <nav className="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light shadow p-3 mb-5 bg-white rounded" id="ftco-navbar" >
            <style> </style>
            <div className="container">
                <a className="navbar-brand" href="Home">Komponent</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                        aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="oi oi-menu"></span> Menu
                </button>

                <div className="collapse navbar-collapse" id="ftco-nav">
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item active"><a href="Home" className="nav-link">Home</a></li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">Shop</a>
                            <div className="dropdown-menu" aria-labelledby="dropdown04">
                                <a className="dropdown-item" href="Cart">Cart</a>
                                <a className="dropdown-item" href="Orders">Orders</a>
                            </div>
                        </li>
                        <li className="nav-item"><a href="userProfile" className="nav-link">Profile</a></li>
                        <li className="nav-item"><a href="about" className="nav-link">About</a></li>
                        <li className="nav-item"><a href="contact" className="nav-link">Contact</a></li>
                        <li className="nav-item cta cta-colored"><a href="/userCart" className="nav-link">
                            <span className="icon-shopping_cart"></span>[0]</a></li>

                    </ul>
                </div>
            </div>
        </nav>;
    }
}