package com.epam.webapphello.dao;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface MedicineDao extends Dao<Medicine> {

    Optional<Medicine> findMedicineByParameters(String name, String price, String quantity, String dosage) throws DaoException;
}