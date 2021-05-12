import React from "react";
import { useHistory } from "react-router-dom";
import Button from "@material-ui/core/Button";
import { resetLoginFormData, selectLogin } from "../../redux/loginSlice";
import { resetEmployeeRequests } from "../../redux/employeeRequestsSlice";
import { useAppSelector, useAppDispatch } from "../../redux/hooks";


const LogoutButton = () => {
  const history = useHistory();
  const login = useAppSelector(selectLogin);
  const dispatch = useAppDispatch();
  // This should return a user to the welcome page
  //  How should it effect the state?
  //  The currently logged in user should be logged out.
  //  Is there a currentl logged in user?
  const handleClick = (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
     //  Reset currently logged in user State
     dispatch(resetLoginFormData());
     dispatch(resetEmployeeRequests());
    history.push("/");
  };
  return (
    <div>
      <Button
        onClick={(e) => {
          handleClick(e);
        }}
      >
        Log Out
      </Button>
    </div>
  );
};

export default LogoutButton;
