package com.aura.filesys.dataobject;

public class UserPswdDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_pswd.user_name
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_pswd.id
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_pswd.user_pswd
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private String userPswd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_pswd.user_name
     *
     * @return the value of user_pswd.user_name
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_pswd.user_name
     *
     * @param userName the value for user_pswd.user_name
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_pswd.id
     *
     * @return the value of user_pswd.id
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_pswd.id
     *
     * @param id the value for user_pswd.id
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_pswd.user_pswd
     *
     * @return the value of user_pswd.user_pswd
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public String getUserPswd() {
        return userPswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_pswd.user_pswd
     *
     * @param userPswd the value for user_pswd.user_pswd
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd == null ? null : userPswd.trim();
    }
}