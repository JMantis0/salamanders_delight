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
    resolvedBy: string;
    status: string;
    id: { timestamp: number; date: number };
    customId: string;
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
  employeesState: Array<{
    firstName: string;
    lastName: string;
    userID: string;
    password: string;
    id: { timestamp: number | null; date: number | null };
  }>;
  allReimbursementsState: Array<{
    amount: number;
    status: string;
    resolvedBy: string;
    requesterID: string;
    justification: string;
    id: { timestamp: number | null; date: number | null };
    customId: string;
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
  employeesState: [],
  allReimbursementsState: [],
};

export const salamanderSlice = createSlice({
  name: "salamander",
  initialState,
  reducers: {
    setEmployeeRequestsState: (state, action) => {
      state.employeeRequestsState = action.payload;
    },
    resetEmployeeRequestsState: (state) => {
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
      state.allReimbursementsState = [...action.payload];
    },
    resetAllReimbursementsState: (state) => {
      state.allReimbursementsState = [];
    },
    setEmployeesState: (state, action) => {
      state.employeesState = [...action.payload];
    },
    resetState: (state) => {
      state = initialState;
    },
  },
});

export const {
  setEmployeeRequestsState,
  resetEmployeeRequestsState,
  setRequestFormState,
  setLoginFormState,
  resetLoginFormData,
  setCurrentUser,
  resetCurrentUser,
  setAllReimbursementsState,
  resetAllReimbursementsState,
  resetState,
  setEmployeesState,
} = salamanderSlice.actions;

export const selectSalamander = (state: RootState) => state.salamander;

export default salamanderSlice.reducer;
