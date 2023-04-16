package com.linsen.service;

import com.linsen.mapper.UserMapper;
import com.linsen.pojo.User;
import com.linsen.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username,String password){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(username, password);
        sqlSession.close();

        return user;
    }
    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = mapper.selectByUsername(user.getUsername());

        if(u==null){
            mapper.add(user);
            sqlSession.commit();
        }

        sqlSession.close();
        return u==null;
    }
}
