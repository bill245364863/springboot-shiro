package com.shiro.springbootshiro.mapper;

import com.shiro.springbootshiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    public abstract User queryUserByName(String username);
}
