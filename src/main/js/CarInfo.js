import React from 'react'

const CarInfo = ({ cars }) => {
    let search = window.location.search;
    let params = new URLSearchParams(search);
    let carID = params.get('id');
    return (
        <div>
            <h2>CarID is {carID}</h2>
        </div>
    );
};

export default CarInfo