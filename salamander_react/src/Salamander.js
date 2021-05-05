import Welcome from "./pages/Welcome";
import Login from "./pages//Login";
import EmployeeHome from "./pages/EmployeeHome";
import ManagerHome from "./pages/ManagerHome";

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
        <Route exact path="/employeehome">
          <EmployeeHome />
        </Route>
        <Route exact path="/managerhome">
          <ManagerHome />
        </Route>
      </Switch>
    </Router>
  );
}

export default Salamander;
