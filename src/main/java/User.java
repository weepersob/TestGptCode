public class User {
   private String username;
    private  String password;
  private   String gender;
   private int id;

    public User() {
    }

    public User(String username, String password, String gender) {
        this.username = username;
        this.password = password;

        this.gender = gender;
    }

    public User(String username, String password,String gender, int id) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return addr
     */


    /**
     * 设置
     * @param addr
     */


    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return "{username = " + username + ", password = " + password + ", gender = " + gender + "}";
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
