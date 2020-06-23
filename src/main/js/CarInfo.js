import React, {useEffect, useState} from 'react'
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
import ColorLensIcon from '@material-ui/icons/ColorLens';
import FavoriteIcon from '@material-ui/icons/Favorite';

import CustomizedDialogs, {DialogTitle} from "./Dialog";
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import Dialog from "@material-ui/core/Dialog";
import styled from "styled-components";
import dayjs from "dayjs";
import relativeTime from 'dayjs/plugin/relativeTime';
dayjs.extend(relativeTime)
import axios from "axios";

import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import useMediaQuery from '@material-ui/core/useMediaQuery';
import { useTheme } from '@material-ui/core/styles';

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

const CarInfo = ({cars, customers, specializations}) => {
    const classes = useStyles();
    const search = window.location.search;
    const params = new URLSearchParams(search);
    const carID = parseInt(params.get('id'));
    const [customerID, setCustomerID] = useState('');
    const [ti_ID, setTiID] = useState('');
    const [mechanicID, setMechanicID] = useState('');
    const [services, setServices] = useState([]);
    const [mechanics, setMechanics] = useState([]);
    const [carRentals, setCarRentals] = useState([]);
    const [engine, setEngine] = useState('')
    const [startDate, setStartDate] = useState(dayjs())
    const [endDate, setEndDate] = useState(dayjs())
    const [comments, setComments] = useState("No comments")

    const [isCustomerSelected, setIsCustomerSelected] = useState(false);
    const [isStartDateCorrect, setISStartDateCorrect] = useState(false);
    const [isEndDateCorrect, setIsEndDateCorrect] = useState(false);
    const [isReviewTypeSelected, setIsReviewTypeSelected] = useState(false);
    const [isMechanicSelected, setIsMechanicSelected] = useState(false);

    const [isButtonDisabled, setButtonDisabled] = useState(true)

    const [rentalStartMessage, setRentalStartMessage] = React.useState('Select start date');
    const [rentalStartCorrectness, setRentalStartCorrectness] = React.useState(false);
    const [rentalEndMessage, setRentalEndMessage] = React.useState('Select end date');
    const [rentalEndCorrectness, setRentalEndCorrectness] = React.useState(false);

    const [openFinalDialog, setFinalDialogOpen] = React.useState(false);
    const theme = useTheme();
    const fullScreen = useMediaQuery(theme.breakpoints.down('sm'));
    const [isRentalAdded, setRentalAdded] = React.useState(false);
    const [rentalStatusHeader, setRentalStatusHeader] = React.useState('Customer can not drive!');
    const [rentalStatusComment, setRentalStatusComment] = React.useState('Sorry, but this customer can not drive - he/she is too young. Please, select a different customer.');

    const [inspectionType, setInspectionType] = React.useState('ENGINE');

    const handleStartDateChange = () => {
        const receivedDate = dayjs(document.getElementById("rentalStartDate").value);
        const checkedDate = !checkIsDateBetweenDates(receivedDate);
        const notInPast = receivedDate.isAfter(dayjs())
        setISStartDateCorrect(checkedDate && notInPast);
        if(checkedDate && notInPast){
            setRentalStartMessage('Car rental start date');
            setRentalStartCorrectness(false);
            if(isCustomerSelected && isMechanicSelected && isReviewTypeSelected && isEndDateCorrect) {
                setButtonDisabled(false);
            }
        } else {
            setRentalStartMessage('Error: select different date');
            setRentalStartCorrectness(true);
            setButtonDisabled(true);
        }
        setStartDate(receivedDate.add(1, 'day'));

    };

    const handleEndDateChange = () => {
        const receivedEndDate = dayjs(document.getElementById("rentalEndDate").value);
        console.log("HandleEndDateChange: " + document.getElementById("rentalEndDate").value);
        const notBetweenCurrDates = !checkIsDateBetweenDates(receivedEndDate);
        const afterStartDate = receivedEndDate.isAfter(startDate.subtract(1, 'day'))
        //const oldDatesNotBetweenNew = !checkIsOldDateBetweenDates(receivedEndDate);
        setIsEndDateCorrect(notBetweenCurrDates && afterStartDate);
        if(notBetweenCurrDates && afterStartDate){
            setRentalEndMessage('Car rental end date');
            setRentalEndCorrectness(false);
            if(isCustomerSelected && isMechanicSelected && isReviewTypeSelected && isStartDateCorrect) {
                setButtonDisabled(false);
            }
        } else {
            setRentalEndMessage('Error: select different end date');
            setRentalEndCorrectness(true);
            setButtonDisabled(true);
        }
        setEndDate(receivedEndDate.add(1, 'day'));

    };

    function checkIsDateBetweenDates(givenDate) {
        for (let i = 0; i < carRentals.length; i++) {
            if (validateDateBetweenTwoDates(dayjs(carRentals[i].startDate), dayjs(carRentals[i].endDate), givenDate)) {
                console.log('You cannot rent this car in this time period!');
                return true;
            }
        }
        return false;
    }

    function validateDateBetweenTwoDates(startDate, endDate, givenDate) {
        return givenDate.isBefore(endDate) && givenDate.isAfter(startDate);
    }

    useEffect(() => {
        fetch('api/cars/' + carID + '/engine')
            .then(res => res.json())
            .then((data) => {
                setEngine(data)
            })
        fetch('api/cars/' + carID + '/carRentals')
            .then(res => res.json())
            .then((data) => {
                setCarRentals(data._embedded.carRentals)
            })
    }, [])

    const handleCustomerSelection = (event) => {
        setCustomerID(event.target.value);
        setIsCustomerSelected(true);
    };

    const handleTechnicalInspectionSelection = (event) => {
        setTiID(event.target.value);


        setButtonDisabled(true);
        setIsMechanicSelected(false);
        //setInspectionType(data._embedded.)
        fetch('api/specializations/' + event.target.value + '/mechanics')
            .then(res => res.json())
            .then((data) => {
                setMechanics(data._embedded.mechanics)
                setIsReviewTypeSelected(true);
                setMechanicID('');
            })
    };

    const handleMechanicSelection = (event) => {
        setMechanicID(event.target.value);
        setIsMechanicSelected(true);
        if(isCustomerSelected && isReviewTypeSelected && isStartDateCorrect && isEndDateCorrect) {
            setButtonDisabled(false);
        }
    };

    const [open, setOpen] = React.useState(false);

    const handleClose = () => {
        setOpen(false);
    };

    let ourCar = cars.filter(function (car) {
        return car.carID === carID
    });

    const handleClickOpen = () => {
        loadListOfServices();
    };

    const handleCommentsChange = () => {
        setComments(document.getElementById("commentsInput").value);
    };

    function loadListOfServices() {
        fetch('api/cars/' + carID + '/technicalInspectionsSet')
            .then(res => res.json())
            .then((data) => {
                setServices(data._embedded.technicalInspections);
                setOpen(true);
            })
    }

    function getCustomerByID(arr, value) {
        const result = arr.filter(function (o) {
            return o.id === value;
        });
        return result? result[0] : null; // or undefined
    }

    function canCustomerDrive() {
        const resultOfCustomer = getCustomerByID(customers, customerID);
        console.log(customerID);
        console.log(resultOfCustomer.birthdate);
        console.log(dayjs().diff(dayjs(resultOfCustomer.birthdate), "years"));
        console.log(dayjs().from(dayjs(resultOfCustomer.birthdate)));
        if(dayjs().diff(dayjs(resultOfCustomer.birthdate), "years") >= 18){
            return true;
        } else {
            return false;
        }
    }

    const handleFinalDialogClickOpen = () => {
        setFinalDialogOpen(true);
    };

    const handleFinalDialogClose = () => {
        if(isRentalAdded){
            window.open("http://localhost:8080/","_self")
        } else {
            setFinalDialogOpen(false);
        }
    };

    const buttonClick = () => {
        setRentalStatusHeader("Done!");
        setRentalStatusComment("Awesome, a new car rental was created!");
        console.log(canCustomerDrive());
        if(canCustomerDrive() === true){
            console.log("Customer can drive!");
            axios.post('api/carRentals', {
                startDate: startDate,
                endDate: endDate,
                comments: comments,
                rentalStatus: 'PLANNED',
                car: 'http://localhost:8080/api/cars/' + carID,
                customer: 'http://localhost:8080/api/customers/' + customerID,
            })
                .then(response => {
                    console.log(response);
                    return axios.post('api/orderBonuses', {
                        bonusForOrder: 330,
                        carRental: response.data._links.carRental.href,
                        consultant: 'http://localhost:8080/api/consultants/21'
                    })
                })
                .then(response => {
                    console.log("Second response: " + response);
                    setRentalAdded(true);
                    return axios.post('api/technicalInspections', {
                        date: dayjs(),
                        arePartsReplaced: true,
                        carMileage: 5000,
                        type: inspectionType,
                        mechanic: 'http://localhost:8080/api/mechanics/' + mechanicID,
                        car: 'http://localhost:8080/api/cars/' + carID
                    })
                })
                .then(response => {
                    console.log("Third response: " + response);
                    handleFinalDialogClickOpen();
                })
                .catch(function (error) {
                    console.log(error);
                });
        } else {
            setRentalStatusHeader("This customer can not drive!");
            setRentalStatusComment("Sorry, but this customer can not drive - he/she is too young. Please, select a different customer.");
            handleFinalDialogClickOpen();
        }
    };

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
                                                 subtitle={<span
                                                     className={classes.subtitle}>{car.pricePerDay}$/day</span>}
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
                                            <FavoriteIcon/>
                                        </Avatar>
                                    </ListItemAvatar>
                                    <ListItemText primary="Engine"
                                                  secondary={<span>{engine.name} | {engine.type}</span>}/>
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
                                            <DriveEtaIcon/>
                                        </Avatar>
                                    </ListItemAvatar>
                                    <ListItemText primary="Car type" secondary={car.carType}/>
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
                                            {customers.map((customer) => (
                                                <MenuItem
                                                    value={customer.id}>{customer.name} {customer.surname}</MenuItem>
                                            ))}
                                        </Select>
                                    </FormControl>
                                    <h2 className={classes.formTitle}>Select date of start</h2>
                                    <form className={classes.container} noValidate>
                                        <TextField
                                            disabled={!isCustomerSelected}
                                            id="rentalStartDate"
                                            label={rentalStartMessage}
                                            type="date"
                                            error={rentalStartCorrectness}
                                            onChange={handleStartDateChange}
                                            className={classes.textField}
                                            InputLabelProps={{
                                                shrink: true,
                                            }}/>
                                    </form>
                                    <h2 className={classes.formTitle}>Select date of end</h2>
                                    <form className={classes.container} noValidate>
                                        <TextField
                                            disabled={!isStartDateCorrect}
                                            id="rentalEndDate"
                                            label={rentalEndMessage}
                                            type="date"
                                            error={rentalEndCorrectness}
                                            onChange={handleEndDateChange}
                                            className={classes.textField}
                                            InputLabelProps={{
                                                shrink: true,
                                            }}/>
                                    </form>
                                    <h2 className={classes.formTitle}>Select type of technical review</h2>
                                    <FormControl className={classes.formControl}>
                                        <InputLabel>Technical review type</InputLabel>
                                        <Select
                                            disabled={!isEndDateCorrect}
                                            className={classes.selectorColor}
                                            id="technical-review-type-selector"
                                            value={ti_ID}
                                            onChange={handleTechnicalInspectionSelection}>
                                            {specializations.map((specialization) => (
                                                <MenuItem value={specialization.specializationID}>{
                                                    <span>{specialization.inspectionType} inspection ({specialization.experience} experience)</span>}</MenuItem>
                                            ))}
                                        </Select>
                                    </FormControl>

                                    <h2 className={classes.formTitle}>Select mechanic</h2>
                                    <FormControl className={classes.formControl}>
                                        <InputLabel>Mechanic</InputLabel>
                                        <Select
                                            disabled={!isReviewTypeSelected}
                                            className={classes.selectorColor}
                                            id="mechanic-selector"
                                            value={mechanicID}
                                            onChange={handleMechanicSelection}>
                                            {mechanics.map((mechanic) => (
                                                <MenuItem value={mechanic.id}>{
                                                    <span>{mechanic.name} {mechanic.surname}</span>}</MenuItem>
                                            ))}
                                        </Select>
                                    </FormControl>

                                    <h2 className={classes.formTitle}>Additional comments</h2>
                                    <TextField className={classes.inputField}
                                               id="commentsInput"
                                               style={{margin: 8}}
                                               placeholder="Additional comments..."
                                               onBlur={handleCommentsChange}
                                               fullWidth
                                               margin="normal"
                                               InputLabelProps={{
                                                   shrink: true,
                                               }}
                                    />
                                    <Button disabled={isButtonDisabled} variant="contained" size="large"
                                            className={classes.bookButton}
                                            onClick={buttonClick}>
                                        Book a car
                                    </Button>
                                </div>
                            </Paper>
                        </GridCellRight>
                    </GridHalf>
                </div>
            ))) : (
                <b className={classes.notFoundLabel}>No car found with this ID</b>
            )}
            <Dialog
                fullScreen={fullScreen} onClose={handleClose} aria-labelledby="customized-dialog-title" open={open}>
                <DialogTitle id="customized-dialog-title" onClose={handleClose}>
                    Service history
                </DialogTitle>
                <CustomizedDialogs listOfServices={services}/>
            </Dialog>

            <Dialog
                fullScreen={fullScreen}
                open={openFinalDialog}
                onClose={handleFinalDialogClose}
                aria-labelledby="responsive-dialog-title">
                <DialogTitle> {rentalStatusHeader}</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        {rentalStatusComment}
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleFinalDialogClose} color="primary" autoFocus>
                        Okay
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
};

export default CarInfo