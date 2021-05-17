import React from "react";
import PageGreeting from "../components/PageGreeting/PageGreeting";
import LogoutButton from "../components/LogoutButton/LogoutButton";
import ManagerTabs from "../components/ManagerTabs/ManagerTabs";

const ManagerHome = () => {
  return (
    <React.Fragment>
      <PageGreeting />
      <ManagerTabs />
    </React.Fragment>
  );
};

export default ManagerHome;
