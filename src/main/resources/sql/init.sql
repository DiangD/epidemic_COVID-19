# 数据库：MySQL
# 版本：8.0


drop table if exists `province_info`;
# 省份信息表
create table `province_info`
(
    `locationId`            int(11)      not null,
    `provinceName`          varchar(255) null default null,
    `provinceShortName`     varchar(255) null default null,
    `currentConfirmedCount` int(11)      null default null,
    `confirmedCount`        int(11)      null default null,
    `suspectedCount`        int(11)      null default null,
    `curedCount`            int(11)      null default null,
    `deadCount`             int(11)      null default null,
    `comment`               varchar(255) null default null,
    `statisticsData`        varchar(255) null default null,
    `modifyTime`            timestamp    null default now(),
    primary key (`locationId`) using btree
) engine = InnoDB
  default charset = utf8;

drop table if exists `city_info`;
# 城市信息表
create table `city_info`
(
    `locationId`     int(11)      not null,
    `cityName`       varchar(255) null default null,
    `confirmedCount` int(11)      null default null,
    `suspectedCount` int(11)      null default null,
    `curedCount`     int(11)      null default null,
    `deadCount`      int(11)      null default null,
    `modifyTime`     timestamp    null default now(),
    `provinceId`     int(11)      not null,
    primary key (`locationId`) using btree

) engine = InnoDB
  default charset = utf8;

drop table if exists `statistic_data`;
create table `statistic_data`
(
    `id`                    int(11) not null auto_increment,
    `confirmedCount`        int(11) null default null,
    `confirmedIncr`         int(11) null default null,
    `curedCount`            int(11) null default null,
    `curedIncr`             int(11) null default null,
    `currentConfirmedCount` int(11) null default null,
    `currentConfirmedIncr`  int(11) null default null,
    `dateId`                int(11) null default null,
    `deadCount`             int(11) null default null,
    `deadIncr`              int(11) null default null,
    `provinceId`            int(11) null default null,
    primary key (`id`) using btree
) engine = InnoDB
  default charset = utf8;


# 统计信息
drop table if exists `statistic`;
create table `statistic`
(
    id                    int(11)    not null,
    createTime            bigint(20) null default null,
    modifyTime            bigint(20) null default null,
    confirmedCount        int(11)    null default null,
    suspectedCount        int(11)    null default null,
    curedCount            int(11)    null default null,
    deadCount             int(11)    null default null,
    seriousCount          int(11)    null default null,
    suspectedIncr         int(11)    null default null,
    confirmedIncr         int(11)    null default null,
    curedIncr             int(11)    null default null,
    deadIncr              int(11)    null default null,
    seriousIncr           int(11)    null default null,
    currentConfirmedCount int(11)    null default null,
    currentConfirmedIncr  int(11)    null default null,
    primary key (`id`) using btree

) engine = InnoDB
  default charset = utf8;

drop table  if exists `global_statistics`;
create table `global_statistics`
(
    id                    int(11) not null,
    confirmedCount        int(11) null default null,
    curedCount            int(11) null default null,
    deadCount             int(11) null default null,
    confirmedIncr         int(11) null default null,
    curedIncr             int(11) null default null,
    deadIncr              int(11) null default null,
    currentConfirmedCount int(11) null default null,
    currentConfirmedIncr  int(11) null default null,
    primary key (`id`) using btree
) engine = InnoDB
  default charset = utf8 ;

# 时间线
drop table  if exists `timeline`;
create table timeline
(
    id               int          not null,
    pubDate          bigint          null,
    pubDateStr       varchar(255) null,
    title            varchar(255) null,
    summary          varchar(255) null,
    infoSource       varchar(255) null,
    sourceUrl        varchar(255) null,
    provinceId       int          null,
    primary key (`id`) using btree
)engine = InnoDB
 default charset = utf8;


drop table if exists `country_info`;
create table `country_info`
(
    `locationId`            int(11)      not null,
    `provinceName`          varchar(255) null default null,
    `provinceShortName`     varchar(255) null default null,
    `currentConfirmedCount` int(11)      null default null,
    `confirmedCount`        int(11)      null default null,
    `suspectedCount`        int(11)      null default null,
    `curedCount`            int(11)      null default null,
    `deadCount`             int(11)      null default null,
    `modifyTime`            bigint(20)   null default null,
    `createTime`            bigint(20)   null default null,
    `countryShortCode`      varchar(255) null default null,
    `countryType`           int(2)      null default null,
    `continents`            varchar(255) null default null,
    primary key (`locationId`) using btree
)engine = InnoDB
 default charset = utf8;
