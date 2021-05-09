package tests.controllers;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.services.MongoEmployeeService;
import com.services.MongoService;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;



public class ReactControllerTest {

    private Controller controller;
    private MongoEmployeeService mockService;

    @Before
    public void initTestDependencies() {
        mockService = Mockito.mock(MongoEmployeeService.class);
        controller = new ReactController(mockService);
    }

    @Test
    public void loginAttemptAndGetNextURL_shouldReturnPairWithEmployeeURLandOKStatus() {
        Mockito.when(mockService.doesUserExist("ExistingUser")).thenReturn(true);
        Mockito.when(mockService.isPasswordValid("ExistingUser", "VALID PASSWORD")).thenReturn(true);
        Pair<String, Integer> expected = new Pair<>("/employee_home", 200);
        Assert.assertEquals(expected, controller.loginAttemptAndGetNextURL("ExistingUser", "VALID PASSWORD"));
    }

    @Test
    public void loginAttemptAndGetNextURL_shouldReturnPairWithNoSuchUserURLandUnauthorizedStatus() {
        Mockito.when(mockService.doesUserExist("NonExistingUser")).thenReturn(false);
        Pair<String, Integer> expected = new Pair<>("/no_such_user", 401);
        Assert.assertEquals(expected, controller.loginAttemptAndGetNextURL("NonExistingUser", "irrelevant_password"));
    }

    @Test
    public void loginAttemptAndGetNextURL_shouldReturnPairWithInvalidPasswordURLandUnauthorizedStatus() {
        Mockito.when(mockService.doesUserExist("ExistingUser")).thenReturn(true);
        Mockito.when(mockService.isPasswordValid("ExistingUser", "WRONG PASSWORD")).thenReturn(false);
        Pair<String, Integer> expected = new Pair<>("/invalid_password", 401);
        Assert.assertEquals(expected, controller.loginAttemptAndGetNextURL("ExistingUser", "WRONG PASSWORD"));
    }
}
