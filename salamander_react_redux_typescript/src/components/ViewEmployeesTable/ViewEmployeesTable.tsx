import React, { useMemo } from "react";
import { useAppSelector, useAppDispatch } from "../../redux/hooks";
import {
  setEmployeesState,
  selectSalamander,
} from "../../redux/salamanderSlice";
import axios from "axios";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import styles from "../../Salamander.module.css";

const ViewEmployeesTable = () => {
  const salamander = useAppSelector(selectSalamander);
  const dispatch = useAppDispatch();

  const getAllEmployeesAndSetEmployeesState = () => {
    axios
      .get("/api/get_all_employees")
      .then((response) => {
        console.log("response: ", response);
        const allEmployees = response.data;
        dispatch(setEmployeesState(allEmployees));
      })
      .catch((error) => {
        console.log("There was an error: ", error);
      });
  };

  useMemo(() => {
    getAllEmployeesAndSetEmployeesState();
  }, []);

  return (
    <div>
      <TableContainer component={Paper}>
        <Table className={styles.table} aria-label="reimbursement table">
          <TableHead>
            <TableRow>
              <TableCell>Employee ID</TableCell>
              <TableCell align="right">First Name</TableCell>
              <TableCell align="right">Last Name</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {salamander.employeesState.map((employee) => (
              <TableRow key={employee.id.timestamp}>
                <TableCell component="th" scope="row">
                  {employee.userID}
                </TableCell>
                <TableCell align="right">{employee.firstName}</TableCell>
                <TableCell align="right">{employee.lastName}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default ViewEmployeesTable;
