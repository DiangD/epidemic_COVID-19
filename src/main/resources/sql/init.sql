/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : epidemic_ncov

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 07/08/2020 12:27:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city_info
-- ----------------------------
DROP TABLE IF EXISTS `city_info`;
CREATE TABLE `city_info`
(
    `locationId`            int(11)                                                 NOT NULL,
    `cityName`              varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `confirmedCount`        int(11)                                                 NULL DEFAULT NULL,
    `suspectedCount`        int(11)                                                 NULL DEFAULT NULL,
    `curedCount`            int(11)                                                 NULL DEFAULT NULL,
    `deadCount`             int(11)                                                 NULL DEFAULT NULL,
    `modifyTime`            timestamp(0)                                            NULL DEFAULT CURRENT_TIMESTAMP,
    `provinceId`            int(11)                                                 NOT NULL,
    `currentConfirmedCount` int(11)                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`locationId`) USING BTREE,
    INDEX `index_city_info` (`provinceId`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for country_info
-- ----------------------------
DROP TABLE IF EXISTS `country_info`;
CREATE TABLE `country_info`
(
    `locationId`            int(11)                                                 NOT NULL,
    `provinceName`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `provinceShortName`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `currentConfirmedCount` int(11)                                                 NULL DEFAULT NULL,
    `confirmedCount`        int(11)                                                 NULL DEFAULT NULL,
    `suspectedCount`        int(11)                                                 NULL DEFAULT NULL,
    `curedCount`            int(11)                                                 NULL DEFAULT NULL,
    `deadCount`             int(11)                                                 NULL DEFAULT NULL,
    `modifyTime`            bigint(20)                                              NULL DEFAULT NULL,
    `createTime`            bigint(20)                                              NULL DEFAULT NULL,
    `countryShortCode`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `countryType`           int(2)                                                  NULL DEFAULT NULL,
    `continents`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`locationId`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for global_statistics
-- ----------------------------
DROP TABLE IF EXISTS `global_statistics`;
CREATE TABLE `global_statistics`
(
    `id`                    int(11) NOT NULL,
    `confirmedCount`        int(11) NULL DEFAULT NULL,
    `curedCount`            int(11) NULL DEFAULT NULL,
    `deadCount`             int(11) NULL DEFAULT NULL,
    `confirmedIncr`         int(11) NULL DEFAULT NULL,
    `curedIncr`             int(11) NULL DEFAULT NULL,
    `deadIncr`              int(11) NULL DEFAULT NULL,
    `currentConfirmedCount` int(11) NULL DEFAULT NULL,
    `currentConfirmedIncr`  int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for province_info
-- ----------------------------
DROP TABLE IF EXISTS `province_info`;
CREATE TABLE `province_info`
(
    `locationId`            int(11)                                                 NOT NULL,
    `provinceShortName`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `currentConfirmedCount` int(11)                                                 NULL DEFAULT NULL,
    `confirmedCount`        int(11)                                                 NULL DEFAULT NULL,
    `suspectedCount`        int(11)                                                 NULL DEFAULT NULL,
    `curedCount`            int(11)                                                 NULL DEFAULT NULL,
    `deadCount`             int(11)                                                 NULL DEFAULT NULL,
    `comment`               varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `statisticsData`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `modifyTime`            timestamp(0)                                            NULL DEFAULT CURRENT_TIMESTAMP,
    `provinceName`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`locationId`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for statistic
-- ----------------------------
DROP TABLE IF EXISTS `statistic`;
CREATE TABLE `statistic`
(
    `id`                    int(11)    NOT NULL,
    `createTime`            bigint(20) NULL DEFAULT NULL,
    `modifyTime`            bigint(20) NULL DEFAULT NULL,
    `confirmedCount`        int(11)    NULL DEFAULT NULL,
    `suspectedCount`        int(11)    NULL DEFAULT NULL,
    `curedCount`            int(11)    NULL DEFAULT NULL,
    `deadCount`             int(11)    NULL DEFAULT NULL,
    `seriousCount`          int(11)    NULL DEFAULT NULL,
    `suspectedIncr`         int(11)    NULL DEFAULT NULL,
    `confirmedIncr`         int(11)    NULL DEFAULT NULL,
    `curedIncr`             int(11)    NULL DEFAULT NULL,
    `deadIncr`              int(11)    NULL DEFAULT NULL,
    `seriousIncr`           int(11)    NULL DEFAULT NULL,
    `currentConfirmedCount` int(11)    NULL DEFAULT NULL,
    `currentConfirmedIncr`  int(11)    NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for statistic_data
-- ----------------------------
DROP TABLE IF EXISTS `statistic_data`;
CREATE TABLE `statistic_data`
(
    `id`                    int(11) NOT NULL AUTO_INCREMENT,
    `confirmedCount`        int(11) NULL DEFAULT NULL,
    `confirmedIncr`         int(11) NULL DEFAULT NULL,
    `curedCount`            int(11) NULL DEFAULT NULL,
    `curedIncr`             int(11) NULL DEFAULT NULL,
    `currentConfirmedCount` int(11) NULL DEFAULT NULL,
    `currentConfirmedIncr`  int(11) NULL DEFAULT NULL,
    `dateId`                int(11) NULL DEFAULT NULL,
    `deadCount`             int(11) NULL DEFAULT NULL,
    `deadIncr`              int(11) NULL DEFAULT NULL,
    `provinceId`            int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `index_statistic_data` (`provinceId`, `dateId`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 9544
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for timeline
-- ----------------------------
DROP TABLE IF EXISTS `timeline`;
CREATE TABLE `timeline`
(
    `id`         int(11)                                                 NOT NULL,
    `pubDate`    bigint(20)                                              NULL DEFAULT NULL,
    `pubDateStr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `title`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `summary`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `infoSource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `sourceUrl`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `provinceId` int(11)                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `index_timeline_pubDate` (`pubDate`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for timeline_limit120
-- ----------------------------
DROP VIEW IF EXISTS `timeline_limit120`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `timeline_limit120` AS
select `timeline`.`id`         AS `id`,
       `timeline`.`pubDate`    AS `pubDate`,
       `timeline`.`pubDateStr` AS `pubDateStr`,
       `timeline`.`title`      AS `title`,
       `timeline`.`summary`    AS `summary`,
       `timeline`.`infoSource` AS `infoSource`,
       `timeline`.`sourceUrl`  AS `sourceUrl`,
       `timeline`.`provinceId` AS `provinceId`
from `timeline`
order by `timeline`.`pubDate` desc
limit 120;

SET FOREIGN_KEY_CHECKS = 1;
