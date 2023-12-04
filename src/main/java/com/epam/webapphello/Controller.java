package com.epam.webapphello;

import com.epam.webapphello.command.Command;
import com.epam.webapphello.command.CommandFactory;
import com.epam.webapphello.command.CommandResult;
import com.epam.webapphello.exception.DaoException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DaoException {
        String commandLine = req.getParameter("command");
        Command action = CommandFactory.createCommand(commandLine);
        try {
            CommandResult result = action.execute(req, resp);
            dispatch(req, resp, result);
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(result);
//            dispatcher.forward(req, resp);
        } catch (Exception exception) {
            req.setAttribute("errorMessage", exception.getMessage());
            exception.printStackTrace();
            dispatch(req, resp, CommandResult.forward("/error.jsp"));
        }
//        CommandFactory commandFactory = new CommandFactory();
//        Command command = commandFactory.createCommand(commandLine);
//        String page = command.execute(req, resp);
//        req.getRequestDispatcher(page).forward(req, resp);
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp, CommandResult result) throws ServletException, IOException {
        String page = result.getPage();
        if (!result.isRedirect()) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(page);
        }
    }
}