import react, { useMemo } from "react";
import axios from "axios";

const ManagerReimbursementViewer = () => {
  //Gonna need to call the api
  const getAllReimbursementRequestsAndSetAllReimbursementsState = () => {
    axios
      .get(`/api/get_all_reqs`)
      .then((response) => {
        console.log("response", response);
      })
      .catch((error) => {
        console.log("There was an error: ", error);
      });
  };
  useMemo(() => {
    console.log("Usememo")
    getAllReimbursementRequestsAndSetAllReimbursementsState();
  }, []);
  return <div></div>;
};

export default ManagerReimbursementViewer;
