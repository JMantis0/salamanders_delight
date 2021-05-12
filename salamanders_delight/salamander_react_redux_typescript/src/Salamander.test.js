import { render, screen } from "@testing-library/react";
import { unmountComponentAtNode } from "react-dom";
import Salamander from "./Salamander";
import { act } from "react-dom/test-utils";

let container = null;

beforeEach(() => {
  container = document.createElement("div");
  document.body.appendChild(container);
});

afterEach(() => {
  unmountComponentAtNode(container);
  container.remove();
  container = null;
});

it("should render the component", () => {
  act(() => {
    render(<Salamander />, container);
  });
  
  expect(container.textContent).toBe("hey, Stranger!");
});

// test("renders learn react link", () => {
//   render(<Salamander />);
//   const linkElement = screen.getByText(/learn react/i);
//   expect(linkElement).toBeInTheDocument();
// });
