import dao.DAOImpl;
import entity.Food;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List<Food> data;

    public Controller(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        processRequest(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        DAOImpl dao = new DAOImpl();
        int page = 1;
        int resultsPerPage = 2;
        if (data == null) {
            data = dao.getParsedData(request.getParameter("parser"));
        }
        if (request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        int results = data.size();
        int pages = (int) Math.ceil((double)results/resultsPerPage);
        request.setAttribute("data", data);
        request.setAttribute("page", page);
        request.setAttribute("resultsPerPage", resultsPerPage);
        request.setAttribute("pages", pages);
        RequestDispatcher view = request.getRequestDispatcher("display.jsp");
        view.forward(request, response);
    }

}