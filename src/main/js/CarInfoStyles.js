import {makeStyles} from "@material-ui/core/styles";

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

export default useStyles;