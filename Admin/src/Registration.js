import React, {Component} from "react";

class Registration extends Component{
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
                                <form>
                                    <input type="text" name="fname" placeholder="First Name" required />
                                    <input type="text" name="lname" placeholder="Last Name" required />
                                    <input type="text" name="username" placeholder="Username" required />
                                    <input type="text" name="email" placeholder="Email" required />
                                    <input type="password" name="password" className="lock" placeholder="Password" />

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

export default Registration;