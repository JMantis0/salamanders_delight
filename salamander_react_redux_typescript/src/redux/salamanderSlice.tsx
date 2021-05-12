import { createAsyncThunk, createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState, AppThunk } from "./store";

export interface SalamanderState {
  requestsState: Array<{
    amount: number;
    justification: string | null;
    requesterID: string;
    resolved: boolean;
    id: { timestamp: number; date: number };
  }>;
  loginState: { empID: String; password: String };
  createRequestState: { justification: String; amount: String };
}

const initialState: SalamanderState = {
  requestsState: [],
  loginState: { empID: "", password: "" },
  createRequestState: { justification: "", amount: "0" },
};

export const salamanderSlice = createSlice({
  name: "salamander",
  initialState,
  reducers: {
    updateAllRequests: (state, action) => {
      state.requestsState = action.payload;
    },
    resetEmployeeRequests: (state) => {
      state.requestsState = [];
    },
    setRequestFormState: (state, action) => {
      console.log("action", action);
      const fieldName = action.payload.fieldName;
      const value = action.payload.value;
      console.log(`updating ${fieldName} to ${value}`);
      state.createRequestState = {
        ...state.createRequestState,
        [fieldName]: value,
      };
    },
    setLoginFormState: (state, action) => {
      console.log("action", action);
      const fieldName = action.payload.fieldName;
      const value = action.payload.value;
      console.log(`updating ${fieldName} to ${value}`);
      state.loginState = { ...state.loginState, [fieldName]: value };
    },
    resetLoginFormData: (state) => {
      state.loginState.empID = "";
      state.loginState.password = "";
    },
  },
});

export const {
  updateAllRequests,
  resetEmployeeRequests,
  setRequestFormState,
  setLoginFormState,
  resetLoginFormData,
} = salamanderSlice.actions;

export const selectSalamander = (state: RootState) => state.salamander;

export default salamanderSlice.reducer;
