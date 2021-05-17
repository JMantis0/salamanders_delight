package tests.services;

import com.daos.Dao;
import com.pojos.ReimbursementRequest;
import com.services.MongoReimbursementService;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.utils.FindIterableImpl;
import tests.utils.InsertOneResultImpl;
import tests.utils.UpdateResultImpl;
import java.util.ArrayList;

public class MongoReimbursementServiceTests {
    private MongoReimbursementService service;
    private Dao mockDao;
    @Before
    public void initTestDependencies() {
        mockDao = Mockito.mock(Dao.class);
        service = new MongoReimbursementService(mockDao);
    }

    @Test
    public void getAllRequestsByEmpID_shouldReturnFindIterableImpl() {
        Mockito.when(mockDao.getAllRequestsByUserID("ExistingUserID")).thenReturn(new FindIterableImpl());
        Assert.assertTrue(service.getAllRequestsByEmpID("ExistingUserID").getClass() == FindIterableImpl.class);
    }

    @Test
    public void createRequest_shouldCallDaoCreateRequestOnce() {
        ReimbursementRequest request = new ReimbursementRequest();
        Mockito.when(mockDao.createRequest(request)).thenReturn(new InsertOneResultImpl());
        Assert.assertTrue(mockDao.createRequest(request).getClass() == InsertOneResultImpl.class);
    }

    @Test
    public void getAllRequests_shouldReturnListOfRequests() {
        Mockito.when(mockDao.getAllRequests()).thenReturn(new ArrayList<>());
        Assert.assertTrue(service.getAllRequests().getClass() == ArrayList.class);
    }

    @Test
    public void resolveRequest_shouldCallDaoResolveRequestOnce() {
        ObjectId objId = new ObjectId();
        Mockito.when(mockDao.resolveRequest(objId, "resolver", "resolution")).thenReturn(new UpdateResultImpl());
        Assert.assertTrue(mockDao.resolveRequest(objId, "resolver", "resolution").getClass() == UpdateResultImpl.class);
    }


}
