package com.zju.ysoretarded.dao;

import com.zju.ysoretarded.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author zcz
 * @CreateTime 2020/2/10 10:31
 */

@Mapper
@Component
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getById(@Param("id") int id);

    @Insert("insert into user(id,name) values (#{id}, #{name})")
    int  insert(User user);
}
