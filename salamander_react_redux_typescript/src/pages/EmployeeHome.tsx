import React from "react";
import Button from "@material-ui/core/Button";
import LogoutButton from "../components/LogoutButton/LogoutButton";
import ReimbursementTable from "../components/ReimbursementTable/ReimbursementTable";

const EmployeeHome = () => {
  return (
    <div>
      <h1>This will be the Employee Home Page</h1>
      <Button>wtf is this for</Button>
      <LogoutButton />
      <div>Create Reimbursement Request Div</div>
      What does a reimbursement request require?
      <ReimbursementTable />
    </div>
  );
};

export default EmployeeHome;
