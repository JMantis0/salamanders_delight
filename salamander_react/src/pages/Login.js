import React, { useState } from "react";
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
  const [formData, setFormData] = useState({ empID: "", password: "" });
  const history = useHistory();

  const updateFormData = (e) => {
    const fieldName = e.target.name;
    const value = e.target.value;
    console.log(`Updated ${fieldName} with value ${value}`);
    setFormData({ ...formData, [fieldName]: value });
  };

  const submitLogin = () => {
    console.log("Calling Login Servlet with formData: ", formData);
    axios
      .post("/api/passwordcheck", formData, {
        headers: { "Content-Type": "application/json" },
      })
      .then((response) => {
        const nextURL = response.data
        console.log(response);
        console.log(nextURL);
        history.push(nextURL);
      })
      .catch((err) => {
        const nextURL= err.response.data;
        console.log(err.response);
        console.log(nextURL);
        console.log('"/nosuchuser" === nextURL"', "/nosuchuser" === nextURL);
        console.log(typeof nextURL);
        console.log(nextURL);
        history.push(nextURL)
      }); 
  };

  return (
    <div>
      This will be the login page
      <form className={classes.root} noValidate autoComplete="off">
        <TextField
          id="outlined-basic"
          label="Employee ID"
          variant="outlined"
          name="empID"
          onChange={updateFormData}
        />
        <TextField
          type="password"
          label="Password"
          variant="outlined"
          name="password"
          onChange={updateFormData}
        />
        <Button color="primary" variant="contained" onClick={submitLogin}>
          Submit
        </Button>
      </form>
    </div>
  );
};

export default Login;
