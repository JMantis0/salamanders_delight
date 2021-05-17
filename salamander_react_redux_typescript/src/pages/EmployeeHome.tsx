import React from "react";
import PageGreeting from "../components/PageGreeting/PageGreeting";
import EmployeeTabs from "../components/EmployeeTabs/EmployeeTabs";

const EmployeeHome = () => {
  return (
    <React.Fragment>
      <PageGreeting />
      <EmployeeTabs />
    </React.Fragment>
  );
};

export default EmployeeHome;
