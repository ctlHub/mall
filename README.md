### 一、项目结构

``` lua
mall
├── document -- 存放项目相关文档
├── mall-mbg -- MyBatisGenerator生成的数据库操作代码
├── mall-main -- 商城后端接口
│            ├── controller -- 控制层，负责处理请求
│            ├── config -- 项目配置，例如mybatis,druid,aop,oss等
│            ├── dao -- 数据访问层，数据层不包含任何代码，只有数据库，还有相关的存储过程。
│            │          只操作具体的数据表，存放mybatis的mapper接口，对应的xml映射请存放在resources.dao目录下
│            ├── dto --  Data Transfer Object数据传输对象，主要用于远程调用等需要大量传输对象的地方
│            └── service -- 服务层，又名业务逻辑层（BLL）
└── vue-mall -- 存放前端vue代码
```
### 二、数据库表设计

1. #### 前缀说明：

    1. pms：商品管理系统 Product Manage System 
    2. cms：内容管理系统 Content Manage System
    3. mms：商家管理系统 Merchant Manage System

2. ####  设计公约

    1. 每张表都应该有以下字段
       
       | 字段名称      | 数据类型         | 简述                                                         |
       | ------------- | ---------------- | ------------------------------------------------------------ |
       | `create_user` | varchar          | 创建人员（用户代码）                                         |
       | `create_time` | datetime         | 创建时间                                                     |
       | `update_user` | varchar          | 更新人员（用户代码）                                         |
       | `update_time` | datetime         | 更新时间                                                     |
       | `deleted`     | unsigned tinyint | 标识逻辑删除，1代表被删除，0表示未被删除，默认值0            |
       | `version`     | unsigned int     | 数据被修改的次数，当数据被修改时，version值会+1；用于CAS实现的乐观锁 |
       
       以上三个字段皆可配合[MybatisPlus](http://mybatis.plus/)使用，[详情](https://zhuanlan.zhihu.com/p/156135323)
       
    2. 根据mysql 8.0 的官方建议，int字段不再指定长度
    
    3. 小数类型为 decimal，禁止使用 float 和 double
    
    4. 不涉及到负数的数字类型字段请使用unsigned

### 三、开发工具

1. IDE：idea 配合 jdk11使用，请导入document下的idea-setting.zip配置文件，java开发人员统一代码风格，如后续更改有代码风格的更改，请通知其他成员统一更新配置。另强烈推荐以下idea插件：
   1. Free Mybatis pubgin
   2. JRebel and XRebel for IntelliJ
   3. lombok（必装）
   4. Rainbow Brackets
   5. Save Actions
   6. Alibaba Java Coding Guidelines
2. 数据库可视化连接工具：建议使用IDEA内部集成的Database组件，减少开发时切换软件