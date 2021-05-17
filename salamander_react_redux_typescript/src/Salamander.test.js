import { render, screen } from "@testing-library/react";
import { unmountComponentAtNode } from "react-dom";
import Salamander from "./Salamander";
import { act } from "react-dom/test-utils";


test("renders learn react link", () => {
  render(<Salamander />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
