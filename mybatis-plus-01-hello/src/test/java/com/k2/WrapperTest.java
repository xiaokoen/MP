package com.k2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.k2.mapper.UserMapper;
import com.k2.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper userMapper;

    // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于15岁
    @Test
    public void test1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 15);
        userMapper.selectList(wrapper);
    }

    // 查询名字koen(selectOne),出现多个相同名字，不要使用selectOne
    @Test
    public void test2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "koen");
        userMapper.selectOne(wrapper);
    }

    // 查询年龄在18~25岁之间的用户有多少个
    @Test
    public void test3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 18, 25);
        userMapper.selectCount(wrapper);
    }

    // 模糊查询：查询名字里面没有a字母的并且以n结尾的
    @Test
    public void test4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name", "a")
                .likeLeft("name", "n");  // 相当于 %n
        userMapper.selectMaps(wrapper);
    }

    // 内嵌子查询：id在子查询中查出来
    @Test
    public void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from user where id < 3");
        userMapper.selectObjs(wrapper);
    }

    // 升序、降序排列：根据id降序排列
    @Test
    public void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        userMapper.selectList(wrapper);
    }





}
