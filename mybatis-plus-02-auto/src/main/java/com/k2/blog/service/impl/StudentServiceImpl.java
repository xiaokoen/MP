package com.k2.blog.service.impl;

import com.k2.blog.pojo.StudentEntity;
import com.k2.blog.mapper.StudentMapper;
import com.k2.blog.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaokoen
 * @since 2022-11-30
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements StudentService {

}
