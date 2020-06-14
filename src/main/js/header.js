import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles(() => ({
    root: {
        flexGrow: 1,
    },
    title: {
        flexGrow: 1,
        color: "red"
    },
    toolbar_style: {
        background: "white",
        textAlign: "center",
    },
}));

export default function Header() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <AppBar position="static" className={classes.toolbar_style}>
                <Toolbar>
                    <Typography variant="h6" className={classes.title}>
                        Cars rental
                    </Typography>
                </Toolbar>
            </AppBar>
        </div>
    );
}