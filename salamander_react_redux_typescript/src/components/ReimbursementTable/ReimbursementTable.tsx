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
import { useAppSelector } from "../../redux/hooks";

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

const createReimbursementData = (
  justification: string,
  amount: number,
  status: boolean
) => {
  return { justification, amount, status };
};

const rows = [createReimbursementData("Lodging", 100.0, false)];
console.log(rows);

const ReimbursementTable = () => {
  const classes = useStyles();
  const login = useAppSelector(selectLogin);

  const getAllReimbursementRequestsForCurrentUser = () => {
    axios
      .get(`/api/get_requests?empID=${login.empID}`)
      .then((response) => {
        console.log("response.data",response.data);
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
      <TableContainer component={Paper}>
        <Table className={classes.table} aria-label="reimbursement table">
          <TableHead>
            <TableRow>
              <TableCell>Justification</TableCell>
              <TableCell align="right">Amount</TableCell>
              <TableCell align="right">Status</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row) => (
              <TableRow
              key={row.justification}
              >
                <TableCell component="th" scope="row">
                  {row.justification}
                </TableCell>
                <TableCell align="right">{row.amount}</TableCell>
                <TableCell align="right">
                  {row.status ? "Resolved" : "Pending"}
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
