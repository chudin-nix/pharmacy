package com.epam.webapphello.service;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    Optional<Medicine> findMedicineById(String id) throws ServiceException, DaoException;

    List<Medicine> findAll() throws ServiceException;
}