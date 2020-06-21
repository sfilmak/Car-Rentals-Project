'use strict';

import React, {Component} from 'react';
import Cars from './Cars';
import Header from "./Header";
import CarInfo from "./CarInfo";
import {
	BrowserRouter as Router,
	Switch,
	Route
} from "react-router-dom";

class App extends Component {
	state = {
		cars: [],
		customers: [],
	};

	componentDidMount() {
		fetch('api/cars')
			.then(res => res.json())
			.then((data) => {
				this.setState({ cars: data._embedded.cars })
			})

		fetch('api/customers')
			.then(res => res.json())
			.then((data) => {
				this.setState({ customers: data._embedded.customers })
				//setCustomers(data._embedded.customers);
			})
	}

	render() {
		return [
			<Header/>,
			<Router>
				<div>
					<Switch>
						<Route exact path="/">
							<Cars cars={this.state.cars} />
						</Route>
						<Route path="/carInfo">
							<CarInfo cars={this.state.cars} customers={this.state.customers}/>
						</Route>
					</Switch>
				</div>
			</Router>
		]
	}
}

export default App;