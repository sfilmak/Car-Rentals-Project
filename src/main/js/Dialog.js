import React from 'react';
import {makeStyles, withStyles} from '@material-ui/core/styles';
import MuiDialogTitle from '@material-ui/core/DialogTitle';
import MuiDialogContent from '@material-ui/core/DialogContent';
import IconButton from '@material-ui/core/IconButton';
import CloseIcon from '@material-ui/icons/Close';
import Typography from '@material-ui/core/Typography';
import ListItem from "@material-ui/core/ListItem";
import ListItemAvatar from "@material-ui/core/ListItemAvatar";
import Avatar from "@material-ui/core/Avatar";
import ListItemText from "@material-ui/core/ListItemText";
import HistoryIcon from '@material-ui/icons/History';
import List from "@material-ui/core/List";

const styles = (theme) => ({
    root: {
        margin: 0,
        padding: theme.spacing(2),
    },
    closeButton: {
        position: 'absolute',
        right: theme.spacing(1),
        top: theme.spacing(1),
        color: theme.palette.grey[500],
    },
});

const useStyles = makeStyles((theme) => ({
    carInfoList: {
        width: '100%',
    },
    list_avatar: {
        backgroundColor: '#FF775A',
    },
}));

export const DialogTitle = withStyles(styles)((props) => {
    const { children, classes, onClose, ...other } = props;
    return (
        <MuiDialogTitle disableTypography className={classes.root} {...other}>
            <Typography variant="h6">{children}</Typography>
            {onClose ? (
                <IconButton aria-label="close" className={classes.closeButton} onClick={onClose}>
                    <CloseIcon />
                </IconButton>
            ) : null}
        </MuiDialogTitle>
    );
});

const DialogContent = withStyles((theme) => ({
    root: {
        padding: theme.spacing(2),
    },
}))(MuiDialogContent);

export default function CustomizedDialogs() {
    const classes = useStyles();
    return (
        <div>
                <DialogContent dividers>
                    <List className={classes.carInfoList}>
                        <ListItem>
                            <ListItemAvatar>
                                <Avatar className={classes.list_avatar}>
                                    <HistoryIcon/>
                                </Avatar>
                            </ListItemAvatar>
                            <ListItemText primary="Oil change" secondary="20-05-2020"/>
                        </ListItem>
                        <ListItem>
                            <ListItemAvatar>
                                <Avatar className={classes.list_avatar}>
                                    <HistoryIcon/>
                                </Avatar>
                            </ListItemAvatar>
                            <ListItemText primary="General inspection" secondary="05-05-2020"/>
                        </ListItem>
                    </List>
                </DialogContent>
        </div>
    );
}