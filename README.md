### 项目组织结构

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
数据库表名前缀说明：
1. gms：商品管理系统 Goods Manage System 
2. cms：内容管理系统 Content Manage System
3. gcm：商品分类管理 Goods Category Manage
4. mms：商家管理系统 Merchant Manage System
