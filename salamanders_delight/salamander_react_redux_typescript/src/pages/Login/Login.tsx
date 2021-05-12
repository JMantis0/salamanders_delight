import React from "react";
import { useAppSelector, useAppDispatch } from "../../redux/hooks";
import {resetLoginFormData, setLoginFormState, selectSalamander } from "../../redux/salamanderSlice";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import axios from "axios";
import { useHistory } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  root: {
    "& > *": {
      margin: theme.spacing(1),
      width: "25ch",
    },
  },
}));

const Login = () => {
  const classes = useStyles();
  const salamander = useAppSelector(selectSalamander);
  const dispatch = useAppDispatch();
  const history = useHistory();

  const formChangeHandler = (event: { target: { name: any; value: any; }; }) => {
    const fieldName = event.target.name;
    const value = event.target.value;
    dispatch(setLoginFormState({fieldName, value}));
  };

  const submitLogin = () => {
    console.log("login", salamander.loginState);
    console.log("Calling Login Servlet with login object: ", salamander.loginState);
    axios
      .post("/api/attempt_login", salamander.loginState, {
        headers: { "Content-Type": "application/json" },
      })
      .then((response) => {
        const nextURL = response.data;
        // Should we set some kind of state for the currently logged in user?
        console.log(salamander.loginState);
        history.push(nextURL);
      })
      .catch((err) => {
        const nextURL = err.response.data;
        dispatch(resetLoginFormData());
        history.push(nextURL);
      });
  };

  return (
    <div>
      This will be the login page
      <form className={classes.root} noValidate autoComplete="off">
        <TextField
          autoComplete="off"
          type="text"
          label="Employee ID"
          variant="outlined"
          name="empID"
          onChange={formChangeHandler}
        />
        <TextField
          autoComplete="off"
          type="password"
          label="Password"
          variant="outlined"
          name="password"
          onChange={formChangeHandler}
        />
        <Button color="primary" variant="contained" onClick={submitLogin}>
          Submit
        </Button>
      </form>
    </div>
  );
};

export default Login;
