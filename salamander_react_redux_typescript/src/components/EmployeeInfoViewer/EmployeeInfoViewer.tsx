import react, { MouseEventHandler, useMemo } from "react";
import Table from "@material-ui/core/Table";
import Button from "@material-ui/core/Button";
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
      .get(`/api/current_user?userID=${salamander.loginState.userID}&loginType=${salamander.loginState.loginType}`)
      .then((response) => {
        console.log("response", response);
        const userProfile = response.data;
        dispatch(setCurrentUser(userProfile));
      })
      .catch((error) => {
        console.log("There was an error: ", error);
      });
  };

  useMemo(() => {
    getCurrentUserAndSetCurrentUserState();
  }, []);

  const updateHandler = (event: any) => {
    console.log(event);
    const newValue = prompt(`Submit a new ${event.target.name}`);
    if (newValue) {
      const data = {
        userID: salamander.currentUser.userID,
        field: event.target.name,
        value: newValue,
      };
      console.log("data", data);
      axios
        .put("/api/update_emp_field", data)
        .then((response) => {
          console.log("response", response);
          const setUserObject = {
            [event.target.name]: newValue,
          };
          dispatch(setCurrentUser(setUserObject));
        })
        .catch((err) => {
          console.log("Was an error: ", err);
        });
    }
  };

  return (
    <div>
      This is where employee information is displayed.
      <TableContainer component={Paper}>
        <Table className={styles.table} aria-label="reimbursement table">
          <TableHead>
            <TableRow>
              <TableCell>User ID</TableCell>
              <TableCell align="right">
                Last Name
                <button name="lastName" onClick={updateHandler}>
                  Update
                </button>
              </TableCell>
              <TableCell align="right">
                First Name
                <button name="firstName" onClick={updateHandler}>
                  Update
                </button>
              </TableCell>
              <TableCell align="right">
                Password
                <button name="password" onClick={updateHandler}>
                  Update
                </button>
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            <TableRow>
              <TableCell component="th" scope="row">
                {salamander.currentUser.userID}
              </TableCell>
              <TableCell align="right">
                {salamander.currentUser.lastName}
              </TableCell>
              <TableCell align="right">
                {salamander.currentUser.firstName}
              </TableCell>
              <TableCell align="right">
                {salamander.currentUser.password}
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default EmployeeInfoViewer;
