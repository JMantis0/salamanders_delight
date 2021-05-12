import React from "react";
import Button from "@material-ui/core/Button";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { makeStyles } from "@material-ui/core/styles";
import axios from "axios";
import { selectLogin } from "../../redux/loginSlice";
import { updateAllRequests, selectEmployeeRequests } from "../../redux/employeeRequestsSlice";
import { useAppSelector, useAppDispatch } from "../../redux/hooks";
import styles from "../../Salamander.module.css";


// const createReimbursementData = (
//   requesterID: string,
//   justification: string,
//   amount: number,
//   status: boolean,
//   date: { timestamp: number; date: number }
// ) => {
//   return {requesterID, amount, justification, status, date};
// };

// const rows = [createReimbursementData("Jesse", "Lodging", 100.0, false, {
//   timestamp: 1,
//   date: 1,
// })];


const ReimbursementTable = () => {
  
  const login = useAppSelector(selectLogin);
  const employeeRequests = useAppSelector(selectEmployeeRequests);
  const dispatch = useAppDispatch();

  const getAllReimbursementRequestsForCurrentUser = () => {
    axios
      .get(`/api/get_requests?empID=${login.empID}`)
      .then((response) => {
        console.log("response.data", response.data);
        dispatch(updateAllRequests(response.data));
      })
      .catch((err) => {
        console.log("there was an error: ", err.response);
      });
  };

  return (
    <React.Fragment>
      <Button
        onClick={() => {
          getAllReimbursementRequestsForCurrentUser();
        }}
      >
        Get Reimbursement Request Data
      </Button>
      <Button
        onClick={() => {
          console.log(employeeRequests);
        }}
      >
        console.log(employeeRequests)
      </Button>
      <TableContainer component={Paper}>
        <Table className={styles.table} aria-label="reimbursement table">
          <TableHead>
            <TableRow>
              <TableCell>Justification</TableCell>
              <TableCell align="right">Amount</TableCell>
              <TableCell align="right">Status</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {employeeRequests.requests.map((request) => (
              <TableRow key={request.id.timestamp}>
                <TableCell component="th" scope="row">
                  {request.justification}
                </TableCell>
                <TableCell align="right">{request.amount}</TableCell>
                <TableCell align="right">
                  {request.resolved ? "Resolved" : "Pending"}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </React.Fragment>
  );
};

export default ReimbursementTable;
