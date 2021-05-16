import React, { useMemo } from "react";
import axios from "axios";
import Button from "@material-ui/core/Button";
import Table from "@material-ui/core/Table";

import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import styles from "../../Salamander.module.css";
import { useAppDispatch, useAppSelector } from "../../redux/hooks";
import {
  selectSalamander,
  setAllReimbursementsState,
} from "../../redux/salamanderSlice";

const ManagerReimbursementViewer = () => {
  const salamander = useAppSelector(selectSalamander);
  const dispatch = useAppDispatch();
  const getAllReimbursementRequestsAndSetAllReimbursementsState = () => {
    axios
      .get(`/api/get_all_reqs`)
      .then((response) => {
        console.log("response", response);
        const allReimbursements = response.data;
        dispatch(setAllReimbursementsState(allReimbursements));
      })
      .catch((error) => {
        console.log("There was an error: ", error);
      });
  };
  useMemo(() => {
    getAllReimbursementRequestsAndSetAllReimbursementsState();
  }, []);

  const resolutionHandler = (event: any, customId: string) => {
    console.log("event", event);
    const data = {
      resolution: event.target.parentNode.name,
      objectId: customId,
      resolver: `${salamander.currentUser.firstName} ${salamander.currentUser.lastName} (${salamander.currentUser.userID})`,
    };
    axios
      .put("/api/resolve_request", data)
      .then((response) => {
        console.log("response", response);
        getAllReimbursementRequestsAndSetAllReimbursementsState();
      })
      .catch((err) => {
        console.log("There was an error: ", err);
      });
  };

  return (
    <div>
      <React.Fragment>
        <TableContainer component={Paper}>
          <Table className={styles.table} aria-label="reimbursement table">
            <TableHead>
              <TableRow>
                <TableCell>Requested By</TableCell>
                <TableCell align="right">Justification</TableCell>
                <TableCell align="right">Amount</TableCell>
                <TableCell align="right">Status</TableCell>
                <TableCell align="right">Resolved By</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {salamander.allReimbursementsState.map((request) => (
                <TableRow key={request.id.timestamp}>
                  <TableCell component="th" scope="row">
                    {request.requesterID}
                  </TableCell>
                  <TableCell align="right">{request.justification}</TableCell>
                  <TableCell align="right">{request.amount}</TableCell>
                  <TableCell align="right">
                    {request.status === "Pending" ? (
                      <React.Fragment>
                        <Button
                          name="Approved"
                          onClick={(event) => {
                            resolutionHandler(event, request.customId);
                          }}
                        >
                          Approve
                        </Button>
                        <Button
                          name="Denied"
                          onClick={(event) => {
                            resolutionHandler(event, request.customId);
                          }}
                        >
                          {" "}
                          Deny
                        </Button>
                      </React.Fragment>
                    ) : (
                      request.status
                    )}
                  </TableCell>
                  <TableCell align="right">
                    {request.resolvedBy ? request.resolvedBy : "Unresolved"}
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </React.Fragment>
    </div>
  );
};

export default ManagerReimbursementViewer;
