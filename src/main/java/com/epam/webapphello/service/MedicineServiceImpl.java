package com.epam.webapphello.service;

import com.epam.webapphello.dao.MedicineDao;
import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class MedicineServiceImpl implements MedicineService {

    private MedicineDao dao;

    public MedicineServiceImpl(MedicineDao dao) {
        this.dao = dao;
    }


    @Override
    public Optional<Medicine> findById(Integer id) throws ServiceException {
        try {
            return dao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
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
