import React, {Component} from "react";

class Dashboard extends Component{
        render() {
            return (
                <div>
                    <title>Shoppy an Admin Panel Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
                    <meta name="viewport" content="width=device-width, initial-scale=1" />
                    <meta httpEquiv="Content-Type" content="text/html; charset=utf-8" />
                    {/*Google Fonts*/}
                    <link href="//fonts.googleapis.com/css?family=Carrois+Gothic" rel="stylesheet" type="text/css" />
                    <link href="//fonts.googleapis.com/css?family=Work+Sans:400,500,600" rel="stylesheet" type="text/css" />

                    <div className="page-container">
                        <div className="left-content">
                            <div className="mother-grid-inner">
                                {/*header start here*/}
                                <div className="header-main">
                                    <div className="header-left">
                                        <div className="clearfix"> </div>
                                    </div>
                                    <div className="header-right">
                                        <div className="profile_details_left">{/*notifications of menu start */}

                                            <div className="clearfix"> </div>
                                        </div>
                                        {/*notification menu end */}
                                        <div className="profile_details">
                                            <ul>
                                                <li className="dropdown profile_details_drop">
                                                    <a className="dropdown-toggle">
                                                        <div className="profile_img">
                                                            <div className="user-name">
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div className="clearfix"> </div>
                                    </div>
                                    <div className="clearfix"> </div>
                                </div>
                                {/*heder end here*/}
                                {/*inner block start here*/}
                                <div className="inner-block">
                                    {/*market updates updates*/}
                                    {/*main page chart layer2*/}
                                    <div className="chart-layer-2">
                                        <div className="col-md-6 chart-layer2-right">

                                        </div>
                                        <div className="col-md-6 chart-layer2-left">
                                            <div className="content-main revenue">
                                                <h3>Komponent</h3>
                                                <canvas id="radar" height={300} width={300} style={{width: '300px', height: '300px'}} />
                                            </div>
                                        </div>
                                        <div className="clearfix"> </div>
                                    </div>

                                </div>
                                {/*inner block end here*/}
                            </div>
                        </div>
                        {/*slider menu*/}
                        <div className="sidebar-menu">
                            <img className="dash-logo" src={require("./img/logo.png")} alt=""/>
                            <div className="menu">
                                <ul id="menu">
                                    <li id="menu-home"><a href="/dashboard"><i className="fa fa-tachometer" /><span>Dashboard</span></a></li>



                                    <li><a href="charts.html"><i className="fa fa-bar-chart" /><span>Charts</span></a></li>
                                    <li><a href="#"><i className="fa fa-envelope" /><span>Mailbox</span><span className="fa fa-angle-right" style={{float: 'right'}} /></a>
                                        <ul id="menu-academico-sub">
                                            <li id="menu-academico-avaliacoes"><a href="inbox.html">Inbox</a></li>
                                            <li id="menu-academico-boletim"><a href="inbox-details.html">Compose email</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#"><i className="fa fa-shopping-cart" /><span>E-Commerce</span><span className="fa fa-angle-right" style={{float: 'right'}} /></a>
                                        <ul id="menu-academico-sub">
                                            <li id="menu-academico-avaliacoes"><a href="/products">Products</a></li>
                                            <li id="menu-academico-boletim"><a href="/users">Users</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div className="clearfix"> </div>
                    </div>
                </div>
            );
        }
}

export default Dashboard;