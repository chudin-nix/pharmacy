package com.epam.webapphello.command;

public class CommandResult {

    private boolean redirect;
    private String page;

    public CommandResult(boolean redirect, String page) {
        this.redirect = redirect;
        this.page = page;
    }

    public static CommandResult redirect(String page) {
        return new CommandResult(true, page);
    }

    public static CommandResult forward(String page) {
        return new CommandResult(false, page);
    }

    public boolean isRedirect() {
        return redirect;
    }

    public String getPage() {
        return page;
    }
}
