package tests.daos;

import com.daos.MongoDao;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.pojos.Employee;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.utils.FindIterableImpl;
import tests.utils.InsertOneResultImpl;
import tests.utils.UpdateResultImpl;
import java.util.ArrayList;
import static com.mongodb.client.model.Filters.eq;

public class MongoDaoTests {
    private MongoDao dao;
    private MongoCollection<Employee> mockEmployees;
    private MongoCollection<ReimbursementRequest> mockRequests;
    private MongoCollection<Manager> mockManagers;

    @Before
    public void initDependencies() {
        mockEmployees = Mockito.mock(MongoCollection.class);
        mockRequests = Mockito.mock(MongoCollection.class);
        mockManagers = Mockito.mock(MongoCollection.class);
        dao = new MongoDao();
        dao.setEmployees(mockEmployees);
        dao.setManagers(mockManagers);
        dao.setReimbursementRequests(mockRequests);
    }

    @Test
    public void getEmployeePasswordByEmpID_shouldReturnCorrectPassword() {
        FindIterable<Employee> mockEmployeeFindIterable = Mockito.mock(FindIterableImpl.class);
        Employee mockEmployee = Mockito.mock(Employee.class);
        Mockito.when(mockEmployeeFindIterable.first()).thenReturn(mockEmployee);
        Mockito.when(mockEmployee.getPassword()).thenReturn("the_correct_password");
        Mockito.when(mockEmployees.find(eq("userID", "Employee ID"))).thenReturn(mockEmployeeFindIterable);
        String expected = "the_correct_password";
        Assert.assertEquals(expected, dao.getEmployeePasswordByUserID("Employee ID"));
    }

    @Test
    public void getManagerPasswordByUserID_shouldReturnCorrectPassword() {
        FindIterable<Manager> mockManagerFindIterable = Mockito.mock(FindIterableImpl.class);
        Manager mockManager = Mockito.mock(Manager.class);
        Mockito.when(mockManagerFindIterable.first()).thenReturn(mockManager);
        Mockito.when(mockManager.getPassword()).thenReturn("the_correct_password");
        Mockito.when(mockManagers.find(eq("userID", "Manager ID"))).thenReturn(mockManagerFindIterable);
        String expected = "the_correct_password";
        Assert.assertEquals(expected, dao.getManagerPasswordByUserID("Manager ID"));
    }

    @Test
    public void getEmployeeByUserID_shouldReturnEmployee() {
        FindIterable<Employee> mockEmployeeFindIterable = Mockito.mock(FindIterableImpl.class);
        Employee mockEmployee = Mockito.mock(Employee.class);
        Mockito.when(mockEmployeeFindIterable.first()).thenReturn(mockEmployee);
        Mockito.when(mockEmployees.find(eq("userID", "Employee ID"))).thenReturn(mockEmployeeFindIterable);
        Assert.assertTrue(dao.getEmployeeByUserID("Employee ID").getClass() == Employee.class);
    }

    @Test
    public void getManagerByUserId_shouldReturnManager() {
        FindIterable<Manager> mockManagerFindIterable = Mockito.mock(FindIterableImpl.class);
        Manager mockManager = Mockito.mock(Manager.class);
        Mockito.when(mockManagerFindIterable.first()).thenReturn(mockManager);
        Mockito.when(mockManagers.find(eq("userID", "Manager ID"))).thenReturn(mockManagerFindIterable);
        Assert.assertTrue(dao.getManagerByUserID("Manager ID").getClass() == Manager.class);
    }

    @Test
    public void getAllRequestsByUserID_shouldReturnFindIterableOfRequests() {
        Mockito.when(mockRequests.find(eq("requesterID", "Employee ID"))).thenReturn(new FindIterableImpl());
        Assert.assertTrue(dao.getAllRequestsByUserID("Employee ID").getClass() == FindIterableImpl.class);
    }

    @Test
    public void getAllRequests_shouldReturnListOfRequests() {
        Mockito.when(mockRequests.find()).thenReturn(new FindIterableImpl());
        Assert.assertTrue(dao.getAllRequests().getClass() == ArrayList.class);
    }

    @Test
    public void createRequest_shouldCallRequestsInsertOneOnce() {
        ReimbursementRequest request = new ReimbursementRequest();
        Mockito.when(mockRequests.insertOne(request)).thenReturn(new InsertOneResultImpl());
        Assert.assertTrue(dao.createRequest(request).getClass() == InsertOneResultImpl.class);
    }

    @Test
    public void updateOneEmployeeField_shouldReturnUpdateResult() {
        BasicDBObject query = new BasicDBObject();
        query.put("userID", "TheUserName");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("field", "value");

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        Mockito.when(mockEmployees.updateOne(query, updateObject)).thenReturn(new UpdateResultImpl());
        Assert.assertTrue(dao.updateOneEmployeeField("TheUserName", "field", "value").getClass() == UpdateResultImpl.class);
    }

    @Test
    public void resolveRequest_shouldReturnUpdateResult() {
        ObjectId objId = new ObjectId();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", objId);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("status", "the_resolution");
        newDocument.put("resolvedBy", "the_resolver");

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        Mockito.when(mockRequests.updateOne(query, updateObject)).thenReturn(new UpdateResultImpl());
        Assert.assertTrue(dao.resolveRequest(objId, "the_resolver", "the_resolution").getClass() == UpdateResultImpl.class);
    }

    @Test
    public void getAllEmployees_shouldReturnListOfEmployees() {
        Mockito.when(mockEmployees.find()).thenReturn(new FindIterableImpl());
        Assert.assertTrue(dao.getAllEmployees().getClass() == ArrayList.class);
    }

}
