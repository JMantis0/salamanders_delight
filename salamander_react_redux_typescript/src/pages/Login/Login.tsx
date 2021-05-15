import React from "react";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormControl from "@material-ui/core/FormControl";
import FormLabel from "@material-ui/core/FormLabel";
import { useAppSelector, useAppDispatch } from "../../redux/hooks";
import {
  resetLoginFormData,
  setLoginFormState,
  selectSalamander,
} from "../../redux/salamanderSlice";
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

  const formChangeHandler = (event: any) => {
    console.log(event)
    const fieldName = event.target.name;
    const value = event.target.value;
    dispatch(setLoginFormState({ fieldName, value }));
  };

  const submitLogin = () => {
    console.log("login", salamander.loginState);
    console.log(
      "Calling Login Servlet with login object: ",
      salamander.loginState
    );
    axios
      .post("/api/attempt_login", salamander.loginState, {
        headers: { "Content-Type": "application/json" },
      })
      .then((response) => {
        const nextURL = response.data;
        history.push(nextURL);
      })
      .catch((err) => {
        const nextURL = err.response.data;
        dispatch(resetLoginFormData());
        history.push(nextURL);
      });
  };

  return (
    <FormControl className={classes.root} component="fieldset">
      <FormLabel component="legend">Login</FormLabel>
      <TextField
        autoComplete="off"
        type="text"
        label="User ID"
        variant="outlined"
        name="userID"
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
      <RadioGroup
        aria-label="gender"
        name="loginType"
        row
        value={salamander.loginState.loginType}
        onChange={formChangeHandler}
      >
        <FormControlLabel
          value="employee"
          control={<Radio />}
          label="Employee"
        />
        <FormControlLabel value="manager" control={<Radio />} label="Manager" />
      </RadioGroup>
      <Button color="primary" variant="contained" onClick={submitLogin}>
        Submit
      </Button>
    </FormControl>
  );
};

export default Login;
