import React from "react";
import PageGreeting from "../components/PageGreeting/PageGreeting";
import ManagerTabs from "../components/ManagerTabs/ManagerTabs";

const ManagerHome = () => {
  return (
    <React.Fragment>
      {/* <h1>MANAGER HOME</h1> */}
      <PageGreeting />
      <ManagerTabs />
    </React.Fragment>
  );
};

export default ManagerHome;
