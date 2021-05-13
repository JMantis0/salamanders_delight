import react, { useMemo } from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import axios from "axios";
import { selectSalamander, setCurrentUser } from "../../redux/salamanderSlice";
import { useAppDispatch, useAppSelector } from "../../redux/hooks";
import styles from "../../Salamander.module.css";

const EmployeeInfoViewer = () => {
  const salamander = useAppSelector(selectSalamander);
  const dispatch = useAppDispatch();

  const getCurrentUserAndSetCurrentUserState = () => {
    axios
    .get(`/api/current_user?empID=${salamander.loginState.empID}`)
    .then((response) => {
      console.log("response", response);
      dispatch(setCurrentUser);
    })
    .catch((error) => {
      console.log("There was an error: ", error);
    });
  }

  useMemo(() => {
   getCurrentUserAndSetCurrentUserState();
  }, []);

  return (
    <div>
      This is where employee information is displayed.
      <TableContainer component={Paper}>
        <Table className={styles.table} aria-label="reimbursement table">
          <TableHead>
            <TableRow>
              <TableCell>Employee ID</TableCell>
              <TableCell align="right">Last Name</TableCell>
              <TableCell align="right">First Name</TableCell>
              <TableCell align="right">Password</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {Object.keys(salamander.currentUser).map((user, index) => (
              <TableRow key={index}>
                <TableCell component="th" scope="row">
                  {user.lastName}
                </TableCell>
                <TableCell align="right">{user.firstName}</TableCell>
                <TableCell align="right">
                  {user.password}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default EmployeeInfoViewer;
