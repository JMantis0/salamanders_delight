import React, { useMemo } from "react";
import Button from "@material-ui/core/Button";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import axios from "axios";
import {
  setEmployeeRequestsState,
  selectSalamander,
} from "../../redux/salamanderSlice";
import { useAppSelector, useAppDispatch } from "../../redux/hooks";
import styles from "../../Salamander.module.css";

const EmployeeReimbursementTable = () => {
  const salamander = useAppSelector(selectSalamander);
  const dispatch = useAppDispatch();

  const getAllReimbursementRequestsForCurrentUser = () => {
    axios
      .get(`/api/get_requests?userID=${salamander.loginState.userID}`)
      .then((response) => {
        console.log("response.data", response.data);
        dispatch(setEmployeeRequestsState(response.data));
      })
      .catch((err) => {
        console.log("there was an error: ", err.response);
      });
  };

  useMemo(() => {
    getAllReimbursementRequestsForCurrentUser();
  }, []);

  return (
    <React.Fragment>
      <TableContainer component={Paper}>
        <Table className={styles.table} aria-label="reimbursement table">
          <TableHead>
            <TableRow>
              <TableCell>Justification</TableCell>
              <TableCell align="right">Amount</TableCell>
              <TableCell align="right">Status</TableCell>
              <TableCell align="right">Resolved By</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {salamander.employeeRequestsState.map((request) => (
              <TableRow key={request.id.timestamp}>
                <TableCell component="th" scope="row">
                  {request.justification}
                </TableCell>
                <TableCell align="right">{request.amount}</TableCell>
                <TableCell align="right">{request.status}</TableCell>
                <TableCell align="right">
                  {request.resolvedBy ? request.resolvedBy : "Unresolved"}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </React.Fragment>
  );
};

export default EmployeeReimbursementTable;
