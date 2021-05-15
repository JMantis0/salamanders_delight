import React from "react";
import PageGreeting from "../components/PageGreeting/PageGreeting";
import LogoutButton from "../components/LogoutButton/LogoutButton";
import EmployeeInfoViewer from "../components/EmployeeInfoViewer/EmployeeInfoViewer";
import ManagerReimbursementViewer from "../components/ReimbursementTables/ManagerReimbursementViewer";

const ManagerHome = () => {
  return <div>
    <PageGreeting />
    <EmployeeInfoViewer />
    <ManagerReimbursementViewer />
    <LogoutButton />
    This will be the Manager Home page</div>;
};

export default ManagerHome;
