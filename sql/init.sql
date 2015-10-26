
-- 中文版全球门店
CREATE TABLE `store_cn` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryId` int(11) NOT NULL COMMENT '国家ID',
  `storeName` varchar(200) DEFAULT NULL COMMENT '门店名',
  `address` varchar(400) DEFAULT NULL COMMENT '门店地址',
  `province` varchar(45) DEFAULT NULL COMMENT '省份',
  `zipCode` varchar(15) DEFAULT NULL COMMENT '邮编',
  `phone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `picPath` varchar(100) DEFAULT NULL COMMENT '图片',
  `workTime1` varchar(45) DEFAULT NULL COMMENT '工作时间1， 格式  10:00-21:00',
  `workTime2` varchar(45) DEFAULT NULL COMMENT '工作时间2， 格式  10:00-21:00',
  `workTime3` varchar(45) DEFAULT NULL COMMENT '工作时间3， 格式  10:00-21:00',
  `workTime4` varchar(45) DEFAULT NULL COMMENT '工作时间4， 格式  10:00-21:00',
  `workTime5` varchar(45) DEFAULT NULL COMMENT '工作时间5， 格式  10:00-21:00',
  `workTime6` varchar(45) DEFAULT NULL COMMENT '工作时间6， 格式  10:00-21:00',
  `workTime7` varchar(45) DEFAULT NULL COMMENT '工作时间7， 格式  10:00-21:00',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态 0：正常 9：删除',
  `createUserId` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateUserId` int(11) NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店';


--中文门店视图
CREATE 
    ALGORITHM = MERGE 
    DEFINER = `gd_demo_master`@`%` 
    SQL SECURITY DEFINER
VIEW `v_store_cn` AS
    SELECT 
        `store_cn`.`id` AS `id`,
        `store_cn`.`countryId` AS `countryId`,
        `store_cn`.`storeName` AS `storeName`,
        `store_cn`.`address` AS `address`,
        `store_cn`.`province` AS `province`,
        `store_cn`.`zipCode` AS `zipCode`,
        `store_cn`.`phone` AS `phone`,
        `store_cn`.`picPath` AS `picPath`,
        `store_cn`.`workTime1` AS `workTime1`,
        `store_cn`.`workTime2` AS `workTime2`,
        `store_cn`.`workTime3` AS `workTime3`,
        `store_cn`.`workTime4` AS `workTime4`,
        `store_cn`.`workTime5` AS `workTime5`,
        `store_cn`.`workTime6` AS `workTime6`,
        `store_cn`.`workTime7` AS `workTime7`,
        `store_cn`.`createUserId` AS `createUserId`,
        `store_cn`.`createTime` AS `createTime`,
        `store_cn`.`updateUserId` AS `updateUserId`,
        `store_cn`.`updateTime` AS `updateTime`
    FROM
        `store_cn`
    WHERE
        (`store_cn`.`status` = 0)


-- 英文版全球门店
CREATE TABLE `store_en` (
  `id` int(11) NOT NULL COMMENT '主键',
  `storeName` varchar(200) DEFAULT NULL COMMENT '门店名',
  `address` varchar(400) DEFAULT NULL COMMENT '门店地址',
  `province` varchar(45) DEFAULT NULL COMMENT '省份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店';

--英文门店视图
CREATE 
    ALGORITHM = MERGE 
    DEFINER = `gd_demo_master`@`%` 
    SQL SECURITY DEFINER
VIEW `v_store_en` AS
    SELECT 
        `store_cn`.`id` AS `id`,
        `store_cn`.`countryId` AS `countryId`,
        `store_en`.`storeName` AS `storeName`,
        `store_en`.`address` AS `address`,
        `store_en`.`province` AS `province`,
        `store_cn`.`zipCode` AS `zipCode`,
        `store_cn`.`phone` AS `phone`,
        `store_cn`.`picPath` AS `picPath`,
        `store_cn`.`workTime1` AS `workTime1`,
        `store_cn`.`workTime2` AS `workTime2`,
        `store_cn`.`workTime3` AS `workTime3`,
        `store_cn`.`workTime4` AS `workTime4`,
        `store_cn`.`workTime5` AS `workTime5`,
        `store_cn`.`workTime6` AS `workTime6`,
        `store_cn`.`workTime7` AS `workTime7`,
        `store_cn`.`createUserId` AS `createUserId`,
        `store_cn`.`createTime` AS `createTime`,
        `store_cn`.`updateUserId` AS `updateUserId`,
        `store_cn`.`updateTime` AS `updateTime`
    FROM
        `store_cn` inner join `store_en` on store_cn.id = store_en.id
    WHERE
        (`store_cn`.`status` = 0)