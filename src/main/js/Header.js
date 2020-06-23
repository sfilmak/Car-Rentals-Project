import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';

const useStyles = makeStyles(() => ({
    root: {
        flexGrow: 1,
    },
    title: {
        flexGrow: 1,
        color: "white"
    },
    toolbar_style: {
        padding: 0,
        background: "#FF775A",
        textAlign: "center",
    },
    toolbar: {
        padding: 0,
    },
}));

export default function Header() {
    const classes = useStyles();
    return (
        <div className={classes.root}>
            <AppBar position="static" className={classes.toolbar_style}>
                <Toolbar className={classes.toolbar}>
                    <Typography variant="h4" className={classes.title}>
                        Cars rental
                    </Typography>
                </Toolbar>
            </AppBar>
            <Box m={1}/>
        </div>
    );
}