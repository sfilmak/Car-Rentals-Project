'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {cars: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/cars'}).done(response => {
			this.setState({cars: response.entity._embedded.cars});
		});
	}

	render() { // <3>
		return (
			<CarList cars={this.state.cars}/>
		)
	}
}
// end::app[]

// tag::car-list[]
class CarList extends React.Component{
	render() {
		const cars = this.props.cars.map(car =>
			<Car key={car._links.self.href} car={car}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Car manufacturer</th>
						<th>Car model</th>
					</tr>
					{cars}
				</tbody>
			</table>
		)
	}
}
// end::car-list[]

// tag::car[]
class Car extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.car.manufacturer}</td>
				<td>{this.props.car.model}</td>
			</tr>
		)
	}
}
// end::car[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]