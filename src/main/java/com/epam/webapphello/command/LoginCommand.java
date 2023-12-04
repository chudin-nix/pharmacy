package com.epam.webapphello.command;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.ServiceException;
import com.epam.webapphello.service.MedicineService;
import com.epam.webapphello.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class LoginCommand implements Command {
    private final UserService userService;
    private final MedicineService medicineService;

    public LoginCommand(UserService userService, MedicineService medicineService) {
        this.userService = userService;
        this.medicineService = medicineService;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> user = userService.login(login, password);
        CommandResult result;
        if (user.isPresent()) {
            req.getSession().setAttribute("user_login", user.get().getLogin());
            req.getSession().setAttribute("user_id", user.get().getId());
            List<Medicine> medicineList = medicineService.findAll();
            req.setAttribute("medicineList", medicineList);
            return CommandResult.forward("/WEB-INF/view/main.jsp");
        } else {
            req.setAttribute("errorMessage", "Invalid credentials");
            result = CommandResult.forward("/index.jsp");
        }
        return result;
    }
}
