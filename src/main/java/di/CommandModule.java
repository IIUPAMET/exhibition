package di;

import controller.command.*;
import model.dao.ExhibitionDao;
import model.dao.RequestDao;
import model.dao.UserDao;
import model.dao.impl.ConnectionPoolHolder;
import model.dao.impl.JDBCExhibitionDao;
import model.dao.impl.JDBCRequestDao;
import model.dao.impl.JDBCUserDao;
import service.*;

import javax.sql.DataSource;

public class CommandModule {
    private static CommandModule instance = new CommandModule();

    public static CommandModule getInstance() {
        return instance;
    }

    //DAO
    private ExhibitionDao exhibitionDao;
    private UserDao userDao;
    private RequestDao requestDao;

    //Services
    private UserService userService;
    private ExhibitionService exhibitionService;
    private RequestService requestService;

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
        DataSource dataSource = ConnectionPoolHolder.getDataSource();

        exhibitionDao = new JDBCExhibitionDao(dataSource);
        userDao = new JDBCUserDao(dataSource);
        requestDao = new JDBCRequestDao(dataSource);

        userService = new UserServiceImpl(userDao);
        exhibitionService = new ExhibitionSeviceImpl(exhibitionDao);
        requestService = new RequestService(requestDao);

        addWishCommand = new AddWishCommand(userService);
        createExhibitionCommand = new CreateExhibitionCommand(exhibitionService);
        homePageCommand = new HomePageCommand(exhibitionService, requestService);
        loginCommand = new LoginCommand(userService);
        singUpCommand = new SingUpCommand(userService);
        createExhibitionPageCommand = new CreateExhibitionPageCommand();
        indexPageCommand = new IndexPageCommand();
        logOutCommand = new LogOutCommand();
        userPageCommand = new UserPageCommand(exhibitionService);
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
