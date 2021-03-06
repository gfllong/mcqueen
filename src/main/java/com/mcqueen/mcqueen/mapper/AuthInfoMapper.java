package com.mcqueen.mcqueen.mapper;

import com.github.pagehelper.Page;
import com.mcqueen.mcqueen.model.AuthInfo;
import com.mcqueen.mcqueen.model.AuthInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AuthInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    long countByExample(AuthInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int deleteByExample(AuthInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int insert(AuthInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int insertSelective(AuthInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    List<AuthInfo> selectByExample(AuthInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    AuthInfo selectByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AuthInfo record, @Param("example") AuthInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AuthInfo record, @Param("example") AuthInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AuthInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table M_Auth_Info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AuthInfo record);

    Page<AuthInfo> findValidAuth();

    List<AuthInfo> findByUserID(@Param("userID") Integer userID);
}