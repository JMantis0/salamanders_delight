import React from "react";
import { useHistory } from "react-router-dom";
import Button from "@material-ui/core/Button";
import{ resetState, resetLoginFormData, resetEmployeeRequestsState, resetCurrentUser } from "../../redux/salamanderSlice";
import { useAppDispatch } from "../../redux/hooks";

const LogoutButton = () => {
  const history = useHistory();
  const dispatch = useAppDispatch();
  const handleClick = (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
     //  Reset currently logged in user State
     dispatch(resetState());
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
