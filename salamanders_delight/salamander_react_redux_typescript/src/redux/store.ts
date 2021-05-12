import { configureStore, ThunkAction, Action } from "@reduxjs/toolkit";
import salamanderReducer from "./salamanderSlice";

export const store = configureStore({
  reducer: {
    salamander: salamanderReducer
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
