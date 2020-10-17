create table if not exists cms_index_carousel
(
    uid_         int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_     varchar(10)       not null comment '帐套代码',
    img_code_    varchar(30)       not null comment '图片编号',
    device_      tinyint default 0 null comment '设备UI，pc/phone',
    img_url_     varchar(255)      not null comment '图片地址',
    app_user_    varchar(10)       not null comment '创建人',
    app_date_    datetime          not null comment '创建时间',
    update_user_ varchar(10)       not null comment '更新人',
    update_date_ datetime          not null comment '更新时间'
)
    comment '首页滑动切换图';

create table if not exists cms_index_sales_ad
(
    uid_          int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_      varchar(10)  not null comment '帐套代码',
    sales_status_ int          not null comment '促销类别',
    img_url_      varchar(255) not null comment '首页促销广告图地址',
    app_user_     varchar(10)  not null comment '创建人',
    app_date_     datetime     not null comment '创建时间',
    update_user_  varchar(10)  not null comment '更新人',
    update_date_  datetime     not null comment '更新时间'
)
    comment '首页标签广告图表';

create index uk
    on cms_index_sales_ad (corp_no_, sales_status_);

create table if not exists cms_notice
(
    uid_         bigint(11) unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_     varchar(10)   not null comment '公司别',
    title_       varchar(50)   not null comment '新闻标题',
    value_       text          not null comment '新闻内容',
    status_      int           not null comment '新闻状态（0正常、1下架、2置顶）',
    news_url_    varchar(255)  not null comment '新闻图片',
    read_sum_    int default 0 not null comment '阅读数',
    remark_      varchar(255)  null comment '备注',
    app_user_    varchar(10)   not null comment '创建人',
    app_date_    datetime      not null comment '创建时间',
    update_user_ varchar(10)   not null comment '更新人',
    update_date_ datetime      not null comment '更新时间',
    constraint cms_notice_corp_no_title_uindex
        unique (corp_no_, title_)
)
    comment '新闻公告表';

create table if not exists gcm_category
(
    uid_               bigint unsigned auto_increment
        primary key,
    industry_code_     varchar(30)  not null comment '行业代码',
    code_              varchar(30)  not null comment '分类编号',
    name_              varchar(255) not null comment '分类名称',
    diteng_class_code_ varchar(30)  null comment '地藤大类代码',
    app_user_          varchar(10)  not null comment '创建人',
    app_date_          datetime     not null comment '创建时间',
    update_user_       varchar(10)  not null comment '更新人',
    update_date_       datetime     not null comment '更新时间',
    constraint gcm_category_diteng_class_code__uindex
        unique (diteng_class_code_),
    constraint gcm_category_industry_code__code__uindex
        unique (industry_code_, code_)
)
    comment '商品分类管理--商品分类表';

create table if not exists gcm_category_attribute
(
    uid_           bigint unsigned auto_increment
        primary key,
    category_code_ varchar(30)             not null comment '分类code',
    code_          varchar(30)             not null comment '属性code',
    name_          varchar(50)             not null comment '属性的名称',
    remark_        varchar(255) default '' null,
    app_user_      varchar(10)             not null comment '创建人',
    app_date_      datetime                not null comment '创建时间',
    update_user_   varchar(10)             not null comment '更新人',
    update_date_   datetime                not null comment '更新时间',
    constraint gcm_category_attribute_category_code__name__uindex
        unique (category_code_, name_),
    constraint uk_category_attr
        unique (category_code_, code_)
)
    comment '商品分类属性表';

create table if not exists gcm_industry
(
    uid_         bigint unsigned auto_increment
        primary key,
    code_        varchar(30) not null comment '行业code',
    name_        varchar(50) not null comment '行业名称',
    app_user_    varchar(10) not null comment '创建人',
    app_date_    datetime    not null comment '创建时间',
    update_user_ varchar(10) not null comment '更新人',
    update_date_ datetime    not null comment '更新时间',
    constraint gcm_industry_code__uindex
        unique (code_),
    constraint gcm_industry_name__uindex
        unique (name_)
)
    comment '行业基础表';

create table if not exists gms_goods
(
    uid_                  int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_              varchar(10)                         not null comment '帐套代码',
    code_                 varchar(18)                         not null comment '料号',
    old_code_             varchar(30)                         null comment '旧料号',
    brand_                varchar(30)                         not null comment '品牌',
    class1_               varchar(30)                         not null comment '大类',
    class2_               varchar(30)      default ' '        not null comment '中类',
    class3_               varchar(30)      default ' '        not null comment '系列',
    desc_                 varchar(100)                        not null comment '品名',
    part_type_            varchar(10)      default ' '        null comment '商品类型',
    py_code_              varchar(201)                        null comment '拼音速查码',
    spec_                 varchar(200)                        null comment '规格',
    unit_                 varchar(4)                          not null comment '单位',
    cw_code_              varchar(10)                         null comment '存放位置',
    default_cw_           varchar(30)                         null comment '默认储位',
    in_up_                decimal(18, 4)                      not null comment '进货价',
    out_up_               decimal(18, 4)                      not null comment '出厂价',
    out_up2_              decimal(18, 4)                      not null comment '批发价',
    list_up_              decimal(18, 4)                      not null comment '零售价',
    cost_up_              decimal(18, 4)   default 0.0000     null comment '成本单价',
    vip_up_               decimal(18, 4)                      not null comment '会员价',
    vip_discount_         decimal(18, 6)   default 1.000000   not null comment '会员折扣率',
    up_control_           int                                 not null comment '单价控制',
    used_                 int              default 0          not null comment '使用状态',
    obj_type_             varchar(30)      default '''1003''' not null comment '资源类别码',
    share_rate_           decimal(18, 4)   default 0.0000     not null comment '库存分享量',
    id_code_              varchar(18)                         null comment '内部条码',
    box_code_             varchar(18)                         null comment '外箱条码',
    box_unit_             varchar(4)       default '箱'        not null comment '包装单位',
    box_num_              decimal(18, 6)   default 1.000000   not null comment '单位包装量',
    barcode_              varchar(18)                         null comment '商品条码',
    old_barcode_          varchar(18)                         null comment '旧(料号)条码',
    push_month_           int                                 not null comment '上市年月',
    readme_url_           varchar(255)     default ''         null comment '简介网址',
    remark_               varchar(100)                        null comment '备注',
    sup_code_             varchar(10)                         null comment '供应商代码',
    status_               int                                 not null comment '生效状态',
    file_num_             int              default 0          not null comment '文件数目',
    last_sup_code_        varchar(10)                         null comment '最近采购厂商',
    update_user_          varchar(10)                         not null comment '更新人员',
    update_date_          datetime                            not null comment '更新时间',
    app_user_             varchar(10)                         not null comment '建档人员',
    app_date_             datetime                            not null comment '建档时间',
    update_key_           varchar(38)                         not null comment '更新ID',
    allow_discount_       int              default 1          not null comment '是否允许打折',
    model_code_           varchar(20)                         null comment '商品型号',
    bom_level_            int              default 0          not null comment '材料类别',
    part_view_top_        int(11) unsigned default 0          null comment '置顶显示',
    volume_               decimal(18, 6)   default 0.000000   null comment '单位体积',
    weight_               decimal(18, 6)                      null comment '重量',
    sales_status_         int              default 0          null comment '促销类别',
    box_sales_            bit              default b'0'       null comment '整包销售',
    box_purchase_         bit              default b'0'       null comment '整包采购',
    lower_shelf_          bit              default b'0'       null comment '商品下架',
    pur_front_day_        int              default 3          null comment '采购前置天数',
    forbid_pur_           bit              default b'0'       null comment '禁止采购',
    classify_             int              default 0          null comment '商品分类（0、普通商品；1、型号商品；2、子项商品）',
    option_               text                                null comment '商品属性选项',
    marque_               varchar(18)                         null comment '商品型号',
    forecast_count_mrp_   bit              default b'0'       null comment '总预售量参与MRP计算',
    forecast_count_month_ int              default 0          null comment '总预售量计算月份(0.当月1.当月和下月2.当月和下两月3.当月和下三月)',
    se_no_                varchar(20)                         null comment '样品单号',
    is_sync_              bit              default b'0'       null comment '是否同步到钓友汇',
    bom_property_         bit              default b'0'       null comment '材料属性(0.外购1.自制)',
    dept_code_            varchar(28)                         null comment '生产单位',
    cost_amount_          decimal(18, 4)   default 0.0000     null comment '成本金额',
    delivery_cycle_       int                                 null comment '发货周期（天）',
    virtual_stock_        decimal(18, 4)   default 0.0000     null comment '虚拟库存',
    constraint uk
        unique (corp_no_, code_)
)
    comment '商品基本资料表';

create index IX_part_info_3
    on gms_goods (corp_no_, class1_, class2_, class3_);

create table if not exists gms_goods_and_attribute
(
    uid_            bigint unsigned auto_increment
        primary key,
    corp_no_        varchar(10)  not null comment '帐套代码',
    goods_code_     varchar(30)  not null comment '商品code',
    attribute_code_ varchar(30)  not null comment '属性code',
    value_          varchar(255) null comment '规格、属性的值，当有多个规格时以逗号隔开',
    app_user_       varchar(10)  not null comment '创建人',
    app_date_       datetime     not null comment '创建时间',
    update_user_    varchar(10)  not null comment '更新人',
    update_date_    datetime     not null comment '更新时间',
    constraint uk_corp_goods_attr
        unique (corp_no_, goods_code_, attribute_code_)
)
    comment '商品与属性值表';

create table if not exists gms_goods_and_eshop
(
    uid_             int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_         varchar(10)             not null comment '账套代码',
    goods_code_      varchar(18)             not null comment '商品料号',
    status_          int(3)                  not null comment '启用状态',
    eshop_type_      int                     not null comment '电商平台类型',
    eshop_name_      varchar(30)             not null comment '电商平台名称',
    eshop_goods_url_ varchar(255) default '' not null comment '商品在电商平台的链接',
    app_user_        varchar(10)             not null comment '创建人',
    app_date_        datetime                not null comment '创建时间',
    update_user_     varchar(10)             not null comment '更新人',
    update_date_     datetime                not null comment '更新时间',
    constraint gms_goods_and_eshop_corp_no_goods_code_eshop_type_uindex
        unique (corp_no_, goods_code_, eshop_type_)
)
    comment '商品与电商平台链接关联表';

create index idx_goodsAndEshop
    on gms_goods_and_eshop (corp_no_, goods_code_, eshop_type_);

create table if not exists gms_goods_and_tag
(
    uid_         int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_     varchar(10) not null comment '账套代码',
    goods_code_  varchar(18) not null comment '商品料号',
    tag_code_    varchar(30) not null comment '标签代码',
    app_user_    varchar(10) not null comment '创建人',
    app_date_    datetime    not null comment '创建时间',
    update_user_ varchar(10) not null comment '更新人',
    update_date_ datetime    not null comment '更新时间'
)
    comment '商品标签关联表';

create index idx_corpAndGoods
    on gms_goods_and_tag (corp_no_, goods_code_);

create index idx_corpAndTagCode
    on gms_goods_and_tag (corp_no_, tag_code_);

create table if not exists gms_goods_bind
(
    uid_                  int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_              varchar(10) not null comment '账套代码',
    primary_goods_code_   varchar(18) not null comment '主商品料号',
    secondary_goods_code_ varchar(18) not null comment '次商品料号',
    app_user_             varchar(10) not null comment '创建人',
    app_date_             datetime    not null comment '创建时间',
    update_user_          varchar(10) not null comment '更新人',
    update_date_          datetime    not null comment '更新时间',
    constraint gms_goods_bind_primary_goods_code_secondary_goods_code_uindex
        unique (primary_goods_code_, secondary_goods_code_)
)
    comment '商品关联表（配件、关联商品）';

create index idx_corpAndPrimary
    on gms_goods_bind (corp_no_, primary_goods_code_);

create index idx_corpAndSecondary
    on gms_goods_bind (corp_no_, secondary_goods_code_);

create table if not exists gms_goods_description
(
    uid_         int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_     varchar(10)            not null comment '账套代码',
    goods_code_  varchar(18)            not null comment '商品料号',
    code_        varchar(30)            not null comment 'Description唯一id',
    status_      int(3)                 not null comment '启用状态',
    title_       varchar(30) default '' null comment '说明标题',
    content_     text                   null comment '内容',
    app_user_    varchar(10)            not null comment '创建人',
    app_date_    datetime               not null comment '创建时间',
    update_user_ varchar(10)            not null comment '更新人',
    update_date_ datetime               not null comment '更新时间'
)
    comment '商品说明表';

create index idx_goods
    on gms_goods_description (corp_no_, goods_code_);

create table if not exists gms_tag
(
    uid_         int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_     varchar(10)             not null comment '企业编号',
    code_        varchar(30)             not null comment '标签代码（雪花Long）',
    name_        varchar(20)             not null comment '标签名称',
    type_        varchar(20)  default '' null comment '标签类型(选大类)',
    remark_      varchar(100) default '' null comment '备注',
    app_user_    varchar(10)             not null comment '创建人',
    app_date_    datetime                not null comment '创建时间',
    update_user_ varchar(10)             not null comment '更新人',
    update_date_ datetime                not null comment '更新时间',
    constraint uk
        unique (corp_no_, code_)
)
    comment '商品标签表';

create table if not exists mms_merchant
(
    uid_           int unsigned auto_increment comment '主键UID'
        primary key,
    corp_no_       varchar(10)  not null comment '帐套代码',
    name_          varchar(80)  not null comment '商家名称',
    status_        int          not null comment '状态',
    industry_code_ varchar(30)  null comment '行业代码',
    logo_          varchar(255) null comment '页面上的logo',
    phone_icon_    varchar(255) null comment '手机版选择商家图标',
    pc_icon_       varchar(255) null comment '电脑版选择商家图标',
    app_user_      varchar(10)  not null comment '创建人',
    app_date_      datetime     not null comment '创建时间',
    update_user_   varchar(10)  not null comment '更新人',
    update_date_   datetime     not null comment '更新时间',
    constraint uk
        unique (corp_no_)
)
    comment '商家表';

