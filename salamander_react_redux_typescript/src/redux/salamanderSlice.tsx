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
  requestsState: Array<{
    amount: number | null;
    justification: string | null;
    requesterID: string;
    resolved: boolean;
    id: { timestamp: number; date: number };
  }>;
  loginState: { empID: string; password: string; loginType: String };
  createRequestState: { justification: string; amount: string | number | null };
  currentUser: {
    firstName: string;
    lastName: string;
    empID: string;
    password: string;
    id: { timestamp: number | null; date: number | null };
  };
}

const initialState: SalamanderState = {
  requestsState: [],
  loginState: { empID: "", password: "", loginType: "" },
  createRequestState: { justification: "", amount: "" },
  currentUser: {
    firstName: "",
    lastName: "",
    empID: "",
    password: "",
    id: { timestamp: null, date: null },
  },
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
        empID: "",
        password: "",
        id: { timestamp: null, date: null },
      };
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
} = salamanderSlice.actions;

export const selectSalamander = (state: RootState) => state.salamander;

export default salamanderSlice.reducer;
