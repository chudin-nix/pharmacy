package com.epam.webapphello.service;

import com.epam.webapphello.dao.MedicineDao;
import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class SimpleMedicineService implements MedicineService {

    private MedicineDao<Medicine> dao;

    public SimpleMedicineService(MedicineDao<Medicine> dao) {
        this.dao = dao;
    }


    @Override
    public Optional<Medicine> findMedicineById(String id) throws ServiceException, DaoException {
        return dao.findMedicineById(id);
    }

    @Override
    public List<Medicine> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
