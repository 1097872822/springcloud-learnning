/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : donate

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 05/08/2021 23:01:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `company_address` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `company_linkman` varchar(20) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `company_phone` varchar(20) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_info
-- ----------------------------
INSERT INTO `company_info` VALUES (1, 'rrwjijin', 'rrwjiji', 'wwwwww', '12121212123', '2021-08-04 22:06:03');
INSERT INTO `company_info` VALUES (2, 'www', 'wwww', 'wwww', '21312312321', '2021-08-04 22:08:08');

-- ----------------------------
-- Table structure for donation_info
-- ----------------------------
DROP TABLE IF EXISTS `donation_info`;
CREATE TABLE `donation_info`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `project_id` int(11) NULL DEFAULT NULL,
  `project_name` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `project_desc` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `type` int(2) NULL DEFAULT NULL,
  `donor` varchar(20) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for donation_project
-- ----------------------------
DROP TABLE IF EXISTS `donation_project`;
CREATE TABLE `donation_project`  (
  `id` int(11) NOT NULL,
  `company_id` int(11) NULL DEFAULT NULL,
  `project_name` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `project_desc` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `project_leader` varchar(20) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `project_status` int(10) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of donation_project
-- ----------------------------
INSERT INTO `donation_project` VALUES (1, 1, 'wuhanxinguan', 'sssss', 'wwww', 0, '2021-07-01 23:17:34', '2021-08-06 23:17:42', '2021-08-04 23:17:49');
INSERT INTO `donation_project` VALUES (2, 2, 'guangzhouxg', 'aaaa', 'wwwwww', 1, '2021-07-31 23:18:28', '2021-08-01 23:18:33', '2021-08-04 23:18:48');

-- ----------------------------
-- Table structure for item_list
-- ----------------------------
DROP TABLE IF EXISTS `item_list`;
CREATE TABLE `item_list`  (
  `id` int(11) NOT NULL,
  `donation_info_id` int(11) NULL DEFAULT NULL,
  `currency` varchar(10) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `amount` float(10, 2) NULL DEFAULT NULL,
  `item_name` varchar(30) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `item_amount` int(10) NULL DEFAULT NULL,
  `supplier` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `standard` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL,
  `title` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `notice_text` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pile
-- ----------------------------
DROP TABLE IF EXISTS `pile`;
CREATE TABLE `pile`  (
  `pile_id` bigint(20) NOT NULL,
  `pile_name` varchar(128) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pile_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pile
-- ----------------------------
INSERT INTO `pile` VALUES (779555, 'rrw');

-- ----------------------------
-- Table structure for t_order_charging
-- ----------------------------
DROP TABLE IF EXISTS `t_order_charging`;
CREATE TABLE `t_order_charging`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id id',
  `uuid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'uuid UUID',
  `interconnection_flag` int(1) NULL DEFAULT 0 COMMENT '是否我方用户在第三方充电的订单：0系统桩订单、1互联互通桩订单',
  `long_order_no` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '长订单号 - 互联互通订单号',
  `order_no` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
  `order_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单名称',
  `is_over` int(1) NULL DEFAULT 0 COMMENT '订单是否完成：；0未完成、1已完成、2异常订单',
  `receive_flag` int(1) NULL DEFAULT 0 COMMENT '接收充电桩上送数据标志：0未接收、1已接收、2待上报账单',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_short_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户16位标示号',
  `protocol_type` int(1) NULL DEFAULT 0 COMMENT '设备协议类型:0新协议、1旧协议',
  `vin` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Vin，17位字符串',
  `user_type` int(1) NULL DEFAULT 0 COMMENT '用户账户类型： 0APP、1卡、2VIN、3、企业用户、4微信公众号、5微信小程序、6互联互通',
  `pay_uuid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '运营商绑定的支付通道ID',
  `agent_id` bigint(20) NULL DEFAULT NULL COMMENT '运营商ID',
  `agent_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '运营商名称',
  `company_flag` int(1) NULL DEFAULT 0 COMMENT '是否企业员工订单： 0普通用户、1企业用户可使用企业资金池、2平台订单(互联互通订单)',
  `company_id` bigint(20) NULL DEFAULT 0 COMMENT '企业ID',
  `company_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `order_type` int(1) NULL DEFAULT 0 COMMENT '订单类型：1刷卡在线充电、2移动app充电、3vin充电、4刷卡离线充电、5微信公众号充电、6微信小程序充电、7互联互通充电',
  `order_flag` int(1) NULL DEFAULT 0 COMMENT '订单标志： 0平台订单、1第三方平台订单',
  `stop_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '停机控制码 - 针对充电订单进行停车充电时',
  `pay_status` int(1) NULL DEFAULT 0 COMMENT '支付状态： :0未支付、1已支付',
  `start_time` datetime(0) NOT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `charging_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充电方式:01：电量控制充电；02：时间控制充电；03：金额控制充电；04：自动充满05：定时启动充电',
  `charging_number` decimal(16, 2) NULL DEFAULT NULL COMMENT '用户选择充电量 度、千瓦时/充电金额/单位：分钟,配合charging_type使用',
  `charging_mark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充电标示号，充电桩启动充电成功后返回的',
  `start_soc` int(10) NULL DEFAULT NULL COMMENT '起始SOC 百分比',
  `end_soc` int(10) NULL DEFAULT NULL COMMENT '结束SOC 百分比',
  `total_elec` decimal(16, 4) NULL DEFAULT NULL COMMENT '充电总电量',
  `total_time` bigint(20) NULL DEFAULT NULL COMMENT '充电桩上传的充电时长：秒',
  `start_meter` decimal(16, 6) NULL DEFAULT 0.000000 COMMENT '起始电表值',
  `end_meter` decimal(16, 6) NULL DEFAULT 0.000000 COMMENT '结束电表值',
  `start_amount` decimal(16, 4) NULL DEFAULT 0.0000 COMMENT '起始余额 单位：元',
  `end_amount` decimal(16, 4) NULL DEFAULT 0.0000 COMMENT '结束余额 单位：元',
  `charging_fee` decimal(16, 4) NULL DEFAULT 0.0000 COMMENT '充电费 单位：元',
  `service_fee` decimal(16, 4) NULL DEFAULT 0.0000 COMMENT '服务费 单位：元',
  `total_amount` decimal(16, 4) NULL DEFAULT 0.0000 COMMENT '总费用 单位：元',
  `actual_amount` decimal(16, 4) NULL DEFAULT 0.0000 COMMENT '实收费用： 单位：元',
  `service_id` bigint(20) NULL DEFAULT NULL COMMENT '服务费ID',
  `invoice_flag` int(11) NULL DEFAULT 0 COMMENT '是否开发票： 0未开发票、1开具发票',
  `pile_id` bigint(20) NULL DEFAULT NULL COMMENT '充电桩ID',
  `pile_sn` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充电桩出厂编号',
  `pile_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充电桩名称',
  `communication_sn` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通讯编号，默认14位',
  `drive_no` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充电桩设备编号',
  `gun_id` bigint(20) NULL DEFAULT NULL COMMENT '充电枪ID',
  `gun_no` int(36) NULL DEFAULT NULL COMMENT '充电枪编号',
  `tcu_sn` int(36) NULL DEFAULT NULL COMMENT 'TCU编号',
  `gun_type` int(11) NULL DEFAULT 0 COMMENT '充电枪类型 0交流、1直流、2交直流一体',
  `station_id` bigint(20) NULL DEFAULT NULL COMMENT '充电桩归属电站ID',
  `station_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充电站名称',
  `parking_fee_flag` int(11) NULL DEFAULT 0 COMMENT '是否收取停车费: 0免费、1收费',
  `card_id` bigint(20) NULL DEFAULT NULL COMMENT '卡ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间 创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人 创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间 最后更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后更新人 最后更新人',
  `card_sn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `card_type` int(1) NULL DEFAULT NULL COMMENT '卡类型：0用户卡、1员工卡、2管理卡',
  `branch_id` bigint(20) NULL DEFAULT NULL COMMENT '网点ID',
  `branch_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网点名称',
  `card_balance` decimal(16, 4) NULL DEFAULT 0.0000 COMMENT '充电前卡余额(平台记录的卡余额)',
  `merge_flag` int(1) NULL DEFAULT 0 COMMENT '是否并行充电：0常规充电、1并机充电',
  `merge_order_flag` int(1) NULL DEFAULT 0 COMMENT '并机汇总订单标记：0汇总订单(需要扣款)、1分机订单',
  `master_gun_flag` int(1) NULL DEFAULT 0 COMMENT '并机主枪标记：0主枪订单、1从枪订单',
  `discount_id` bigint(20) NULL DEFAULT NULL COMMENT '折扣规则ID',
  `discount_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '折扣规则名称',
  `elec_discount` decimal(5, 2) NULL DEFAULT NULL COMMENT '充电费折扣比例',
  `service_discount` decimal(5, 2) NULL DEFAULT NULL COMMENT '服务费折扣比例',
  `total_discount` decimal(5, 2) NULL DEFAULT NULL COMMENT '总金额折扣比例',
  `old_discount_service_amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '原始服务费折扣金额保留四位小数(单位：元)',
  `discount_service_amount` decimal(16, 4) NULL DEFAULT NULL COMMENT '服务费折扣金额(单位：元)',
  `old_discount_charger_amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '原始充电费折扣金额保留四位小数(单位：元)',
  `discount_charger_amount` decimal(16, 4) NULL DEFAULT NULL COMMENT '充电费折扣金额(单位：元)',
  `old_discount_order_amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '原始充电订单总金额折扣,保留四位小数(单位：元)',
  `discount_order_amount` decimal(16, 4) NULL DEFAULT NULL COMMENT '充电订单总金额折扣(单位：元)',
  `deduction_master_id` bigint(20) NULL DEFAULT NULL COMMENT '抵扣规则主表ID',
  `deduction_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '抵扣规则名称',
  `deduction_id` bigint(20) NULL DEFAULT NULL COMMENT '抵扣规则明细ID',
  `deduction_start_amount` decimal(16, 4) NULL DEFAULT NULL COMMENT '起始抵扣金额',
  `deduction_amount` decimal(16, 4) NULL DEFAULT NULL COMMENT '抵扣金额(单位：元)',
  `deduction_order_amount` decimal(16, 4) NULL DEFAULT NULL COMMENT '抵扣订单金额(单位：元)',
  `deduction_start_time` datetime(0) NULL DEFAULT NULL COMMENT '抵扣开始时间',
  `deduction_end_time` datetime(0) NULL DEFAULT NULL COMMENT '抵扣结束时间',
  `discount_flag` int(1) NULL DEFAULT 0 COMMENT '优惠类型：0无优惠、1明细折扣、2总价折扣、3满减、4混合优惠(折扣与满减一起使用)、5优惠卷',
  `card_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡用户手机号',
  `operator_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第三方运营商ID',
  `operator_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第三方运营商名称',
  `settlement_time` datetime(0) NULL DEFAULT NULL COMMENT '结算时间',
  `pile_card_balance` decimal(16, 4) NULL DEFAULT NULL COMMENT '桩上报的卡余额',
  `vendor_id` bigint(20) NULL DEFAULT NULL COMMENT '设备厂商ID',
  `vendor_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备厂商名称',
  `stop_reason` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '故障类型说明',
  `stop_status` int(11) NULL DEFAULT NULL COMMENT '结束状态：0正常结束、1故障结束',
  `stop_details` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结束详情',
  `stop_status_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '停止状态说明',
  `connector_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '互联互通运营商设备ID',
  `user_coupon_id` bigint(20) NULL DEFAULT NULL COMMENT '用户优惠卷ID',
  `user_coupon_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '抵扣券别名',
  `user_coupon_amount` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '抵扣金额',
  `user_coupon_initial_amount` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '起始抵扣金额',
  `actual_coupon_amount` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '实际抵扣金额',
  `old_service_fee` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '桩上报的原始服务费',
  `odometer` decimal(16, 4) NULL DEFAULT NULL COMMENT '里程数',
  `cart_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车牌号码',
  `park_flag` int(1) NULL DEFAULT NULL COMMENT '停车系统推送标记：0未推送，1已推送',
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除: :0正常、1删除',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stationId`(`station_id`) USING BTREE,
  INDEX `startTime`(`start_time`) USING BTREE,
  INDEX `cardId`(`card_id`) USING BTREE,
  INDEX `userId`(`user_id`) USING BTREE,
  INDEX `agentId`(`agent_id`) USING BTREE,
  INDEX `companyId`(`company_id`) USING BTREE,
  INDEX `settlementTime`(`settlement_time`) USING BTREE,
  INDEX `createTime`(`create_time`) USING BTREE,
  INDEX `orderNo`(`order_no`) USING BTREE,
  INDEX `longOrderNo`(`long_order_no`) USING BTREE,
  INDEX `userCouponId`(`user_coupon_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12243726 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '充电订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_charging
-- ----------------------------
INSERT INTO `t_order_charging` VALUES (1, '0', 0, NULL, '789', NULL, 0, 0, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0, 0, NULL, 0, 0, NULL, 0, '2021-08-04 15:44:34', '2021-08-05 15:44:40', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.000000, 0.000000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, NULL, 0, 779555, NULL, 'rrw', NULL, NULL, NULL, NULL, NULL, 0, NULL, 'lanqi', 0, NULL, '2021-08-05 15:47:09', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.0000, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.00, 0.00, 0.00, 0.00, NULL, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `type` bit(1) NULL DEFAULT NULL,
  `telephone` varchar(11) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `province` varchar(20) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `local` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET armscii8 COLLATE armscii8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = armscii8 COLLATE = armscii8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'rrw', '4297f44b13955235245b2497399d7a93', b'0', '18272262297', '11', 11, 'asdasd', 'sadasd', 'asdasd', '123123123@qq.com', '2021-08-04 21:01:02');

SET FOREIGN_KEY_CHECKS = 1;
