import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import {
  setRequestFormState,
  selectSalamander,
  setEmployeeRequestsState,
} from "../../redux/salamanderSlice";
import { useAppSelector, useAppDispatch } from "../../redux/hooks";
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

const CreateRequestForm = () => {
  const classes = useStyles();
  const salamander = useAppSelector(selectSalamander);
  const dispatch = useAppDispatch();

  const requestFormChangeHandler = (event: {
    target: { name: any; value: any };
  }) => {
    const fieldName = event.target.name;
    const value = event.target.value;
    console.log(`the value of ${fieldName} is now ${value}`);
    dispatch(setRequestFormState({ fieldName, value }));
  };

  const submitNewRequest = () => {
    console.log("salamander.loginState", salamander.loginState);
    console.log(
      "calling /create_new_request with data: ",
      salamander.createRequestState
    );
    const postData = {
      requesterID: salamander.loginState.userID,
      justification: salamander.createRequestState.justification,
      amount: salamander.createRequestState.amount,
      resolvedBy: null,
      status: "Pending",
    };
    axios
      .post("/api/create_new_request", postData)
      .then((response) => {
        console.log("response.data", response.data);
        dispatch(
          setRequestFormState({ fieldName: "justification", value: "" })
        );
        dispatch(setRequestFormState({ fieldName: "amount", value: "" }));
      })
      .catch((err) => {
        console.log("There was an error", err);
      });
  };

  return (
    <div>
      <form className={classes.root}>
        <TextField
          autoComplete="off"
          type="text"
          label="Justification"
          variant="outlined"
          name="justification"
          value={salamander.createRequestState.justification}
          onChange={requestFormChangeHandler}
        />
        <TextField
          autoComplete="off"
          type="number"
          label="Amount"
          variant="outlined"
          name="amount"
          placeholder="in USD"
          value={salamander.createRequestState.amount}
          onChange={requestFormChangeHandler}
        />
        <Button onClick={submitNewRequest}>Submit</Button>
      </form>
    </div>
  );
};

export default CreateRequestForm;
