package com.epam.webapphello.dao;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleMedicineDao extends AbstractDao<Medicine> implements MedicineDao<Medicine> {

    public Optional<Medicine> findMedicineByParameters(final String name, final String price, final String quantity, final String dosage) throws DaoException {
        return executeQueryForSingleResult("SELECT ID, NAME, PRICE, QUANTITY, DOSAGE FROM MEDICINE WHERE NAME = ? AND PRICE = ? AND QUANTITY = ? AND DOSAGE = ?",
                Arrays.asList(name, price, quantity, dosage));
    }

    public Optional<Medicine> findMedicineById(final String id) throws DaoException {
        return executeQueryForSingleResult("SELECT ID, NAME, PRICE, QUANTITY, DOSAGE FROM MEDICINE WHERE ID = ?", Arrays.asList(id));
    }

    @Override
    public List<Medicine> findAll() throws DaoException {
        return executeQuery("SELECT * FROM medicine", Arrays.asList());
    }

    @Override
    protected Medicine map(ResultSet resultSet) throws SQLException {
        Medicine medicine = new Medicine();
        medicine.setId(resultSet.getInt("id"));
        medicine.setName(resultSet.getString("name"));
        medicine.setPrice(resultSet.getBigDecimal("price"));
        medicine.setQuantity(resultSet.getInt("quantity"));
        medicine.setDosage(resultSet.getInt("dosage"));
        return medicine;
    }
}