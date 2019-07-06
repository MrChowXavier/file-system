package com.aura.filesys.dao;

import com.aura.filesys.dataobject.UserInfoDO;

public interface UserInfoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    int deleteByPrimaryKey(String userName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    int insert(UserInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    int insertSelective(UserInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    UserInfoDO selectByPrimaryKey(String userName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    int updateByPrimaryKeySelective(UserInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Jul 02 19:37:49 CST 2019
     */
    int updateByPrimaryKey(UserInfoDO record);
}