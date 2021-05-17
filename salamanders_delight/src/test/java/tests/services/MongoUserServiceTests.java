package tests.services;

import com.daos.Dao;
import com.pojos.Employee;
import com.pojos.Manager;
import com.services.MongoUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.utils.UpdateResultImpl;

import java.util.ArrayList;

import static org.mockito.Mockito.times;

public class MongoUserServiceTests {
    private MongoUserService service;
    private Dao mockDao;

    @Before
    public void initTestDependencies() {
        mockDao = Mockito.mock(Dao.class);
        service = new MongoUserService(mockDao);
    }

    @Test
    public void doesEmployeeExist_ShouldReturnTrue() {
        Mockito.when(mockDao.getEmployeeByUserID("ExistingEmpID")).thenReturn(new Employee());
        boolean expected = true;
        Assert.assertEquals(expected, service.doesEmployeeExist("ExistingEmpID"));
    }

    @Test
    public void doesEmployeeExist_ShouldReturnFalse() {
        Mockito.when(mockDao.getEmployeeByUserID("NonExistingEmpID")).thenReturn(null);
        boolean expected = false;
        Assert.assertEquals(expected, service.doesEmployeeExist("ExistingEmpID"));
    }

    @Test
    public void doesManagerExist_ShouldReturnTrue() {
        Mockito.when(mockDao.getManagerByUserID("ExistingManagerID")).thenReturn(new Manager());
        boolean expected = true;
        Assert.assertEquals(expected, service.doesManagerExist("ExistingManagerID"));
    }

    @Test
    public void doesManagerExist_ShouldReturnFalse() {
        Mockito.when(mockDao.getManagerByUserID("NonExistingMGRID")).thenReturn(null);
        boolean expected = false;
        Assert.assertEquals(expected, service.doesEmployeeExist("NonExistingMGRID"));
    }

    @Test
    public void isEmployeePasswordValid_shouldReturnTrue() {
        Mockito.when(mockDao.getEmployeePasswordByUserID("ExistingEmpID")).thenReturn("the_correct_password");
        boolean expected = true;
        Assert.assertEquals(expected, service.isEmployeePasswordValid("ExistingEmpID", "the_correct_password"));
    }

    @Test
    public void isEmployeePasswordValid_shouldReturnFalse() {
        Mockito.when(mockDao.getEmployeePasswordByUserID("ExistingEmpID")).thenReturn("the_correct_password");
        boolean expected = false;
        Assert.assertEquals(expected, service.isEmployeePasswordValid("ExistingEmpID", "any_incorrect_password"));
    }

    @Test
    public void isManagerPasswordValid_shouldReturnTrue() {
        Mockito.when(mockDao.getManagerPasswordByUserID("ExistingManagerID")).thenReturn("the_correct_password");
        boolean expected = true;
        Assert.assertEquals(expected, service.isManagerPasswordValid("ExistingManagerID", "the_correct_password"));
    }

    @Test
    public void isManagerPasswordValid_shouldReturnFalse() {
        Mockito.when(mockDao.getManagerPasswordByUserID("ExistingManagerID")).thenReturn("the_correct_password");
        boolean expected = false;
        Assert.assertEquals(expected, service.isManagerPasswordValid("ExistingManagerID", "any_incorrect_password"));
    }

    @Test
    public void getEmployeeByEmpID_shouldReturnEmployeeClass() {
        Mockito.when(mockDao.getEmployeeByUserID("ExistingUserID")).thenReturn(new Employee());
        Assert.assertTrue(service.getEmployeeByEmpID("ExistingUserID").getClass() == Employee.class);
    }

    @Test
    public void getManagerByUserID_shouldReturnManagerClass() {
        Mockito.when(mockDao.getManagerByUserID("ExistingUserID")).thenReturn(new Manager());
        Assert.assertTrue(service.getManagerByUserID("ExistingUserID").getClass() == Manager.class);
    }

    @Test
    public void updateOneEmployeeField_shouldCallDaoDotUpdateOneEmployeeFieldOnce() {
        Mockito.when(mockDao.updateOneEmployeeField("empID", "field", "value")).thenReturn(new UpdateResultImpl());
        Assert.assertTrue(service.updateOneEmployeeField("empID", "field", "value").getClass() == UpdateResultImpl.class);

    }

    @Test
    public void getAllEmployees_shouldReturnArrayListOfEmployees() {
        Mockito.when(mockDao.getAllEmployees()).thenReturn(new ArrayList<>());
        Assert.assertTrue(service.getAllEmployees().getClass() == ArrayList.class);
    }

}
