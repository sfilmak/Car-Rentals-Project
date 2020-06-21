import React from 'react'
import {makeStyles} from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import GridListTileBar from "@material-ui/core/GridListTileBar";
import GridListTile from "@material-ui/core/GridListTile";
import Button from '@material-ui/core/Button';

import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import Avatar from '@material-ui/core/Avatar';

import EventIcon from '@material-ui/icons/Event';
import DriveEtaIcon from '@material-ui/icons/DriveEta';
import SpeedIcon from '@material-ui/icons/Speed';
import ColorLensIcon from '@material-ui/icons/ColorLens';

import CustomizedDialogs, {DialogTitle} from "./Dialog";
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import Dialog from "@material-ui/core/Dialog";
import styled from "styled-components";

const useStyles = makeStyles((theme) => ({
    root: {
        display: "flex",
        flexWrap: "wrap",
    },
    paper: {
        padding: theme.spacing(2),
        color: theme.palette.text.secondary,
        marginBottom: '20px',
        marginTop: '20px',
    },
    gridSubtile: {
        background: 'rgba(0, 0, 0, 0.8)'
    },
    gridTile: {
        height: '260px',
        marginBottom: '20px',
        marginTop: '20px',
        "::marker": {
            display: 'none',
        },
    },
    title: {
        fontSize: '1.25rem',
    },
    subtitle: {
        fontSize: '1rem',
    },
    button_service: {
        textAlign: "center",
        width: "100%",
        backgroundColor: '#FF775A',
        '&:hover': {
            backgroundColor: '#f32e00',
            borderColor: '#f62900',
            boxShadow: 'none',
        },
        color: "white",
    },
    carInfoList: {
        width: '100%',
        marginTop: "20px",
    },
    list_avatar: {
        backgroundColor: '#FF775A',
    },
    selectorList: {
        width: "100%",
    },
    formControl: {
        minWidth: 120,
        width: "100%",
        margin: "0px !important",
    },
    paperContent: {
        margin: "20px",
    },
    input: {
        '&:focus': {
            borderColor: '#FF775A',
        },
    },
    formTitle: {
        margin: "0px !important",
        color: "black",
        marginTop: "20px !important",
    },
    textField: {
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: "100%",
        margin: "0px !important",
        '& label.Mui-focused': {
            color: 'red',
        },
        '& .MuiInput-underline:after': {
            borderBottomColor: '#FF775A',
        },
    },
    bookButton: {
        marginTop: "35px",
        marginBottom: "10px",
        textAlign: "center",
        display: "block",
        margin: "0 auto",
        backgroundColor: '#ff2c00',
        '&:hover': {
            backgroundColor: '#d42a00',
            borderColor: '#cb2200',
            boxShadow: 'none',
        },
        color: "white",
    },
    inputField: {
        minWidth: 120,
        width: "100%",
        margin: "0px !important",
        '& label.Mui-focused': {
            color: '#FF775A',
        },
        '& .MuiInput-underline:after': {
            borderBottomColor: '#FF775A',
        },
    },
    selectorColor: {
        '&:after': {
            borderColor: '#FF775A',
        }
    },
    notFoundLabel: {
        textAlign: "center",
    },
}));

const GridHalf = styled.div`
    flex: 50%;
`;

const GridCellLeft = styled.div`
    margin-right: 40px;
    margin-left: 40px;
      @media (min-width: 768px) {
       margin-right: 20px;
       margin-left: 150px;
    }
`;

const GridCellRight = styled.div`
      margin-right: 40px;
      margin-left: 40px;
      @media (min-width: 768px) { 
        margin-right: 150px;
        margin-left: 20px;
    }
`;

const CarInfo = ({ cars }) => {
    const classes = useStyles();
    const search = window.location.search;
    const params = new URLSearchParams(search);
    const carID = parseInt(params.get('id'));
    const [customerID, setCustomerID] = React.useState('');
    const [ti_ID, setTiID] = React.useState('');
    const [mechanicID, setMechanicID] = React.useState('');

    const handleCustomerSelection = (event) => {
        setCustomerID(event.target.value);
    };

    const handleTechnicalInspectionSelection = (event) => {
        setTiID(event.target.value);
    };

    const handleMechanicSelection = (event) => {
        setMechanicID(event.target.value);
    };

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
    };

    let ourCar = cars.filter(function (car) {
        return car.carID === carID
    });

    return (
        <div>
            {ourCar.length > 0 ? (ourCar.map((car) => (
                <div className={classes.root}>
                    <GridHalf className="column">
                        <GridCellLeft>
                            <h3>Car info</h3>
                            <GridListTile className={classes.gridTile}>
                                <img src={car.imageURL}/>
                                <GridListTileBar className={classes.gridSubtile}
                                                 title={<b className={classes.title}>{car.manufacturer} {car.model}</b>}
                                                 subtitle={<span className={classes.subtitle}>{car.pricePerDay}$/day</span>}
                                />
                            </GridListTile>
                            <Button size="large"
                                    onClick={handleClickOpen}
                                    className={classes.button_service}
                                    variant="contained">
                                Open service history
                            </Button>
                            <List className={classes.carInfoList}>
                                <ListItem>
                                    <ListItemAvatar>
                                        <Avatar className={classes.list_avatar}>
                                            <EventIcon/>
                                        </Avatar>
                                    </ListItemAvatar>
                                    <ListItemText primary="Date of manufacture" secondary={car.dateOfManufacture}/>
                                </ListItem>
                                <ListItem>
                                    <ListItemAvatar>
                                        <Avatar className={classes.list_avatar}>
                                            <DriveEtaIcon/>
                                        </Avatar>
                                    </ListItemAvatar>
                                    <ListItemText primary="Engine type" secondary="Placeholder TODO"/>
                                </ListItem>
                                <ListItem>
                                    <ListItemAvatar>
                                        <Avatar className={classes.list_avatar}>
                                            <ColorLensIcon/>
                                        </Avatar>
                                    </ListItemAvatar>
                                    <ListItemText primary="Color" secondary={car.color}/>
                                </ListItem>
                                <ListItem>
                                    <ListItemAvatar>
                                        <Avatar className={classes.list_avatar}>
                                            <SpeedIcon/>
                                        </Avatar>
                                    </ListItemAvatar>
                                    <ListItemText primary="Max speed" secondary={car.maxSpeed}/>
                                </ListItem>
                            </List>
                        </GridCellLeft>
                    </GridHalf>
                    <GridHalf className="column">
                        <GridCellRight>
                            <h3>Create a rent for this car</h3>
                            <Paper className={classes.paper}>
                                <div className={classes.paperContent}>
                                    <h2 className={classes.formTitle}>Select customer</h2>
                                    <FormControl className={classes.formControl}>
                                        <InputLabel>Customer</InputLabel>
                                        <Select
                                            className={classes.selectorColor}
                                            id="customer-selector"
                                            value={customerID}
                                            onChange={handleCustomerSelection}>
                                            <MenuItem value={1}>Artsiom Paliaschuk</MenuItem>
                                            <MenuItem value={2}>Oleksandr Sidletskyi</MenuItem>
                                            <MenuItem value={3}>Yuta Maejima</MenuItem>
                                        </Select>
                                    </FormControl>
                                    <h2 className={classes.formTitle}>Select date of start</h2>
                                    <form className={classes.container} noValidate>
                                        <TextField
                                            id="rentalStartDate"
                                            label="Rental start date"
                                            type="date"
                                            className={classes.textField}
                                            InputLabelProps={{
                                                shrink: true,
                                            }}/>
                                    </form>
                                    <h2 className={classes.formTitle}>Select date of end</h2>
                                    <form className={classes.container} noValidate>
                                        <TextField
                                            id="rentalEndDate"
                                            label="Rental end date"
                                            type="date"
                                            className={classes.textField}
                                            InputLabelProps={{
                                                shrink: true,
                                            }}/>
                                    </form>
                                    <h2 className={classes.formTitle}>Select type of technical review</h2>
                                    <FormControl className={classes.formControl}>
                                        <InputLabel>Technical review type</InputLabel>
                                        <Select
                                            className={classes.selectorColor}
                                            id="technical-review-type-selector"
                                            value={ti_ID}
                                            onChange={handleTechnicalInspectionSelection}>
                                            <MenuItem value={100}>Type 1</MenuItem>
                                            <MenuItem value={200}>Type 2</MenuItem>
                                            <MenuItem value={300}>Type 3</MenuItem>
                                        </Select>
                                    </FormControl>

                                    <h2 className={classes.formTitle}>Select mechanic</h2>
                                    <FormControl className={classes.formControl}>
                                        <InputLabel>Mechanic</InputLabel>
                                        <Select
                                            className={classes.selectorColor}
                                            id="mechanic-selector"
                                            value={mechanicID}
                                            onChange={handleMechanicSelection}>
                                            <MenuItem value={12}>Mechanic 1</MenuItem>
                                            <MenuItem value={15}>Mechanic 2</MenuItem>
                                            <MenuItem value={16}>Mechanic 3</MenuItem>
                                        </Select>
                                    </FormControl>

                                    <h2 className={classes.formTitle}>Additional comments</h2>
                                    <TextField className={classes.inputField}
                                               id="standard-full-width"
                                               style={{margin: 8}}
                                               placeholder="Additional comments..."
                                               fullWidth
                                               margin="normal"
                                               InputLabelProps={{
                                                   shrink: true,
                                               }}
                                    />
                                    <Button variant="contained" size="large" className={classes.bookButton}>
                                        Book a car
                                    </Button>
                                </div>
                            </Paper>
                        </GridCellRight>
                    </GridHalf>
                </div>
            ))): (
                <b className={classes.notFoundLabel}>No car found with this ID</b>
            )}
            <Dialog onClose={handleClose} aria-labelledby="customized-dialog-title" open={open}>
                <DialogTitle id="customized-dialog-title" onClose={handleClose}>
                    Service history
                </DialogTitle>
                <CustomizedDialogs/>
            </Dialog>
        </div>
    );
};

export default CarInfo