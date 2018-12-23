package di;

import controller.command.*;
import service.ExhibitionService;
import service.ExhibitionSeviceImpl;
import service.UserService;
import service.UserServiceImpl;

public class CommandModule {
    private static CommandModule instance = new CommandModule();

    public static CommandModule getInstance() {
        return instance;
    }

    //DAO

    //Services
    private UserService userService;
    private ExhibitionService exhibitionService;

    //Commands
    private AddWishCommand addWishCommand;
    private CreateExhibitionCommand createExhibitionCommand;
    private HomePageCommand homePageCommand;
    private LoginCommand loginCommand;
    private SingUpCommand singUpCommand;
    private CreateExhibitionPageCommand createExhibitionPageCommand;
    private IndexPageCommand indexPageCommand;
    private LogOutCommand logOutCommand;
    private UserPageCommand userPageCommand;


    private CommandModule() {
        userService = new UserServiceImpl();
        exhibitionService = new ExhibitionSeviceImpl();

        addWishCommand = new AddWishCommand(userService);
        createExhibitionCommand = new CreateExhibitionCommand(exhibitionService);
        homePageCommand = new HomePageCommand(exhibitionService);
        loginCommand = new LoginCommand(userService);
        singUpCommand = new SingUpCommand(userService);
        createExhibitionPageCommand = new CreateExhibitionPageCommand();
        indexPageCommand = new IndexPageCommand();
        logOutCommand = new LogOutCommand();
        userPageCommand = new UserPageCommand();
    }

    public CreateExhibitionPageCommand getCreateExhibitionPageCommand() {
        return createExhibitionPageCommand;
    }

    public IndexPageCommand getIndexPageCommand() {
        return indexPageCommand;
    }

    public LogOutCommand getLogOutCommand() {
        return logOutCommand;
    }

    public UserPageCommand getUserPageCommand() {
        return userPageCommand;
    }

    public CreateExhibitionCommand getCreateExhibitionCommand() {
        return createExhibitionCommand;
    }

    public HomePageCommand getHomePageCommand() {
        return homePageCommand;
    }

    public LoginCommand getLoginCommand() {
        return loginCommand;
    }

    public SingUpCommand getSingUpCommand() {
        return singUpCommand;
    }

    public AddWishCommand getAddWishCommand() {
        return addWishCommand;
    }
}
