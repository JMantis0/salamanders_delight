package tests.services;

import com.daos.Dao;
import com.pojos.Employee;
import com.services.MongoEmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MongoEmployeeServiceTest {
    private MongoEmployeeService service;
    private Dao mockDao;

    @Before
    public void initTestDependencies() {
        mockDao = Mockito.mock(Dao.class);
        service = new MongoEmployeeService(mockDao);
    }

    @Test
    public void doesUserExist_ShouldReturnTrue() {
        Mockito.when(mockDao.getEmployeeByUserID("ExistingEmpID")).thenReturn(new Employee());
        boolean expected = true;
        Assert.assertEquals(expected, service.doesUserExist("ExistingEmpID"));
    }

    @Test
    public void doesUserExist_ShouldReturnFalse() {
        Mockito.when(mockDao.getEmployeeByUserID("NonExistingEmpID")).thenReturn(null);
        boolean expected = false;
        Assert.assertEquals(expected, service.doesUserExist("ExistingEmpID"));
    }

    @Test
    public void isPasswordValid_shouldReturnTrue() {
        Mockito.when(mockDao.getEmployeePasswordByUserID("ExistingEmpID")).thenReturn("the_correct_password");
        boolean expected = true;
        Assert.assertEquals(expected, service.isPasswordValid("ExistingEmpID", "the_correct_password"));
    }

    @Test
    public void isPasswordValid_shouldReturnFalse() {
        Mockito.when(mockDao.getEmployeePasswordByUserID("ExistingEmpID")).thenReturn("the_correct_password");
        boolean expected = false;
        Assert.assertEquals(expected, service.isPasswordValid("ExistingEmpID","any_incorrect_password"));
    }


}
