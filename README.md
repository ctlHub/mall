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

    1. gms：商品管理系统 Goods Manage System 

    2. cms：内容管理系统 Content Manage System

    3. gcm：商品分类管理 Goods Category Manage

    4. mms：商家管理系统 Merchant Manage System

2. ####  设计公约

    1. 每张表都应该有`create_user`,`create_date`,`update_user`,`update_date`字段
    2. 每张表都应当有 `deleted`(unsigned tinyint) 字段，标识逻辑删除；`version`字段，表示数据被修改的次数，当数据被修改时，version值会加一，用于乐观锁优化锁性能，这三个字段皆可配合[MybatisPlus](http://mybatis.plus/)插件使用，[详情](https://zhuanlan.zhihu.com/p/156135323)
    3. 根据mysql 8.0 的官方建议，int字段不再指定长度
    4. 小数类型为 decimal，禁止使用 float 和 double
    5. 不涉及到负数的数字类型字段请使用unsigned