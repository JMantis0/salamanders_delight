package tests.daos;

import com.daos.Dao;
import com.daos.MongoDao;
import com.mongodb.client.MongoCollection;
import com.pojos.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static com.mongodb.client.model.Filters.eq;

public class MongoDaoTests {
    private  MongoDao dao;
    private MongoCollection<Employee> mockEmployeeCollection;

//    @Before
//    public void initDependencies() {
//        mockEmployeeCollection = Mockito.mock(MongoCollection.class);
//        dao = new MongoDao();
//        dao.setEmployees(mockEmployeeCollection);
//    }
//
//    @Test
//    public void getEmployeePasswordByEmpID_shouldReturnCorrectPassword() {
//        Mockito.when(mockEmployeeCollection.find(eq("empID", "Employee ID")).first().getPassword()).thenReturn("the_correct_password");
//        String expected = "the_correct_password";
//        Assert.assertEquals(expected, dao.getEmployeePasswordByEmpID("Employee ID"));
//    }
}
