import React from 'react'

const CarInfo = ({ cars }) => {
    let search = window.location.search;
    let params = new URLSearchParams(search);
    let carID = parseInt(params.get('id'));

    return (
        <div>
            <h2>CarID is {carID}</h2>
            {cars.filter(function (car) {
                return car.carID === carID
            }).map((car) => (
                <h2>Car model: {car.model}</h2>
            ))}
        </div>
    );
};


export default CarInfo