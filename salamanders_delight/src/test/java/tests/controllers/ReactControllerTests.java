package tests.controllers;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.pojos.Employee;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import com.services.MongoReimbursementService;
import com.services.MongoUserService;
import tests.utils.FindIterableImpl;
import javafx.util.Pair;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import tests.utils.UpdateResultImpl;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class ReactControllerTests {

    private Controller userController;
    private Controller requestController;
    private MongoUserService mockUserService;
    private MongoReimbursementService mockRequestService;
    private MongoUserService userServiceSpy;
    private MongoReimbursementService requestServiceSpy;

    @Before
    public void initTestDependencies() {
        mockUserService = Mockito.mock(MongoUserService.class);
        userController = new ReactController(mockUserService);
        mockRequestService = Mockito.mock(MongoReimbursementService.class);
        requestController = new ReactController(mockRequestService);
    }

    @Test
    public void employeeLoginAttemptAndGetNextURL_shouldReturnPairWithEmployeeURLandOKStatus() {
        Mockito.when(mockUserService.doesEmployeeExist("ExistingUser")).thenReturn(true);
        Mockito.when(mockUserService.isEmployeePasswordValid("ExistingUser", "VALID PASSWORD")).thenReturn(true);
        Pair<String, Integer> expected = new Pair<>("/employee_home", 200);
        Assert.assertEquals(expected, userController.loginAttemptAndGetNextURL("ExistingUser", "VALID PASSWORD", "employee"));
    }

    @Test
    public void employeeLoginAttemptAndGetNextURL_shouldReturnPairWithNoSuchUserURLandUnauthorizedStatus() {
        Mockito.when(mockUserService.doesEmployeeExist("NonExistingUser")).thenReturn(false);
        Pair<String, Integer> expected = new Pair<>("/no_such_user", 401);
        Assert.assertEquals(expected, userController.loginAttemptAndGetNextURL("NonExistingUser", "irrelevant_password", "employee"));
    }

    @Test
    public void employeeLoginAttemptAndGetNextURL_shouldReturnPairWithInvalidPasswordURLandUnauthorizedStatus() {
        Mockito.when(mockUserService.doesEmployeeExist("ExistingUser")).thenReturn(true);
        Mockito.when(mockUserService.isEmployeePasswordValid("ExistingUser", "WRONG PASSWORD")).thenReturn(false);
        Pair<String, Integer> expected = new Pair<>("/invalid_password", 401);
        Assert.assertEquals(expected, userController.loginAttemptAndGetNextURL("ExistingUser", "WRONG PASSWORD", "employee"));
    }

    @Test
    public void managerLoginAttemptAndGetNextURL_shouldReturnPairWithManagerURLandOKStatus() {
        Mockito.when(mockUserService.doesManagerExist("ExistingUser")).thenReturn(true);
        Mockito.when(mockUserService.isManagerPasswordValid("ExistingUser", "VALID PASSWORD")).thenReturn(true);
        Pair<String, Integer> expected = new Pair<>("/manager_home", 200);
        Assert.assertEquals(expected, userController.loginAttemptAndGetNextURL("ExistingUser", "VALID PASSWORD", "manager"));
    }

    @Test
    public void managerLoginAttemptAndGetNextURL_shouldReturnPairWithNoSuchUserURLandUnauthorizedStatus() {
        Mockito.when(mockUserService.doesManagerExist("NonExistingUser")).thenReturn(false);
        Pair<String, Integer> expected = new Pair<>("/no_such_user", 401);
        Assert.assertEquals(expected, userController.loginAttemptAndGetNextURL("NonExistingUser", "irrelevant_password", "manager"));
    }

    @Test
    public void managerLoginAttemptAndGetNextURL_shouldReturnPairWithInvalidPasswordURLandUnauthorizedStatus() {
        Mockito.when(mockUserService.doesManagerExist("ExistingUser")).thenReturn(true);
        Mockito.when(mockUserService.isManagerPasswordValid("ExistingUser", "WRONG PASSWORD")).thenReturn(false);
        Pair<String, Integer> expected = new Pair<>("/invalid_password", 401);
        Assert.assertEquals(expected, userController.loginAttemptAndGetNextURL("ExistingUser", "WRONG PASSWORD", "manager"));
    }
    @Test
    public void loginAttemptAndGetNextURL_shouldReturnNull() {
        Pair<String, Integer> expected = null;
        Assert.assertEquals(expected, userController.loginAttemptAndGetNextURL("AnyString", "AnyString", "invalid_login_type"));
    }

    @Test
    public void getCurrentEmployeeProfile_shouldReturnEmployee() {
        Mockito.when(mockUserService.getEmployeeByEmpID("ExistingUser")).thenReturn(new Employee());
        Assert.assertTrue(userController.getCurrentEmployeeProfile("ExistingUser").getClass() == Employee.class);
    }

    @Test
    public void getCurrentManagerProfile_shouldReturnManager() {
        Mockito.when(mockUserService.getManagerByUserID("ExistingUser")).thenReturn(new Manager());
        Assert.assertTrue(userController.getCurrentManagerProfile("ExistingUser").getClass() == Manager.class);
    }

    @Test
    public void getAllRequestsByEmpID_shouldReturnFindIterableImpl() {
        Mockito.when(mockRequestService.getAllRequestsByEmpID("ExistingUser")).thenReturn(new FindIterableImpl());
        Assert.assertTrue(requestController.getAllRequestsByEmpID("ExistingUser").getClass() == FindIterableImpl.class);

    }

    @Test
    public void createRequest_shouldCallServiceDotCreateRequestOnce() {
        ReimbursementRequest request = new ReimbursementRequest();
        Mockito.doNothing().when(mockRequestService).createRequest(request);
        requestController.createRequest(request);
        Mockito.verify(mockRequestService, times(1)).createRequest(request);
    }

    @Test
    public void updateOneEmployeeField_shouldCallUserServiceDotUpdateOneEmployeeField() {
        Mockito.when(mockUserService.updateOneEmployeeField("empID", "field", "value")).thenReturn(new UpdateResultImpl());
        Assert.assertTrue(userController.updateOneEmployeeField("empID", "field", "value").getClass() == UpdateResultImpl.class);
    }

    @Test
    public void getALlRequests_shouldReturnListOfEmployees() {
        Mockito.when(mockRequestService.getAllRequests()).thenReturn(new ArrayList<>());
        Assert.assertTrue(requestController.getAllRequests().getClass() == ArrayList.class);
    }

    @Test
    public void resolveRequest_shouldCallRequestServiceDotResolveRequestOnce() {
        ObjectId objId = new ObjectId();
        Mockito.doNothing().when(mockRequestService).resolveRequest(objId, "resolver", "resolution");
        requestController.resolveRequest(objId, "resolver", "resolution");
        Mockito.verify(mockRequestService, times(1)).resolveRequest(objId, "resolver", "resolution");
    }



}
