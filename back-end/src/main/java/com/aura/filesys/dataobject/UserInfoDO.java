package com.aura.filesys.dataobject;

import java.util.Date;

public class UserInfoDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_name
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_location
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private String userLocation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_birthday
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private Date userBirthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_gender
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private String userGender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_language
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private String userLanguage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_desc
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    private String userDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_name
     *
     * @return the value of user_info.user_name
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_name
     *
     * @param userName the value for user_info.user_name
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_location
     *
     * @return the value of user_info.user_location
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public String getUserLocation() {
        return userLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_location
     *
     * @param userLocation the value for user_info.user_location
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation == null ? null : userLocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_birthday
     *
     * @return the value of user_info.user_birthday
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_birthday
     *
     * @param userBirthday the value for user_info.user_birthday
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_gender
     *
     * @return the value of user_info.user_gender
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public String getUserGender() {
        return userGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_gender
     *
     * @param userGender the value for user_info.user_gender
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_language
     *
     * @return the value of user_info.user_language
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public String getUserLanguage() {
        return userLanguage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_language
     *
     * @param userLanguage the value for user_info.user_language
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage == null ? null : userLanguage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_desc
     *
     * @return the value of user_info.user_desc
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_desc
     *
     * @param userDesc the value for user_info.user_desc
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
    }
}