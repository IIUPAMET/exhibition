package controller.command;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class AddWishCommandTest {
    @Test
    public void addingWishShouldRedirectToHomePage() {
        UserService userService = Mockito.mock(UserService.class);
        AddWishCommand addWishCommand = new AddWishCommand(userService);
        String result = addWishCommand.execute(null);
        Assert.assertEquals("???", result, "redirect: home");
    }
}
