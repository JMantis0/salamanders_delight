import react from "react";
import { selectSalamander } from "../../redux/salamanderSlice";
import { useAppSelector } from "../../redux/hooks";

const PageGreeting = () => {
  const salamander = useAppSelector(selectSalamander);
  return <h1>Welcome, {salamander.loginState.empID}.</h1>;
};

export default PageGreeting;
