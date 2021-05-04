import React, { useState } from "react";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import axios from "axios";

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

  const updateFormData = (e) => {
    const fieldName = e.target.name;
    const value = e.target.value;
    console.log(`Updated ${fieldName} with value ${value}`);
    setFormData({ ...formData, [fieldName]: value });
  };

  const submitLogin = () => {
    console.log("Calling Login Servlet with formData: ", formData);
    axios
      .get(`/api/login?empID=${formData.empID}&password=${formData.password}`)
      .then((response) => {
        console.log("response: ", response);
      })
      .catch((err) => {
        console.log("There was an error calling Login Servlet: ", err);
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
        <Button color="primary" variant="contained" onClick={submitLogin}>Submit</Button>
      </form>
    </div>
  );
};

export default Login;
