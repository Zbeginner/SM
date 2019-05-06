/*
 Navicat Premium Data Transfer

 Source Server         : Windows
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : sm

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 06/05/2019 20:18:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `score` int(1) DEFAULT NULL COMMENT '学分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES (1, '离散数学', 2);
INSERT INTO `courses` VALUES (2, '大学物理', 4);
INSERT INTO `courses` VALUES (3, 'Java基础', 4);
INSERT INTO `courses` VALUES (4, '数据库基础', 4);
INSERT INTO `courses` VALUES (5, 'C语言', 2);
INSERT INTO `courses` VALUES (6, '数据结构与算法', 2);

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, '赵志阳', '20160511043', '计算机科学与技术');
INSERT INTO `stu` VALUES (2, '赵志洋', '20160511044', '信息');

-- ----------------------------
-- Table structure for stu_cour
-- ----------------------------
DROP TABLE IF EXISTS `stu_cour`;
CREATE TABLE `stu_cour`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL,
  `cou_id` int(11) DEFAULT NULL,
  `grade` double(10, 2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_2`(`stu_id`) USING BTREE,
  INDEX `FK_Reference_3`(`cou_id`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`stu_id`) REFERENCES `stu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`cou_id`) REFERENCES `courses` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_cour
-- ----------------------------
INSERT INTO `stu_cour` VALUES (1, 1, 1, 89.00);
INSERT INTO `stu_cour` VALUES (2, 1, 2, 99.00);
INSERT INTO `stu_cour` VALUES (3, 1, 3, 90.00);
INSERT INTO `stu_cour` VALUES (4, 1, 4, 90.00);
INSERT INTO `stu_cour` VALUES (5, 1, 5, 90.00);
INSERT INTO `stu_cour` VALUES (6, 1, 6, 90.00);
INSERT INTO `stu_cour` VALUES (9, 2, 2, 98.00);
INSERT INTO `stu_cour` VALUES (10, 2, 3, 97.00);
INSERT INTO `stu_cour` VALUES (13, 2, 1, 60.00);

-- ----------------------------
-- Table structure for tea_cour
-- ----------------------------
DROP TABLE IF EXISTS `tea_cour`;
CREATE TABLE `tea_cour`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) DEFAULT NULL,
  `cou_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_5`(`tea_id`) USING BTREE,
  INDEX `FK_Reference_6`(`cou_id`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`cou_id`) REFERENCES `courses` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_cour
-- ----------------------------
INSERT INTO `tea_cour` VALUES (1, 1, 1);
INSERT INTO `tea_cour` VALUES (2, 2, 5);
INSERT INTO `tea_cour` VALUES (3, 2, 6);
INSERT INTO `tea_cour` VALUES (4, 3, 2);
INSERT INTO `tea_cour` VALUES (5, 4, 3);
INSERT INTO `tea_cour` VALUES (6, 2, 4);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '游庆山');
INSERT INTO `teacher` VALUES (2, '李廷元');
INSERT INTO `teacher` VALUES (3, '田石开');
INSERT INTO `teacher` VALUES (4, '付茂铭');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'efae47abc4bbb0bb76f8d968e5be9c0a', 0);
INSERT INTO `users` VALUES (2, '20160511043', 'efae47abc4bbb0bb76f8d968e5be9c0a', 2);

SET FOREIGN_KEY_CHECKS = 1;
