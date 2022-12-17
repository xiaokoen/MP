package com.k2;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.k2.mapper.UserMapper;
import com.k2.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlus01HelloApplicationTests {

    // 继承了BaseMapper，所有的方法都来自父类
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        // 参数是Wrapper，条件构造器
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 插入数据
     */
    @Test
    public void insertUser(){
        User user = new User();
        user.setName("koen");
        user.setAge(18);
        user.setEmail("1034174907@qq.com");

        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        // 通过条件，自动调节动态sql
        user.setId(1597608667711131654L);
        user.setName("xiaokoen");
        user.setAge(16);
        // 调用的参数虽然是updateById，但是参数是一个对象
        userMapper.updateById(user);
    }

    // 模拟乐观锁成功状态
    @Test
    public void testLock(){
        User user = userMapper.selectById(1L);
        user.setName("koen小");
        user.setEmail("k2study@163.com");
        userMapper.updateById(user);
    }

    // 模拟乐观锁失败状态
    @Test
    public void testLock2(){
        // 线程 1
        User user = userMapper.selectById(1L);
        user.setName("koen小111");
        user.setEmail("k2study@163.com");
        // 模拟线程 2 突然来了，线程1user获取到了，但是还没有修改
        User user1 = userMapper.selectById(1L);
        user1.setName("koen小222");
        user1.setEmail("k2study@163.com");
        userMapper.updateById(user1);
        //自旋锁来多次尝试提交（JUC里面学）
        userMapper.updateById(user);    // 如果没有乐观锁就会覆盖插队线程的值
    }

    // 通过id查询用户
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    // 查询批量id
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 多条件查询之一：使用map
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        // 自定义查询
        map.put("name", "xiaokoen");
        map.put("age",16);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页查询
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<User> page = new Page<>(2,5);
        page.getPages();        // 获取总页数
        page.getTotal();        // 获取数据总数
        page.getCurrent();      // 当前第几页
        page.getRecords();      // 获取分页后的数据
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
    }

    // 根据id删除记录
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1L);
    }

    // 根据id批量删除
    @Test
    public void testDeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(1597608667711131651L,1597608667711131653L,1597608667711131652L));
    }

    // 通过map删除
    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","xiaokoen");
        userMapper.deleteByMap(map);
    }


}
