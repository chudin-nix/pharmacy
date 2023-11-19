package com.epam.webapphello.dao;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface MedicineDao<T> {

    Optional<Medicine> findMedicineById(String id) throws DaoException;
    Optional<Medicine> findMedicineByParameters(String name, String price, String quantity, String dosage) throws DaoException;
    List<Medicine> findAll() throws DaoException;
}