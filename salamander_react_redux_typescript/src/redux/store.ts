import { configureStore, ThunkAction, Action } from "@reduxjs/toolkit";
import loginReducer from "./loginSlice";
import employeeRequestsReducer from "./employeeRequestsSlice";

export const store = configureStore({
  reducer: {
    login: loginReducer,
    employeeRequests :employeeRequestsReducer
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
