import { createAsyncThunk, createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState, AppThunk } from "./store";

export interface LoginState {
  empID: String;
  password: String;
}

const initialState: LoginState = {
  empID: "",
  password: "",
};

export const loginSlice = createSlice({
  name: "login",
  initialState,
  reducers: {
    handleLoginFormChange: (state, action) => {
      console.log("action", action);
      const fieldName = action.payload.fieldName;
      const value = action.payload.value;
      switch (fieldName) {
        case "empID":
          console.log(`updating ${fieldName} to ${value}`);
          state.empID = value;
          break;
        case "password":
          console.log(`updating ${fieldName} to ${value}`);
          state.password = value;
          break;
      }
    },
    resetLoginFormData: (state) => {
      state.empID = "";
      state.password = "";
    },
  },
});

export const { handleLoginFormChange, resetLoginFormData } = loginSlice.actions;

export const selectLogin = (state: RootState) => state.login;

export default loginSlice.reducer;
