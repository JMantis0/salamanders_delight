package tests.servlets;
import static org.mockito.Mockito.*;
import com.services.MongoReimbursementService;
import com.servlets.GetAllReimbursementsServlet;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class GetAllReimbursementsServletTest {


    @Test
    public void doGetTest() throws IOException, ServletException {
        HttpServletRequest mreq = mock(HttpServletRequest.class);
        HttpServletResponse mres = mock(HttpServletResponse.class);
        MongoReimbursementService mrs = mock(MongoReimbursementService.class);
        GetAllReimbursementsServlet gars = new GetAllReimbursementsServlet();
        gars.setService(mrs);
        when(mrs.getAllRequests()).thenReturn(new ArrayList<>());
        gars.doGet(mreq, mres);
    }
}
