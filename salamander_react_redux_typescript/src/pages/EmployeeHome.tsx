import React from "react";
import LogoutButton from "../components/LogoutButton/LogoutButton";
import CreateRequestForm from "../components/CreateRequestForm/CreateRequestForm";
import EmployeeReimbursementTable from "../components/ReimbursementTables/EmployeeReimbursementTable";
import PageGreeting from "../components/PageGreeting/PageGreeting";
import EmployeeInfoViewer from "../components/EmployeeInfoViewer/EmployeeInfoViewer";


const EmployeeHome = () => {
  return (
    <div>
      <PageGreeting />
      <LogoutButton />
      <CreateRequestForm />
      What does a reimbursement request require?
      <EmployeeReimbursementTable />
      <EmployeeInfoViewer />
    </div>
  );
};

export default EmployeeHome;
