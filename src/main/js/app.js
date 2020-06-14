'use strict';
// tag::vars[]
import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import Cars from './cars';
// end::vars[]

class App extends Component {

	state = {
		cars: []
	};

	componentDidMount() {
		fetch('api/cars')
			.then(res => res.json())
			.then((data) => {
				this.setState({ cars: data._embedded.cars })
			})
			.catch(console.log)
	}

	render() {
		return (
			<Cars cars={this.state.cars} />
		)
	}
}

ReactDOM.render(
	<App/>,
	document.getElementById('react')
);