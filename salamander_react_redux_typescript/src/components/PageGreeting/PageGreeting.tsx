import react from "react";
import Grid from "@material-ui/core/Grid";
import { selectSalamander } from "../../redux/salamanderSlice";
import { useAppSelector } from "../../redux/hooks";
import LogoutButton from "../LogoutButton/LogoutButton";
import React from "react";
const PageGreeting = () => {
  const salamander = useAppSelector(selectSalamander);
  return (
    <React.Fragment>
      <Grid
        alignContent="space-between"
        alignItems="center"
        justify="center"
        container
      >
        <Grid item>
          <h1>Welcome, {salamander.currentUser.firstName}.</h1>
        </Grid>
      </Grid>
      <Grid
        container
        alignContent="space-between"
        alignItems="center"
        justify="center"
      >
        <LogoutButton />
      </Grid>
    </React.Fragment>
  );
};

export default PageGreeting;
