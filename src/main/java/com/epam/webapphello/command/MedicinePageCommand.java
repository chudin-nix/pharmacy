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
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, DaoException {
        String id = req.getParameter("id");
        Optional<Medicine> medicine = medicineService.findMedicineById(id);
        if (medicine.isPresent()) {
            req.setAttribute("medicine", medicine.get());
            return "/WEB-INF/view/medicine.jsp";
        } else {
            req.setAttribute("errorMessage", "Invalid credentials");
            return "index.jsp";
        }
    }
}