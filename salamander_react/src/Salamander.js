import Welcome from "./pages/Welcome";
import Login from "./pages//Login";
import EmployeeHome from "./pages/EmployeeHome";
import ManagerHome from "./pages/ManagerHome";
import NoSuchUser from "./pages/NoSuchUser";
import InvalidPassword from "./pages/InvalidPassword";

import "./Salamander.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Header from "./components/Header";

function Salamander() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route exact path="/">
          <Welcome />
        </Route>
        <Route exact path="/login">
          <Login />
        </Route>
        <Route exact path="/employee_home">
          <EmployeeHome />
        </Route>
        <Route exact path="/manager_home">
          <ManagerHome />
        </Route>
        <Route exact path="/invalid_password">
          <InvalidPassword />
        </Route>
        <Route exact path="/no_such_user">
          <NoSuchUser />
        </Route>
      </Switch>
    </Router>
  );
}

export default Salamander;
