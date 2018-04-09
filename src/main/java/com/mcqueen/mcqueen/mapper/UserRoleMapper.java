package com.mcqueen.mcqueen.mapper;

import com.mcqueen.mcqueen.model.UserRole;
import com.mcqueen.mcqueen.model.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    long countByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int deleteByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    UserRole selectByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_User_Role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserRole record);

    void    configUserRole(@Param("userRoles") List<UserRole> userRoles);

    void delAllRoleByUserID(@Param("userID") Integer userID);
}