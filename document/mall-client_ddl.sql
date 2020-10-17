create table if not exists cms_index_carousel
(
    id          varchar(30)       not null comment '图片编号ID'
        primary key,
    merchant_id varchar(10)       not null comment '帐套代码',
    device      tinyint default 0 null comment '设备UI，pc/phone',
    img_url     varchar(255)      not null comment '图片地址',
    app_user    varchar(10)       not null comment '创建人',
    app_date    datetime          not null comment '创建时间',
    update_user varchar(10)       not null comment '更新人',
    update_date datetime          not null comment '更新时间'
)
    comment '首页滑动切换图';

create table if not exists cms_index_sales_ad
(
    id           varchar(30)  not null comment '广告图ID'
        primary key,
    merchant_id  varchar(10)  not null comment '帐套代码',
    sales_status int          not null comment '促销类别',
    img_url      varchar(255) not null comment '首页促销广告图地址',
    app_user     varchar(10)  not null comment '创建人',
    app_date     datetime     not null comment '创建时间',
    update_user  varchar(10)  not null comment '更新人',
    update_date  datetime     not null comment '更新时间'
)
    comment '首页标签广告图表';

create index uk
    on cms_index_sales_ad (merchant_id, sales_status);

create table if not exists cms_notice
(
    id          varchar(30)   not null comment '公告主键id'
        primary key,
    merchant_id varchar(10)   not null comment '公司别',
    title       varchar(50)   not null comment '公告标题',
    value       text          not null comment '公告内容',
    status      int           not null comment '公告状态（0正常、1下架、2置顶）',
    news_url    varchar(255)  not null comment '公告图片',
    read_sum    int default 0 not null comment '阅读数',
    remark      varchar(255)  null comment '备注',
    app_user    varchar(10)   not null comment '创建人',
    app_date    datetime      not null comment '创建时间',
    update_user varchar(10)   not null comment '更新人',
    update_date datetime      not null comment '更新时间',
    constraint cms_notice_merchant_id_title_uindex
        unique (merchant_id, title)
)
    comment '公告表';

create table if not exists gcm_category
(
    id          varchar(30)  not null
        primary key comment '分类编号',
    name        varchar(255) not null comment '分类名称',
    app_user    varchar(10)  not null comment '创建人',
    app_date    datetime     not null comment '创建时间',
    update_user varchar(10)  not null comment '更新人',
    update_date datetime     not null comment '更新时间',
    constraint gcm_category_name_uindex
        unique (name)
)
    comment '商品分类管理--商品分类表';



create table if not exists gcm_category_attribute
(
    id          varchar(30)             not null
        primary key comment '属性id ',
    category_id varchar(30)             not null comment '分类id ',
    name        varchar(50)             not null comment '属性的名称',
    remark      varchar(255) default '' null,
    app_user    varchar(10)             not null comment '创建人',
    app_date    datetime                not null comment '创建时间',
    update_user varchar(10)             not null comment '更新人',
    update_date datetime                not null comment '更新时间',
    constraint gcm_category_attribute_category_id__name__uindex
        unique (category_id, name)
)
    comment '商品分类属性表';

create table if not exists gcm_industry
(
    id          varchar(30) not null
        primary key comment '行业id ',
    name        varchar(50) not null comment '行业名称',
    app_user    varchar(10) not null comment '创建人',
    app_date    datetime    not null comment '创建时间',
    update_user varchar(10) not null comment '更新人',
    update_date datetime    not null comment '更新时间',
    constraint gcm_industry_name__uindex
        unique (name)
)
    comment '行业基础表';

create table if not exists gms_goods
(
    id                   varchar(30)                       not null
        primary key comment '商品编号',
    merchant_id          varchar(10)                       not null comment '帐套代码',
    old_id               varchar(30)                       null comment '旧料号',
    brand                varchar(30)                       not null comment '品牌',
    class1               varchar(30)                       not null comment '大类',
    class2               varchar(30)    default ' '        not null comment '中类',
    class3               varchar(30)    default ' '        not null comment '系列',
    description          varchar(100)                      not null comment '品名',
    part_type            varchar(10)    default ' '        null comment '商品类型',
    py_id                varchar(201)                      null comment '拼音速查码',
    spec                 varchar(200)                      null comment '规格',
    unit                 varchar(4)                        not null comment '单位',
    cw_id                varchar(10)                       null comment '存放位置',
    default_cw           varchar(30)                       null comment '默认储位',
    in_up                decimal(18, 4)                    not null comment '进货价',
    out_up               decimal(18, 4)                    not null comment '出厂价',
    out_up2              decimal(18, 4)                    not null comment '批发价',
    list_up              decimal(18, 4)                    not null comment '零售价',
    cost_up              decimal(18, 4) default 0.0000     null comment '成本单价',
    vip_up               decimal(18, 4)                    not null comment '会员价',
    vip_discount         decimal(18, 6) default 1.000000   not null comment '会员折扣率',
    up_control           int                               not null comment '单价控制',
    used                 int            default 0          not null comment '使用状态',
    obj_type             varchar(30)    default '''1003''' not null comment '资源类别码',
    share_rate           decimal(18, 4) default 0.0000     not null comment '库存分享量',
    id_id                varchar(18)                       null comment '内部条码',
    box_id               varchar(18)                       null comment '外箱条码',
    box_unit             varchar(4)     default '箱'        not null comment '包装单位',
    box_num              decimal(18, 6) default 1.000000   not null comment '单位包装量',
    barid                varchar(18)                       null comment '商品条码',
    old_barid            varchar(18)                       null comment '旧(料号)条码',
    push_month           int                               not null comment '上市年月',
    readme_url           varchar(255)   default ''         null comment '简介网址',
    remark               varchar(100)                      null comment '备注',
    sup_id               varchar(10)                       null comment '供应商代码',
    status               int                               not null comment '生效状态',
    file_num             int            default 0          not null comment '文件数目',
    last_sup_id          varchar(10)                       null comment '最近采购厂商',
    update_user          varchar(10)                       not null comment '更新人员',
    update_date          datetime                          not null comment '更新时间',
    app_user             varchar(10)                       not null comment '建档人员',
    app_date             datetime                          not null comment '建档时间',
    update_key           varchar(38)                       not null comment '更新ID',
    allow_discount       int            default 1          not null comment '是否允许打折',
    model_id             varchar(20)                       null comment '商品型号',
    bom_level            int            default 0          not null comment '材料类别',
    part_view_top        int unsigned   default 0          null comment '置顶显示',
    volume               decimal(18, 6) default 0.000000   null comment '单位体积',
    weight               decimal(18, 6)                    null comment '重量',
    sales_status         int            default 0          null comment '促销类别',
    box_sales            bit            default b'0'       null comment '整包销售',
    box_purchase         bit            default b'0'       null comment '整包采购',
    lower_shelf          bit            default b'0'       null comment '商品下架',
    pur_front_day        int            default 3          null comment '采购前置天数',
    forbid_pur           bit            default b'0'       null comment '禁止采购',
    classify             int            default 0          null comment '商品分类（0、普通商品；1、型号商品；2、子项商品）',
    optional             text                              null comment '商品属性选项',
    marque               varchar(18)                       null comment '商品型号',
    forecast_count_mrp   bit            default b'0'       null comment '总预售量参与MRP计算',
    forecast_count_month int            default 0          null comment '总预售量计算月份(0.当月1.当月和下月2.当月和下两月3.当月和下三月)',
    se_no                varchar(20)                       null comment '样品单号',
    is_sync              bit            default b'0'       null comment '是否同步到钓友汇',
    bom_property         bit            default b'0'       null comment '材料属性(0.外购1.自制)',
    dept_id              varchar(28)                       null comment '生产单位',
    cost_amount          decimal(18, 4) default 0.0000     null comment '成本金额',
    delivery_cycle       int                               null comment '发货周期（天）',
    virtual_stock        decimal(18, 4) default 0.0000     null comment '虚拟库存'
)
    comment '商品基本资料表';

create index IX_part_info_3
    on gms_goods (merchant_id, class1, class2, class3);

create table if not exists gms_goods_and_attribute
(
    id           varchar(30)  not null
        primary key,
    merchant_id  varchar(10)  not null comment '帐套代码',
    goods_id     varchar(30)  not null comment '商品id ',
    attribute_id varchar(30)  not null comment '属性id ',
    value        varchar(255) null comment '规格、属性的值，当有多个规格时以逗号隔开',
    app_user     varchar(10)  not null comment '创建人',
    app_date     datetime     not null comment '创建时间',
    update_user  varchar(10)  not null comment '更新人',
    update_date  datetime     not null comment '更新时间',
    constraint uk_corp_goods_attr
        unique (merchant_id, goods_id, attribute_id)
)
    comment '商品与属性值表';

create table if not exists gms_goods_and_eshop
(
    id              varchar(30)             not null
        primary key,
    merchant_id     varchar(10)             not null comment '账套代码',
    goods_id        varchar(18)             not null comment '商品料号',
    status          int(3)                  not null comment '启用状态',
    eshop_type      int                     not null comment '电商平台类型',
    eshop_name      varchar(30)             not null comment '电商平台名称',
    eshop_goods_url varchar(255) default '' not null comment '商品在电商平台的链接',
    app_user        varchar(10)             not null comment '创建人',
    app_date        datetime                not null comment '创建时间',
    update_user     varchar(10)             not null comment '更新人',
    update_date     datetime                not null comment '更新时间',
    constraint gms_goods_and_eshop_merchant_id_goods_id_eshop_type_uindex
        unique (merchant_id, goods_id, eshop_type)
)
    comment '商品与电商平台链接关联表';

create index idx_goodsAndEshop
    on gms_goods_and_eshop (merchant_id, goods_id, eshop_type);

create table if not exists gms_goods_and_tag
(
    id          varchar(30) not null
        primary key,
    merchant_id varchar(10) not null comment '账套代码',
    goods_id    varchar(18) not null comment '商品料号',
    tag_id      varchar(30) not null comment '标签代码',
    app_user    varchar(10) not null comment '创建人',
    app_date    datetime    not null comment '创建时间',
    update_user varchar(10) not null comment '更新人',
    update_date datetime    not null comment '更新时间'
)
    comment '商品标签关联表';

create index idx_corpAndGoods
    on gms_goods_and_tag (merchant_id, goods_id);

create index idx_corpAndTagid
    on gms_goods_and_tag (merchant_id, tag_id);

create table if not exists gms_goods_bind
(
    id                 varchar(30) not null
        primary key,
    merchant_id        varchar(10) not null comment '账套代码',
    primary_goods_id   varchar(18) not null comment '主商品料号',
    secondary_goods_id varchar(18) not null comment '次商品料号',
    app_user           varchar(10) not null comment '创建人',
    app_date           datetime    not null comment '创建时间',
    update_user        varchar(10) not null comment '更新人',
    update_date        datetime    not null comment '更新时间',
    constraint gms_goods_bind_primary_goods_id_secondary_goods_id_uindex
        unique (primary_goods_id, secondary_goods_id)
)
    comment '商品关联表（配件、关联商品）';

create index idx_corpAndPrimary
    on gms_goods_bind (merchant_id, primary_goods_id);

create index idx_corpAndSecondary
    on gms_goods_bind (merchant_id, secondary_goods_id);

create table if not exists gms_goods_description
(
    id          varchar(30)            not null
        primary key,
    merchant_id varchar(10)            not null comment '账套代码',
    goods_id    varchar(18)            not null comment '商品料号',
    status      int(3)                 not null comment '启用状态',
    title       varchar(30) default '' null comment '说明标题',
    content     text                   null comment '内容',
    app_user    varchar(10)            not null comment '创建人',
    app_date    datetime               not null comment '创建时间',
    update_user varchar(10)            not null comment '更新人',
    update_date datetime               not null comment '更新时间'
)
    comment '商品说明表';

create index idx_goods
    on gms_goods_description (merchant_id, goods_id);

create table if not exists gms_tag
(
    id          varchar(30)             not null
        primary key comment '标签id',
    merchant_id varchar(10)             not null comment '企业编号',
    name        varchar(20)             not null comment '标签名称',
    type        varchar(20)  default '' null comment '标签类型(选大类)',
    remark      varchar(100) default '' null comment '备注',
    app_user    varchar(10)             not null comment '创建人',
    app_date    datetime                not null comment '创建时间',
    update_user varchar(10)             not null comment '更新人',
    update_date datetime                not null comment '更新时间',
    constraint uk
        unique (merchant_id)
)
    comment '商品标签表';

create table if not exists mms_merchant
(
    id          varchar(30)  not null
        primary key comment '商家id',
    name        varchar(80)  not null comment '商家名称',
    status      int          not null comment '状态',
    industry_id varchar(30)  null comment '行业代码',
    logo        varchar(255) null comment '页面上的logo',
    phone_icon  varchar(255) null comment '手机版选择商家图标',
    pc_icon     varchar(255) null comment '电脑版选择商家图标',
    app_user    varchar(10)  not null comment '创建人',
    app_date    datetime     not null comment '创建时间',
    update_user varchar(10)  not null comment '更新人',
    update_date datetime     not null comment '更新时间'
)
    comment '商家表';

