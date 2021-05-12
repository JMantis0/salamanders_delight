import React from "react";
import Button from "@material-ui/core/Button";
import LogoutButton from "../components/LogoutButton/LogoutButton";
import CreateRequestForm from "../components/CreateRequestForm/CreateRequestForm";
import ReimbursementTable from "../components/ReimbursementTable/ReimbursementTable";

const EmployeeHome = () => {
  return (
    <div>
      <h1>This will be the Employee Home Page</h1>
      <LogoutButton />
      <CreateRequestForm />
        What does a reimbursement request require?
      <ReimbursementTable />
    </div>
  );
};

export default EmployeeHome;
