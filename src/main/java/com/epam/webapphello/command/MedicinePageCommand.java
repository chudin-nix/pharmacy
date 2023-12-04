package com.epam.webapphello.command;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;
import com.epam.webapphello.service.MedicineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class MedicinePageCommand implements Command{

    private final MedicineService medicineService;

    public MedicinePageCommand(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, DaoException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Optional<Medicine> medicine = medicineService.findById(id);
        CommandResult result;
        if (medicine.isPresent()) {
            req.setAttribute("medicine", medicine.get());
            result = CommandResult.forward("/WEB-INF/view/medicine.jsp");
            return result;
        } else {
            req.setAttribute("errorMessage", "Invalid credentials");
            result = CommandResult.forward("/WEB-INF/view/medicine.jsp");
            return result;
        }
    }
}