package com.epam.webapphello.command;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;
import com.epam.webapphello.service.MedicineService;
import com.epam.webapphello.service.OrderService;
import com.epam.webapphello.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class OrderCommand implements Command {

    private final OrderService orderService;
    private final MedicineService medicineService;
    private final UserService userService;

    public OrderCommand(OrderService orderService, MedicineService medicineService, UserService userService) {
        this.orderService = orderService;
        this.medicineService = medicineService;
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, DaoException {
        Integer userId = Integer.parseInt(req.getParameter("user_id"));
        Integer medicineId = Integer.parseInt(req.getParameter("medicine_id"));
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));

        //В переменной order не до конца понимаю, верно или нет возвращать Integer
        orderService.order(userId, medicineId, quantity);
        Optional<Medicine> medicine = medicineService.findById(medicineId);
        Optional<User> user = userService.findById(userId);

        if (medicine.isPresent() && user.isPresent()) {
            String messageAboutPurchase = "Вы купили " + quantity + " " + medicine.get().getName() + ". Спасибо, " + user.get().getLogin() + "!";
            return CommandResult.redirect(messageAboutPurchase);
        } else {
            throw new ServiceException("User or medicine is not present");
        }
    }
}