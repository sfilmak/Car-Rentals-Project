import React from 'react'

const Cars = ({ cars }) => {
    return (
        <div>
            <h1>Cars List</h1>
            <table>
                <tbody>
                <tr>
                    <th>Manufacturer</th>
                    <th>Model</th>
                </tr>
                {cars.map((car) => (
                    <tr>
                        <td>{car.manufacturer}</td>
                        <td>{car.model}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
};

export default Cars