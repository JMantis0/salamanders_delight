import React from "react";
import EmployeeInfoViewer from "../EmployeeInfoViewer/EmployeeInfoViewer";
import ManagerReimbursementViewer from "../ReimbursementTables/ManagerReimbursementViewer";
import ViewEmployeesTable from "../ViewEmployeesTable/ViewEmployeesTable";
import PropTypes from "prop-types";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import Grid from "@material-ui/core/Grid";

const ManagerTabs = () => {
  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  const handleTabChange = (event: any, newValue: any) => {
    setValue(newValue);
  };

  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Tabs
          value={value}
          onChange={handleTabChange}
          aria-label="simple tabs example"
        >
              <Tab label="Your Profile" {...a11yProps(0)} />
              <Tab label="All Employees" {...a11yProps(1)} />
              <Tab label="All Requests" {...a11yProps(2)} />
        </Tabs>
      </AppBar>
      <TabPanel value={value} index={0}>
        <EmployeeInfoViewer />
      </TabPanel>
      <TabPanel value={value} index={1}>
        <ViewEmployeesTable />
      </TabPanel>
      <TabPanel value={value} index={2}>
        <ManagerReimbursementViewer />
      </TabPanel>
    </div>
  );
};

function TabPanel(props: any) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box p={3}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index: any) {
  return {
    id: `simple-tab-${index}`,
    "aria-controls": `simple-tabpanel-${index}`,
  };
}

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
}));

export default ManagerTabs;
