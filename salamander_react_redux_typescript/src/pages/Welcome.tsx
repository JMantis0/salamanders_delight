import React from "react";
import Button from "@material-ui/core/Button";
import { useHistory } from "react-router-dom";

const Welcome = () => {
  const history = useHistory();
  return (
    <div>
      <Button color="primary" variant="contained" onClick={(e) => {
        history.push("/login");
      }}>
        Enter
      </Button>
    </div>
  );
};

export default Welcome;
