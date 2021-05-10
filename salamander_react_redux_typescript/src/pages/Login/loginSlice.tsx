import { createAsyncThunk, createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState, AppThunk } from '../../redux/store';

export interface LoginState {
  empID: String;
  password: String;
}

const initialState: LoginState = {
  empID: "",
  password: "",
};

export const loginSlice = createSlice({
  name: 'login',
  initialState,
  reducers: {
    handleChange: (state, action) => {
     //Not sure what to do here
     console.log("event", action);
     console.log("state", state.empID);
     console.log(`updating ${action.payload.fieldName} to ${action.payload.value}`)
     state[action.payload.fieldName] = action.payload.value;
     console.log(state);
    }
  }
});

export const {handleChange} = loginSlice.actions;

export const selectLogin = (state: RootState) => state.login;

export default loginSlice.reducer;