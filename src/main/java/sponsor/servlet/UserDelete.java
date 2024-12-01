package sponsor.servlet;

import sponsor.dal.*;
import sponsor.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userdelete")
public class UserDelete extends HttpServlet {

    protected UserDao usersDao;

    @Override
    public void init() throws ServletException {
        usersDao = UserDao.getInstance();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        String userIdStr = req.getParameter("USER_ID");

        try {
            int userId = Integer.parseInt(userIdStr);
            Users user = usersDao.getUserByUserId(userId);
            if (user != null) {
                usersDao.delete(user);
                messages.put("success", "Successfully deleted user ID " + userId);
            } else {
                messages.put("success", "User with ID " + userId + " not found.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            messages.put("success", "Error deleting user. Please try again.");
        }

        req.getRequestDispatcher("/UserDelete.jsp").forward(req, resp);
    }
}
