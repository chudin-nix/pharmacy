package com.epam.webapphello.command;

import com.epam.webapphello.dao.SimpleUserDao;
import com.epam.webapphello.dao.SimpleMedicineDao;
import com.epam.webapphello.service.SimpleMedicineService;
import com.epam.webapphello.service.SimpleUserService;

public class CommandFactory {
    public static Command createCommand(String command) {
        switch (command) {
            case "login":
                return new LoginCommand(new SimpleUserService(new SimpleUserDao()), new SimpleMedicineService(new SimpleMedicineDao()));
            case "medicinePage":
                return new MedicinePageCommand(new SimpleMedicineService(new SimpleMedicineDao()));
            default:
                throw new IllegalArgumentException("Unknown command " + command);
        }
    }
}