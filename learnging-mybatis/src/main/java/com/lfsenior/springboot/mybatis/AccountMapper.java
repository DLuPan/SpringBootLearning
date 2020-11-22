package com.lfsenior.springboot.mybatis;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Insert("insert into account(name,money) values (#{name},#{money})")
    int add(@Param("name") String name, @Param("money") Double money);

    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    int update(@Param("name") String name, @Param("money") Double money, @Param("id") Integer id);

    @Delete("delete from account where id=#{id}")
    int delete(@Param("id") Integer id);

    @Select("select * from account where id=#{id}")
    Account findById(@Param("id") Integer id);

    @Select("select * from account")
    List<Account> findAll();
}
