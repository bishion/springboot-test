# springboot-test
Spring Boot 单测学习
## 依赖信息
- spring cloud Edgware.SR5, 原则上之前版本都支持
- 使用了 H2 内存型数据库
- mybatis-spring-boot-starter 1.3.3 版本
- 使用了 spring cloud config, 如果懒得搭服务端, 给个默认值就行
- mybatis-spring-boot-starter-test

## 一些坑
1. 如果使用了 mybatis, main 方法所在的类不能有 @MapperScan 注解, 换个地方放就好
2. 如果需要用 mybatis 的单测数据库, 那么需要在 resources 目录下创建 schema.sql, 里面放建表语句
3. 