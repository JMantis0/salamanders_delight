import { createAsyncThunk, createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState, AppThunk } from "./store";

export interface EmployeeRequestsState {
  requests: Array<{amount: number, justification: string | null, requesterID: string, resolved: boolean, id: {timestamp: number, date: number}}>;
}

const initialState: EmployeeRequestsState = {
  requests: [],
};

export const employeeRequestsSlice = createSlice({
  name: "employeeRequests",
  initialState,
  reducers: {
    updateAllRequests: (state, action) => {
      state.requests = action.payload;
    },
    resetEmployeeRequests: (state) => {
      state.requests = [];
    }
  },
});

export const { updateAllRequests, resetEmployeeRequests } = employeeRequestsSlice.actions;

export const selectEmployeeRequests = (state: RootState) => state.employeeRequests;

export default employeeRequestsSlice.reducer;
