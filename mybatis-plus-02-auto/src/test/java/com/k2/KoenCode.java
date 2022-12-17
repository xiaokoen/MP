package com.k2;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

// 代码生成器
public class KoenCode {

    public static void main(String[] args) {

        String url = "jdbc:p6spy:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&useSSL=false&useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        FastAutoGenerator.create(url, username, password)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("xiaokoen") // 设置作者
                            .outputDir(projectPath + "/mybatis-plus-02-auto/src/main/java/") // 指定输出目录
                            .enableSwagger() // 开启 swagger2 模式
                            .fileOverride() // 覆盖已生成文件(默认为false)
                            .disableOpenDir()       // 禁止打开输出目录，默认为true
                            .dateType(DateType.ONLY_DATE)   // 时间策略（默认DateType.TIME_PACK）
                            .commentDate("yyyy-MM-dd")       // 注释日期（默认值: yyyy-MM-dd）
                    ;
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.k2") // 设置父包名
                            .moduleName("blog") // 设置父包模块名
                            .entity("pojo")
                            .mapper("mapper")
                            .service("service")
//                            .serviceImpl("service.impl")  // 默认
                            .controller("controller")
//                            .xml("mapper.xml")        // 默认
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/mybatis-plus-02-auto/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("user")      // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")// 设置过滤表前缀
                            // 实体类策略
                            .entityBuilder()
                            .enableLombok()         // 开启lombok
                            .enableTableFieldAnnotation()   // 开启生成实体时，生成字段注解
                            .naming(NamingStrategy.underline_to_camel)      // 下划线转驼峰命(默认)
                            .columnNaming(NamingStrategy.underline_to_camel)        // 下划线转驼峰命
                            // 乐观锁
                            .versionColumnName("version")        // 乐观锁字段名(数据库)
                            .versionPropertyName("version")      // 乐观锁属性名(实体)
                            // 逻辑删除
                            .logicDeleteColumnName("deleted")    // 逻辑删除字段名(数据库)
                            .logicDeletePropertyName("deleted")   // 逻辑删除属性名(实体)
                            // 自动填充配置
                            .addTableFills(new Column("create_time", FieldFill.INSERT), new Column("update_time", FieldFill.INSERT_UPDATE))
//                            .addTableFills(new Property("create_time",FieldFill.INSERT),new Property("update_time",FieldFill.INSERT_UPDATE))
//                            .formatFileName("%sEntity")         // 格式化文件名称
                            .idType(IdType.AUTO)       // 全局主键类型
                            // service 策略
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            // controller 策略
                            .controllerBuilder()
                            .enableHyphenStyle()        // 开启驼峰转连字符
                            .enableRestStyle()          // 开启生成@RestController 控制器
                    ;
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
