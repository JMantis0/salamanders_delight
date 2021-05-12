import React from "react";
import Button from "@material-ui/core/Button";
import LogoutButton from "../components/LogoutButton/LogoutButton";
import CreateRequestForm from "../components/CreateRequestForm/CreateRequestForm";
import ReimbursementTable from "../components/ReimbursementTable/ReimbursementTable";
import PageGreeting from "../components/PageGreeting/PageGreeting";
import EmployeeInfoViewer from "../components/EmployeeInfoViewer/EmployeeInfoViewer";


const EmployeeHome = () => {
  return (
    <div>
      <PageGreeting />
      <LogoutButton />
      <CreateRequestForm />
      What does a reimbursement request require?
      <ReimbursementTable />
      <EmployeeInfoViewer />
    </div>
  );
};

export default EmployeeHome;
