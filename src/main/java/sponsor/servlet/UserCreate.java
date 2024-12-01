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

@WebServlet("/usercreate")
public class UserCreate extends HttpServlet {

    protected UserDao usersDao;

    @Override
    public void init() throws ServletException {
        usersDao = UserDao.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        String username = req.getParameter("USERNAME");
        if (username == null || username.trim().isEmpty()) {
            messages.put("success", "Invalid Username");
        } else {
            String email = req.getParameter("EMAIL");
            String passwordHash = req.getParameter("PASSWORD_HASH");

            try {
                Users user = new Users(username, email, passwordHash);
                user = usersDao.create(user);
                messages.put("success", "Successfully created user: " + username);
            } catch (SQLException e) {
                e.printStackTrace();
                messages.put("success", "Error creating the user. Please try again.");
            }
        }

        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
    }
}
