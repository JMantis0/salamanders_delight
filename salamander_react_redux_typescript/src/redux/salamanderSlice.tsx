import {
  // createAsyncThunk,
  createSlice,
  //  PayloadAction
} from "@reduxjs/toolkit";
import {
  RootState,
  //  AppThunk
} from "./store";

export interface SalamanderState {
  employeeRequestsState: Array<{
    amount: number | null;
    justification: string | null;
    requesterID: string;
    resolved: boolean;
    id: { timestamp: number; date: number };
  }>;
  loginState: { userID: string; password: string; loginType: String };
  createRequestState: { justification: string; amount: string | number | null };
  currentUser: {
    firstName: string;
    lastName: string;
    userID: string;
    password: string;
    id: { timestamp: number | null; date: number | null };
  };
  //Add a section of state for the Manager Reimbursement Viewer.
  // State should be an array of Reimbursement Objects
  allReimbursementsState: Array<{
    amount: number;
    resolved: boolean;
    resolvedBy: string;
    requesterID: string;
    justification: string;
    id: { timestamp: number | null; date: number | null };
  }>;
}

const initialState: SalamanderState = {
  employeeRequestsState: [],
  loginState: { userID: "", password: "", loginType: "" },
  createRequestState: { justification: "", amount: "" },
  currentUser: {
    firstName: "",
    lastName: "",
    userID: "",
    password: "",
    id: { timestamp: null, date: null },
  },
  allReimbursementsState: [],
};

export const salamanderSlice = createSlice({
  name: "salamander",
  initialState,
  reducers: {
    updateAllRequests: (state, action) => {
      state.employeeRequestsState = action.payload;
    },
    resetEmployeeRequests: (state) => {
      state.employeeRequestsState = [];
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
      state.loginState.userID = "";
      state.loginState.password = "";
      state.loginState.loginType = "";
    },
    setCurrentUser: (state, action) => {
      console.log("action", action);
      console.log("action.payload", action.payload);
      state.currentUser = { ...state.currentUser, ...action.payload };
    },
    resetCurrentUser: (state) => {
      state.currentUser = {
        firstName: "",
        lastName: "",
        userID: "",
        password: "",
        id: { timestamp: null, date: null },
      };
    },
    setAllReimbursementsState: (state, action) => {
      state.allReimbursementsState = {
        ...state.allReimbursementsState,
        ...action.payload,
      };
    },
    resetAllReimbursementsState: (state) => {
      state.allReimbursementsState = [];
    },
  },
});

export const {
  updateAllRequests,
  resetEmployeeRequests,
  setRequestFormState,
  setLoginFormState,
  resetLoginFormData,
  setCurrentUser,
  resetCurrentUser,
  setAllReimbursementsState,
  resetAllReimbursementsState,
} = salamanderSlice.actions;

export const selectSalamander = (state: RootState) => state.salamander;

export default salamanderSlice.reducer;
