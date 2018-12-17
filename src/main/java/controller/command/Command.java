package controller.command;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public interface Command {
    String execute(HttpServletRequest request) throws ParseException;
}
