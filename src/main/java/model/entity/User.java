package model.entity;

public class User {
    private int id;
    private String login;
    private String pass;
    private String nameUA;
    private String nameEN;
    private String mail;
    private Role role = Role.GUEST;

    public enum Role {
        GUEST("/index.jsp"){},
        USER("/index.jsp"){},
        ADMIN("/index.jsp"){};

        private String roleBasePath;

        public String getRoleBasePath() {
            return roleBasePath;
        }

        Role(String path){
            roleBasePath = path;
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNameUA() {
        return nameUA;
    }

    public void setNameUA(String nameUA) {
        this.nameUA = nameUA;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", nameUA='" + nameUA + '\'' +
                ", nameEN='" + nameEN + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
