import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';

const useStyles = makeStyles((theme) => ({
    root: {
        overflow: 'hidden',
        backgroundColor: theme.palette.background.paper,
    },
    gridList: {
        marginLeft: '100px !important',
        marginRight: '100px !important',
        marginTop: '20px !important',
        marginBottom: '20px !important',
    },
    gridSubtile: {
        background: 'rgba(0, 0, 0, 0.8)'
    },
    gridTile: {
        display: 'block',
        cursor: 'pointer',
    },
    title: {
        fontSize: '1.25rem',
    },
    subtitle: {
        fontSize: '1rem',
    },
}));

const Cars = ({ cars }) => {
    const classes = useStyles();

    function handleCarClick (e, car) {
        e.preventDefault();
        console.log('The link was clicked: ' + car.model);
    }

    return (
        <div className={classes.root}>
            <GridList cellHeight={245} cols={3} className={classes.gridList}>
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