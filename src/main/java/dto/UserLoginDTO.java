package dto;

public class UserLoginDTO {

    private long id;
    String nickname;
    String password;

    public UserLoginDTO(long id, String nickname, String password) {
        super();
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
