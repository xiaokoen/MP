package com.k2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.k2.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    // Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
    // 我们在这里继承BaseMapper、基础的CRUD，mybatis-plus已经帮我们写好了，直接使用即可
    // mybatis里面，写完接口，还需要写mapper.xml，写sql语句
}
