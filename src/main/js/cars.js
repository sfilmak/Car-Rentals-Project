import React from 'react'
import styled from "styled-components";
import { makeStyles } from '@material-ui/core/styles';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';

import { useHistory } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        overflow: 'hidden',
        backgroundColor: theme.palette.background.paper,
    },
    gridSubtile: {
        background: 'rgba(0, 0, 0, 0.8)'
    },
    gridTile: {
        cursor: 'pointer',
        width: '400px',
        height: '200px',
        marginBottom: '20px',
        "::marker": {
            display: 'none'
        }
    },
    title: {
        fontSize: '1.25rem',
    },
    subtitle: {
        fontSize: '1rem',
    },
}));

const GridList = styled.div`
    display: flex;
    margin-top: 20px;
    margin-bottom: 20px;
    flex-wrap: wrap;
    list-style:none;
    margin-right: 100px;
    margin-left: 100px;
    justify-content: space-around;
    @media (min-width: 768px) {
        margin-right: 0;
        margin-left: 0;
    }
`;

const Cars = ({ cars }) => {
    const classes = useStyles();
    const history = useHistory();

    function handleCarClick (e, car) {
        e.preventDefault();
        console.log('The link was clicked: ' + car.model);
    }

    return (
        <div className={classes.root}>
            <GridList>
                {cars.map((car) => (
                    <GridListTile key={car.imageURL} className={classes.gridTile}  onClick={(e) => handleCarClick(e, car)}>
                        <img src={car.imageURL} alt={car.model} />
                        <GridListTileBar className={classes.gridSubtile}
                                         title={<b className={classes.title}>{car.manufacturer} {car.model}</b>}
                                         subtitle={<span className={classes.subtitle}>{car.pricePerDay}$/day</span>}
                        />
                    </GridListTile>
                ))}
            </GridList>
        </div>
    );
};

export default Cars