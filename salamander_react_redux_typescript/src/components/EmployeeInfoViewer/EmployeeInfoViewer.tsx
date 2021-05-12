import react from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { selectSalamander } from "../../redux/salamanderSlice";
import { useAppSelector } from "../../redux/hooks";
import styles from "../../Salamander.module.css";

const EmployeeInfoViewer = () => {
  const salamander = useAppSelector(selectSalamander);
  return <div>

    This is where employee information is displayed.<TableContainer component={Paper}>
        <Table className={styles.table} aria-label="reimbursement table">
          <TableHead>
            <TableRow>
              <TableCell>First Name</TableCell>
              <TableCell align="right">Last Name</TableCell>
              <TableCell align="right">Employee ID</TableCell>
              <TableCell align="right">Password</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {salamander.requestsState.map((request) => (
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
    
    </div>;
};

export default EmployeeInfoViewer;