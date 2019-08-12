/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7-master
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3307
 Source Schema         : snarte

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 08/08/2019 09:55:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT 0,
  `order` int(11) NOT NULL DEFAULT 0,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES (1, 0, 1, 'Index', 'fa-bar-chart', '/', NULL, NULL, NULL);
INSERT INTO `admin_menu` VALUES (2, 0, 2, 'Admin', 'fa-tasks', '', NULL, NULL, NULL);
INSERT INTO `admin_menu` VALUES (3, 2, 3, 'Users', 'fa-users', 'auth/users', NULL, NULL, NULL);
INSERT INTO `admin_menu` VALUES (4, 2, 4, 'Roles', 'fa-user', 'auth/roles', NULL, NULL, NULL);
INSERT INTO `admin_menu` VALUES (5, 2, 5, 'Permission', 'fa-ban', 'auth/permissions', NULL, NULL, NULL);
INSERT INTO `admin_menu` VALUES (6, 2, 6, 'Menu', 'fa-bars', 'auth/menu', NULL, NULL, NULL);
INSERT INTO `admin_menu` VALUES (7, 2, 7, 'Operation log', 'fa-history', 'auth/logs', NULL, NULL, NULL);
INSERT INTO `admin_menu` VALUES (8, 0, 0, '基本信息', 'fa-newspaper-o', 'basic', NULL, '2019-03-05 18:10:13', '2019-03-05 18:10:13');

-- ----------------------------
-- Table structure for admin_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_operation_log`;
CREATE TABLE `admin_operation_log`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `input` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `admin_operation_log_user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_operation_log
-- ----------------------------
INSERT INTO `admin_operation_log` VALUES (1, 1, 'admin', 'GET', '172.17.0.1', '[]', '2019-02-20 15:57:05', '2019-02-20 15:57:05');
INSERT INTO `admin_operation_log` VALUES (2, 1, 'admin', 'GET', '172.17.0.1', '[]', '2019-02-20 15:58:22', '2019-02-20 15:58:22');
INSERT INTO `admin_operation_log` VALUES (3, 1, 'admin/auth/users', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-02-20 15:58:34', '2019-02-20 15:58:34');
INSERT INTO `admin_operation_log` VALUES (4, 1, 'admin/auth/roles', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-02-20 16:17:25', '2019-02-20 16:17:25');
INSERT INTO `admin_operation_log` VALUES (5, 1, 'admin/auth/menu', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-02-20 16:17:25', '2019-02-20 16:17:25');
INSERT INTO `admin_operation_log` VALUES (6, 1, 'admin', 'GET', '172.17.0.1', '[]', '2019-03-05 17:38:51', '2019-03-05 17:38:51');
INSERT INTO `admin_operation_log` VALUES (7, 1, 'admin/auth/menu', 'GET', '172.17.0.1', '[]', '2019-03-05 18:06:20', '2019-03-05 18:06:20');
INSERT INTO `admin_operation_log` VALUES (8, 1, 'admin/auth/menu', 'POST', '172.17.0.1', '{\"parent_id\":\"0\",\"title\":\"\\u57fa\\u672c\\u4fe1\\u606f\",\"icon\":\"fa-newspaper-o\",\"uri\":\"basic\",\"roles\":[null],\"permission\":null,\"_token\":\"vg6KllNnU3EXzpODimWvKZnbBWnfX8kLSGf93xB3\"}', '2019-03-05 18:10:12', '2019-03-05 18:10:12');
INSERT INTO `admin_operation_log` VALUES (9, 1, 'admin/auth/menu', 'GET', '172.17.0.1', '[]', '2019-03-05 18:10:13', '2019-03-05 18:10:13');
INSERT INTO `admin_operation_log` VALUES (10, 1, 'admin/auth/menu', 'GET', '172.17.0.1', '[]', '2019-03-05 18:10:34', '2019-03-05 18:10:34');
INSERT INTO `admin_operation_log` VALUES (11, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-05 18:10:40', '2019-03-05 18:10:40');
INSERT INTO `admin_operation_log` VALUES (12, 1, 'admin/basic/1', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-05 18:14:17', '2019-03-05 18:14:17');
INSERT INTO `admin_operation_log` VALUES (13, 1, 'admin/basic/1/edit', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-05 18:14:25', '2019-03-05 18:14:25');
INSERT INTO `admin_operation_log` VALUES (14, 1, 'admin', 'GET', '172.17.0.1', '[]', '2019-03-06 18:27:50', '2019-03-06 18:27:50');
INSERT INTO `admin_operation_log` VALUES (15, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:28:03', '2019-03-06 18:28:03');
INSERT INTO `admin_operation_log` VALUES (16, 1, 'admin/basic/2/edit', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:28:11', '2019-03-06 18:28:11');
INSERT INTO `admin_operation_log` VALUES (17, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:33:45', '2019-03-06 18:33:45');
INSERT INTO `admin_operation_log` VALUES (18, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:36:41', '2019-03-06 18:36:41');
INSERT INTO `admin_operation_log` VALUES (19, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 18:40:08', '2019-03-06 18:40:08');
INSERT INTO `admin_operation_log` VALUES (20, 1, 'admin/basic/1/edit', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:40:20', '2019-03-06 18:40:20');
INSERT INTO `admin_operation_log` VALUES (21, 1, 'admin', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:41:39', '2019-03-06 18:41:39');
INSERT INTO `admin_operation_log` VALUES (22, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:41:46', '2019-03-06 18:41:46');
INSERT INTO `admin_operation_log` VALUES (23, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:45:20', '2019-03-06 18:45:20');
INSERT INTO `admin_operation_log` VALUES (24, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:46:26', '2019-03-06 18:46:26');
INSERT INTO `admin_operation_log` VALUES (25, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:54:38', '2019-03-06 18:54:38');
INSERT INTO `admin_operation_log` VALUES (26, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:54:51', '2019-03-06 18:54:51');
INSERT INTO `admin_operation_log` VALUES (27, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:55:53', '2019-03-06 18:55:53');
INSERT INTO `admin_operation_log` VALUES (28, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 18:57:45', '2019-03-06 18:57:45');
INSERT INTO `admin_operation_log` VALUES (29, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 18:58:12', '2019-03-06 18:58:12');
INSERT INTO `admin_operation_log` VALUES (30, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 18:58:37', '2019-03-06 18:58:37');
INSERT INTO `admin_operation_log` VALUES (31, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 19:00:59', '2019-03-06 19:00:59');
INSERT INTO `admin_operation_log` VALUES (32, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:02:01', '2019-03-06 19:02:01');
INSERT INTO `admin_operation_log` VALUES (33, 1, 'admin/basic', 'GET', '172.17.0.1', '{\"_pjax\":\"#pjax-container\"}', '2019-03-06 19:03:06', '2019-03-06 19:03:06');
INSERT INTO `admin_operation_log` VALUES (34, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:08', '2019-03-06 19:03:08');
INSERT INTO `admin_operation_log` VALUES (35, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:09', '2019-03-06 19:03:09');
INSERT INTO `admin_operation_log` VALUES (36, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:09', '2019-03-06 19:03:09');
INSERT INTO `admin_operation_log` VALUES (37, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:11', '2019-03-06 19:03:11');
INSERT INTO `admin_operation_log` VALUES (38, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:12', '2019-03-06 19:03:12');
INSERT INTO `admin_operation_log` VALUES (39, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:13', '2019-03-06 19:03:13');
INSERT INTO `admin_operation_log` VALUES (40, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:15', '2019-03-06 19:03:15');
INSERT INTO `admin_operation_log` VALUES (41, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:15', '2019-03-06 19:03:15');
INSERT INTO `admin_operation_log` VALUES (42, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:17', '2019-03-06 19:03:17');
INSERT INTO `admin_operation_log` VALUES (43, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:18', '2019-03-06 19:03:18');
INSERT INTO `admin_operation_log` VALUES (44, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:18', '2019-03-06 19:03:18');
INSERT INTO `admin_operation_log` VALUES (45, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:19', '2019-03-06 19:03:19');
INSERT INTO `admin_operation_log` VALUES (46, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:20', '2019-03-06 19:03:20');
INSERT INTO `admin_operation_log` VALUES (47, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:21', '2019-03-06 19:03:21');
INSERT INTO `admin_operation_log` VALUES (48, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:21', '2019-03-06 19:03:21');
INSERT INTO `admin_operation_log` VALUES (49, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:21', '2019-03-06 19:03:21');
INSERT INTO `admin_operation_log` VALUES (50, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:23', '2019-03-06 19:03:23');
INSERT INTO `admin_operation_log` VALUES (51, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:24', '2019-03-06 19:03:24');
INSERT INTO `admin_operation_log` VALUES (52, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:24', '2019-03-06 19:03:24');
INSERT INTO `admin_operation_log` VALUES (53, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:25', '2019-03-06 19:03:25');
INSERT INTO `admin_operation_log` VALUES (54, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:26', '2019-03-06 19:03:26');
INSERT INTO `admin_operation_log` VALUES (55, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:03:47', '2019-03-06 19:03:47');
INSERT INTO `admin_operation_log` VALUES (56, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:05:27', '2019-03-06 19:05:27');
INSERT INTO `admin_operation_log` VALUES (57, 1, 'admin/basic', 'GET', '172.17.0.1', '[]', '2019-03-06 19:06:16', '2019-03-06 19:06:16');

-- ----------------------------
-- Table structure for admin_permissions
-- ----------------------------
DROP TABLE IF EXISTS `admin_permissions`;
CREATE TABLE `admin_permissions`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `slug` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `http_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `http_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `admin_permissions_name_unique`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_permissions
-- ----------------------------
INSERT INTO `admin_permissions` VALUES (1, 'All permission', '*', '', '*', NULL, NULL);
INSERT INTO `admin_permissions` VALUES (2, 'Dashboard', 'dashboard', 'GET', '/', NULL, NULL);
INSERT INTO `admin_permissions` VALUES (3, 'Login', 'auth.login', '', '/auth/login\r\n/auth/logout', NULL, NULL);
INSERT INTO `admin_permissions` VALUES (4, 'User setting', 'auth.setting', 'GET,PUT', '/auth/setting', NULL, NULL);
INSERT INTO `admin_permissions` VALUES (5, 'Auth management', 'auth.management', '', '/auth/roles\r\n/auth/permissions\r\n/auth/menu\r\n/auth/logs', NULL, NULL);

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu`  (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  INDEX `admin_role_menu_role_id_menu_id_index`(`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
INSERT INTO `admin_role_menu` VALUES (1, 2, NULL, NULL);

-- ----------------------------
-- Table structure for admin_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_permissions`;
CREATE TABLE `admin_role_permissions`  (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  INDEX `admin_role_permissions_role_id_permission_id_index`(`role_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_permissions
-- ----------------------------
INSERT INTO `admin_role_permissions` VALUES (1, 1, NULL, NULL);

-- ----------------------------
-- Table structure for admin_role_users
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_users`;
CREATE TABLE `admin_role_users`  (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  INDEX `admin_role_users_role_id_user_id_index`(`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_users
-- ----------------------------
INSERT INTO `admin_role_users` VALUES (1, 1, NULL, NULL);

-- ----------------------------
-- Table structure for admin_roles
-- ----------------------------
DROP TABLE IF EXISTS `admin_roles`;
CREATE TABLE `admin_roles`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `slug` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `admin_roles_name_unique`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_roles
-- ----------------------------
INSERT INTO `admin_roles` VALUES (1, 'Administrator', 'administrator', '2019-02-20 15:43:31', '2019-02-20 15:43:31');

-- ----------------------------
-- Table structure for admin_user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_permissions`;
CREATE TABLE `admin_user_permissions`  (
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  INDEX `admin_user_permissions_user_id_permission_id_index`(`user_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_users
-- ----------------------------
DROP TABLE IF EXISTS `admin_users`;
CREATE TABLE `admin_users`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(190) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `remember_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `admin_users_username_unique`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_users
-- ----------------------------
INSERT INTO `admin_users` VALUES (1, 'admin', '$2y$10$EaKYr17ONdculOr0X4NEW.RQvDC4ULp0jXG7R860fKnczwWdSSMWO', 'Administrator', NULL, NULL, '2019-02-20 15:43:31', '2019-02-20 15:43:31');

-- ----------------------------
-- Table structure for basics
-- ----------------------------
DROP TABLE IF EXISTS `basics`;
CREATE TABLE `basics`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cn_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '中文内容',
  `en_content` varchar(2500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '英文内容',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型，1关于我们，2联系我们，3合作',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basics
-- ----------------------------
INSERT INTO `basics` VALUES (1, '你好你好', 'hellohello', 1, '2019-03-05 18:00:06', '2019-03-05 18:00:08');
INSERT INTO `basics` VALUES (2, 'http://baidu.com,http://sina.com,http://qq.com,http://www.young-marvelous.com', 'http://baidu.com,http://sina.com,http://qq.com,http://www.young-marvelous.com', 2, '2019-03-05 18:00:06', '2019-03-05 18:00:06');
INSERT INTO `basics` VALUES (3, '合作合作', 'cooperationcooperation', 3, '2019-03-05 18:00:06', '2019-03-05 18:00:06');
INSERT INTO `basics` VALUES (5, 'cn_content', 'en_content', 2, '2019-07-15 20:23:51', '2019-07-15 20:23:51');
INSERT INTO `basics` VALUES (46, '中文内容0', 'english0', 2, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (47, '中文内容1', 'english1', 3, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (48, '中文内容2', 'english2', 1, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (49, '中文内容3', 'english3', 1, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (50, '中文内容4', 'english4', 3, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (51, '中文内容5', 'english5', 1, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (52, '中文内容6', 'english6', 2, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (53, '中文内容7', 'english7', 3, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (54, '中文内容8', 'english8', 1, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (55, '中文内容9', 'english9', 3, '2019-07-16 18:12:33', '2019-07-16 18:12:33');
INSERT INTO `basics` VALUES (56, 'cn_content', 'en_content', 2, '2019-07-17 16:18:59', '2019-07-17 16:18:59');
INSERT INTO `basics` VALUES (57, 'cn_content', 'en_content', 2, '2019-07-17 16:19:33', '2019-07-17 16:19:33');
INSERT INTO `basics` VALUES (60, 'cn_content', 'en_content', 2, '2019-07-17 16:52:26', '2019-07-17 16:52:26');

-- ----------------------------
-- Table structure for contens
-- ----------------------------
DROP TABLE IF EXISTS `contens`;
CREATE TABLE `contens`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content_id` int(11) NULL DEFAULT NULL COMMENT '内容id',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'url地址',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型,1图片,2视频',
  `is_introduction` tinyint(4) NULL DEFAULT NULL COMMENT '是否为介绍页,0否,1是',
  `cn_introduction` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '为介绍页时的中文内容',
  `en_introduction` varchar(2500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '为介绍页时的英文内容',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `test` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key`(`name`, `sex`, `age`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (2, 'george', 15, 'woman', NULL);
INSERT INTO `employee` VALUES (3, 'rose', 11, 'woman', NULL);
INSERT INTO `employee` VALUES (4, 'lila', 20, 'man', NULL);
INSERT INTO `employee` VALUES (6, 'west', 15, 'man', '2019-07-26 19:43:13');
INSERT INTO `employee` VALUES (8, 'east', 18, 'woman', '2019-07-30 15:22:04');
INSERT INTO `employee` VALUES (9, 'east', 18, 'woman', '2019-07-30 15:39:54');
INSERT INTO `employee` VALUES (10, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (11, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (12, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (13, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (14, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (15, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (16, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (17, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (18, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (19, 'name', 11, 'woman', '2019-07-30 19:17:53');
INSERT INTO `employee` VALUES (20, 'name', 12, 'woman', '2019-07-30 19:26:38');

-- ----------------------------
-- Table structure for lists
-- ----------------------------
DROP TABLE IF EXISTS `lists`;
CREATE TABLE `lists`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `from` tinyint(4) NULL DEFAULT NULL COMMENT '来源于，1展览,2微澜,3身体,4..',
  `cn_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '中文名称',
  `en_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '英文名称',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '封面图',
  `is_top` tinyint(4) NULL DEFAULT NULL COMMENT '是否置顶',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for migrations
-- ----------------------------
DROP TABLE IF EXISTS `migrations`;
CREATE TABLE `migrations`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of migrations
-- ----------------------------
INSERT INTO `migrations` VALUES (1, '2014_10_12_000000_create_users_table', 1);
INSERT INTO `migrations` VALUES (2, '2014_10_12_100000_create_password_resets_table', 1);
INSERT INTO `migrations` VALUES (3, '2016_01_04_173148_create_admin_tables', 1);

-- ----------------------------
-- Table structure for password_resets
-- ----------------------------
DROP TABLE IF EXISTS `password_resets`;
CREATE TABLE `password_resets`  (
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  INDEX `password_resets_email_index`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tests
-- ----------------------------
DROP TABLE IF EXISTS `tests`;
CREATE TABLE `tests`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tests
-- ----------------------------
INSERT INTO `tests` VALUES (1, 'george');
INSERT INTO `tests` VALUES (2, 'mark');
INSERT INTO `tests` VALUES (3, 'rose');
INSERT INTO `tests` VALUES (4, 'rose');

-- ----------------------------
-- Table structure for text
-- ----------------------------
DROP TABLE IF EXISTS `text`;
CREATE TABLE `text`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `binary` blob NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of text
-- ----------------------------
INSERT INTO `text` VALUES (1, 'This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.\r\nThis is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.\r\nThis is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.\r\nThis is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.', NULL);
INSERT INTO `text` VALUES (2, 'This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.\r\nThis is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.\r\nThis is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.\r\nThis is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.This is some big text.', NULL);
INSERT INTO `text` VALUES (3, NULL, 0x89504E470D0A1A0A0000000D49484452000000500000005008060000008E11F2AD000000017352474200AECE1CE900002058494441547801DD7D07985CD595E6FF4285AEEAEA9CB35A520B4524410BA11612022C04D864231B8F9731C2C0600F331FE37502B3B3AC3D0606F0628C2DA2D931E3C10463113C26085928210905145A6AA9A5CEB93A545757577E6FCF7955AF55DDAAF0AAE530BB475FD70B37FFEFDC73CF3DF7DC2B017F05EAEEEEB6098230C3A3C80BC754B15E11849921552A1C17E4EC8022381408D6902A585588195C3D018A5716549F08D56782E2B60B61972C84076441386553437BED62E8B0AAAA2D656565E37FE9E6087FA9025D2E579ECBE3AB1F564DD706202D1A56E42A0FCC953E422F0011045A5A552130611654580545B523D0912B86DACD081FCA15826F65DBAD7BB3B3B387D2CA709A91D3AB759A851057987A7B7B97F487CC377B05D36AA76A993FAACA76BF2AA69993B1E81641419610F21408FEA3196A706B911C78BDA4A4E400717BD0580EE9C7FAB30048C059DAFAFA1A4642966FF429D68611988AC75529FDDA9D430A9B10460E827D85A26F47BEECFF795571F17602D27F0E59C64DFA2705908093BAFB07D7F485A47BFBC296862158F302AAB122BC6115074FB6A3DF3984D11137C63D5E045580613711C3DAEC19C8CECE4255711EE6CFAC84281ACB97BB791E7C43C5927F47B11CFE695951FE1602321C178D69BC34560B0319F7F5F5CD1C089BBEDD15CEB87E40B114050DC834A7C78F5D874EA0A5A5036E85AA52510621371742A61DC8D0C68F33257BBD50C73C50878761EEEA460E213B9B805CBEB00E56ABF94CBC04772692994592BFBF4CF4FEAE500A3E5A5C5C7C2A41D4B45E9F3380C475D6E6DEE1DBFB43A6BB3BD58C8546BAEAE0B81F6F7EF8097A47C721D6CD86505EC6432D0D250232BD63B08C8FC334EE814880851415E1CC4C046D3678E9CF6FCF8C3490B8532520CDA79A519B6DC735975F048B253590DCB52B04EFE12239B8715649EE8BC48DBEB4109B12F99C00743A9DE53D7EE9A196B0ED9621D59C496D4A4A6341056F7EB4076D7D43102F584CDC96038BAAA0A8A70B626B1B94A11104C7C7807010C1801F7E5F002A656ACD30C364B6507F2680084085BAB2AFBA1AA36515F48EC6E3E111580F7C8679A579F8DCEA7A4872F2418A1B9D2704C66648E3AF965AC20F1614147425AD7892C06903D8D1D3B3BA276CFB51AB626FF01818205A06DDF8CDEF3623BC7431C4E222D8C26194361E46A0A51D41CF08FA08D445152AD6CE1942912384C2CC308AB2C21A80036E09036391BFF78EE7E350A780A2A25C203B1FBEB272B8162C24412943EDED47DEA1CF70EB8D97232B2BCAA9491A4FFA246A44CF8E5269FCFECAD2D2AD49A2260C4A1B40EAB2424BEFD017DB43D61F752819B3420664DDB6E36DD8BAEB10A4359740264EAA6E3A8AE0A9D318EBEF4596E4C6372E19C0CA595E645A9484158D0D18F38BD8DE9C81A7B715C11D76402E2E85A7AA1A63F3E7430D0460FF783BAE5DB918336A89435310C18E4AD1DB5C25FBEE9F5192F71A75E9541D69528E690148E089277B86EFE850AC0F768433CA8D94F4C68EC368EC7542BEF82238C221147CFC31FCCE3E84DD7DF8D665FD5837DF33A942E93EFCE1A80DFFBAB9188ED26A0C98B330BAEA12C06C8679F71EACAE2CC28517CE4B992583502979BB2A45DF43756579CFA64C1013212D000F770D6EE855321EE95232F28D80F7D1D116EC38DEAA81573AE68675E70E0C75B4E1B2DA41FCF3D57DA48AC4D4E41C6E1562DC077F5F82AD2DF9104B2B31B27C0594DC6C64ECD98B6BE7CF40EDECAA94B933107325973B470C3D5C579AFF3071A2A1EE60A809DC6D9BBB87EE2259F7934E83E01DED19C4CE4F1B27C0B3EDDC89A6038DF8C29C5E3CF4F93F1D788C0C7F881F7EBE17772DEB40FFD1E328DEB797061617BCCBEAF1FBDD4730E41C4E092033446338DBD11EB6DDC7BD8CDB9C3211976D2412CBBC36C5FA83E3548091F8ACA66C7AF763886B56212718D038AF9BD48DC76F76E23B57FEF9A6A87F73D128FEE5DA01B4ED3B84BCDDBB009F4FEBD2AFBF4362C31F30527570EF6211C56D36922025803CDA6A03864199C785BEF1FE4E80649E95D489BC6D1FC3D5DD85AF5F3C80CF2F3A377967A441372CF1E01FAE7043ECEB4626C95B81662CC3CB9661EB479F18494E430AC0F25D6B33B53D55A2A4006A7A1EA92A3CDA72C646E8D4C028FA7D3436938E57718446DE800FB72CEAC5D71B52772323F91B8973CFAA213454F6A32ED70671FF412839D968F104B529A291F41A88D46656D31883646912024832C0CA4A32EB79465415BD90773ED80EA9FE02E4903A61763AD176F214BEB464500FFE8B5DEF5BD38FC3BBF6A1D03D02787D185AB2141F7C483DC320719BB9ED8C01639128594200797AC6330C234AB29E79130D1CEE0C9EC75A917F701F026E1736AC18413E29C5D3A1439D66ACFDDF15F0060CC9F34945709977901DC8EE71C1F4E97EAA930583161B8607095083C46D670C188B4449E202C886019EDBF2F42C51C278EFF71C3C0E71EE1C648682C8F0FBD1DBDE81BB574E6FD0D05493B78A50939F89A7B6E4C52B2EE5BBBB560E531DDA91AF06A1527D5CB3EBD0F8D9F194E9622330068C056312FB5EBF3F0B40625789AD2A6C18302AF7F4CC7A0786216465A1A0B58574591997CEF14E5BD7FBE9965C645933F02F5F28C5EF3E73D0F42DB5A140AF877E95441597D67991473D426D3E8D509603EDFDE9C962C680B1604C181B3D6FFD7A16806CCF63939411AB8A9E095FDB87DCF0D9A9FB1249BDBD70B6B762DD5CE3DD454B18FD79F340267EB1350B3FBBA50265D9329EBCA90CB7FF5B09DA86E4D86886EED79DE782A7ED24AC7DBD5AFC31B2E88CB9C860910631168C09633335D9240009610B1B43D99E373562AAE7438D2D906A6A60A6BE6727D5A1BBDB895534BF4D973E3C6EC33FBF938F3DDFAA45813D025843AD1D8F5C5746F2B01C9F759055260D5A3D7B1C5D5D4EE49824A8A1300234673E7DA2358D1C22511913C686318A4D3C094036C3B325D98831343613BE1F19719175C401FBD828EC761BF21D62DADDF7DF773BF03F48EEBDBEA10A858EC9DC76D53C075EB8B51C77FE7B29FE7034C2E953EB10EF9967295C17075B674647E17538E01A198D1735E93BC684B169EFEB5B191B71024042D6C46B186C868F8D60F4DEE3198740DDC3EA1923E0C8DC44A628A3D4332AE1DE574AF0E68162FCE6F61ACC2F8DAF355C36C78EFFF8DB2A3CFC9F45D4C573E10B4E543F695145590AAC2613E0762348966E37D5753AC4D80C862CF730567AFA891AF0EA192F00195DC3D033D0AF817064EE2D911559217DBE846C7AA9A8D725E3271FE6E1BAA72B3033BF04BFBDA306B5F913758B9BFCBC620B36DD5983A69E12AC7DB212AF7E9A89F1C04433E2A62976904E4A75E2250126BDAE71232779C9D80C10468C951E6DA29F501FBF8957CFF48074AFBC00A4117D5DB608E7649C3DF764D5E4688F05073ACCD87A228B465613AE5B94850FBF598082CCB306B88455E0EEFDF3F51538D8E9C3C61D1978F47D2FD6CEF36259CD3896CFF06906D9584B4F6E46083C6CE80086F4BA262C21710063C4CBB414630FC7D200E445EF636EE1D27447DE78C5284A98E69F3294A831C31F14B0FEB97274BB24528881DA02094B2BEDF8F2523BC9B44C98A5F49564BDDCC515566C5C5F09E75818EF35BAB1B5C98D273EF463C8A3A032278CDFFE5D1732CC2AD5855250312A7FC17324C6C82B9A563366BC781F01903C069C6ACEFC73CC3B6EF2C17132C5BB65FCF1DE5A64674810A68F57DCFCF92573EF5796E5687FFC1CA225D2853F3E89A17111E566E3B298D31A217610707946EA29EE7B1A80EC6EC11E0346124F8D73AAA905CDC74E63FC742BD47E27BADCA3345A91140C3AF0F6613BC63C6114D300986333DE45A79691EEB34C5C2DD31AC9654F5420274B82E60971621F1441448856F2DA69A0DBB179172E5A55AFC54B377FC68A31A374EFC9ECE8D3A54A8BA6E36EF1F1E64FB06D334DD0972E81B0FA1208B442C6E6F4208D786141C268989629DF7E03E1C064C5F5F747DD78E3E02871087577FA57481CF4C5A5D9B882465923F4619307AFED77D142132D3AD1BF3CFA38372DCEC2D5F3CF982BD9DF46BCF17AF4D972C8AC16864CDDD744B64935108497A675DB5BDAB067C733F8E6F7EE8289C04E87182BF6EF61ECC8C149A8190ECB55E964C0713BDBBAB1E5AD0F61BAE74E088EC95366EEA59EA171F49C7662664E0ED03B19C06E57085FBA201BC53418F0BA6FEF680827FAFD8601E4B8D72D72A0244B864C2A539F3B44B394C9EE2F2A7D98A06C414FE7184A6717C09167D39AA84B1065FE5C8CBFBF19CF3CF63C8178B71696CE0F3B4755C8C20C995CCCC8CC69AE4C2731C76D3E764A33D74F054FCF873E8C76AB9A2CA4D64CA63B56D09224116B3EA453D1A0A2376B72BC444FF75C12515559D671398BE258EC385F5562B1415C9E40F08AAB1A30FCB367121593F43D63C6EE7932FBE7B18B59D2D8710247683EA96625D6B9453992658000E46EA6D39EB671FC640BF9BFF8143411273108DC0577FD532D2CD1347ADC44573FE921173F7E5A13012CEFE61499916D95F08F6BF2B0AC3AC2693CF22AA40D90D607BD2E67E567B592D89110F00761B624D73FA7A6F5A9A240FE8CF5223B37B2BC48976C645F23D78184C94412D84C01D1029BE9CCF7A9C8316357CB382D75FA34F016CD2A45FD8299F8D22F3B12E6353560FD2F3BE1F647F87ADE8C129454546127E5C979EB24D08751592613E975D1C326AE0472980DBF6982C7E959A90EA9EA4C31489EA1E93A37720656F64321819C88842837A934A8C4AA5F5E72EF6025975D36989EFDEE17F1CCF76EC1A0DF8453CEB395EF48AC33BF1CE718811F24809838FD0BDF5F8FE2BC4C70DE3A2954A8420319935E173D4CBFAA34A8C854BFE91063C65EB5B297DC6AA79381C96C821872274C2AEA5301937542A9E6C8A33E1A1149F00734ED1678F2D56DA829C943EFB09BC268C049419C3E1C4DCB51F5F4832363943E225BF9BD4AAE238AE61CC7CB9EF17B98400C201AF0ECE2FCE21159ACB365F6498E1798EA9D9938500C92A5374144DD7F2F4C2A8DA2B31BC59D5D688185E456203A9FFA8FF70F4CE4C061A988E384CE301AF4F40E8BA8E5CDE9C70334B8906C53C9718949AF8BF610F3C36E20166284E912C1EF10D9A17B3A193080FC05139118953FAA28914E78860332A9A1AF6D880CFA760BE989F4CCF4EEDDD513F789F2E4F71C9FE3EAF79C07D3ABB7574EA41F0F909890693A19FD487A5DB488B13F04E074BB3067C3D8C9EC0D1F9BA7D1FB088089659636AE53DB7824E419402C9D6796D0F8954A748E84D14D73D5F93333CEB2FFC5C69F7A3FBFD482BDF7D562F7A1310864C5B8A8D28A8218EEF51080A02505853990EA9048C750A907713BA64B8C9DAC6F2548371333B33E552019B1EC5109BC495A92971A75C80B1BF5FD3A4A5C17A21666A63713E0320B5D0A3E1FA64182BF4D1799CE54727FAE8B88009D0355E2C044F28FF3E0FA9F0B808CDD64D6D07235F6A3154CA358321249D6A9924CF6B74837D3E2927C9A2438B99B454455B2ACCE0EE37C6269C29E46B3205671A2B297EB909048FF33E2D59A283D579B940D85172ED296A40CA092440672A10271209BB568D0858B382F9BBF5736714D35759B61E21AEE5B65741FD136388971AAA42A93324E9602AA3DE5537BA62B3A3D21A80C208D365C8784440C702E004ABC01887700114764252C2441404E5E3642AE51483C1F8B0E1853A3F2D75734EE5371A4C70B5E1CD268067535FE3B17E2C167C11447F4687E477BFD50CD0ED23FA99325E1407188BC610B13CFA652554FDB3DC5DBA752458C172ED3172E2A2F81B2656BBC60ED1DAB0FCC819218C607C7271B141226FA13047CD6E98589FCAA55FAB88954180C0E413876023366554FBB44C64EA68E38AD9671EFFBEA9DEBF1E8F71E83DCD60E75F1A2886CA36E2104FD643AF22357B4233CEA819BAC2D1F1C1FC503571681E7AE89A86B248807DEE9C73757E56161B975C25ACD16E77FDB430EE8242FBFB3B6205172ED7D90ECA77BDBBDB4E07492E6D8795065920F5B1A1126851E3CF0B1FE4ABE83C1DD7B71FD576F40A50137E04405F2BE3D6177A76B4763386B45A248A9DEABD44DF66CDB8B41F2393971E4189697F5635EB11F1926153E1A6137D202F957968D91B9C982FACA72DCB1227997796DFF285EF864182D4E3F4AB3CD64AA0A8295E475731D642CC8479E3DB9C07C91D2EE38DD891B978ED2602292522D688B4E7C6D1E34637B5B0196ADACC7DCF3CF436149F28F91AAEDF3A5D19DB289763D122BB252982A7EDC70F6BFBB68F532F8BD7E1CFEE4533C76C300A9606746C82F90B16CCDE3E5F8DA0A379EDD39889B176727B54E7F7169161957B3B4B972FB70908CADB266A549206627D569980CB4BFD8E6C4B37F338CF96567EFEAE23979FDA39958B2FC7C388CF98A4ECA3FF68131E31DA3A2A8AAA7A81BC7864DEB9EED8317CC502681C719956587F0EE377BB0A5C94AC005B0E491536408485D048B88EA3C136C6696A1A9E3B359ECD697DA711B7983C5038F73E00179D5792A9A0E9F489D618A188C196327660ACA5E2BDDA5889F32F8D4D163585717DF136B5651009BEEE9C5B5E77B783B0796FD6B339EDE3AA42D4BF68C06E18FD1E15216142702D77EF64327C98DCE833B5726F7C75957D78F93871BE3E492DE2BC68CB11369B3F221DE6F9B5EF2C9B1590E361D6D266FACC42BFE5693428D73E1E0F7DB30B3C88F57F60FE3FB6FF7E1A6E73A70FEC3CD68EC39BBCB4D2E25FED30099F31FDBDC832BE7F9F1E26D3DF123C5BCBD84FC75DA5B3A35236ACCEBB46F1933DEE84D38AAADBC5939ED1C6212B4B776A22C9736F33952F74D9AE3E3D71BBAF1B9792E5A0BF1E35B57E4A3F1FED9985B929E5EC8EAE7A6C36EACFB450BFC4A379E5CDF1753A3C4B736B3820555124E1D3F9538928110C68CB06B11799B3CEFF4E6CDCAD3A5E6234DB8A28E9C8BD2A0EFAE1BC4AFBED68D97F77661F913D4A5B70DE2781F29C02984C93152929FDF3984154F9CC4AFF676E097B775E3DBE4F99FCE06A375E70D911C6C4AA3B693A332568C1963A7CDE2799B3CEDF4BE6D40351B5B579C9C1F9A8F34E21FAE1B9DF236F5E3ECE2205EF97A179AFBCDF8F55EDAF2F5AA0D3DA302AAC834EFB08AA40A45460F0FCD7B47BC215AC6E43D740A2EACF1E2F9FF368239947E3AF439FAD84F6C6ED23E56224B4DB27C79573C63C6713400F98C8102B7FF282920CB92258C17E61A72C147DB53175524372CC44BABBFE341E6C16B9CDAA39B8E9658F670259E595FA6ADDAF14B2BCD753F3A417B85854E3C70CDB93BAC97906650922BA29364E17414693E528031E3BA4500241F8F435D437FA4BDB4CBD2F58F693A721297D44D1F3CAE442C39AC118DF4D2D9F649B396637D010C7953F4EFD88C52DCAF9EEDC189C6936903C8FB8DF93C86ECEC7C4DE598D0B00A45FF1B7CC6408A72CF0A6E696CC415B3CE9D2B8EF79AB1F1E36C5CFD54A9C67963D15537BD405E4C7A6EBB438BD335A27D773D685AD72B670FE074637A0EE75C1063C48759E8854ED4844FB7E8EB1AD9E1542C371AF5110C9346DC7ABA0B0D374CCB1E410AB580770ED9F0D2AE2C3080B1A49BFAF5773673E45B6FDC56483E85396898E9C3DF5E3C8A55E4443E1D5A4C2287C58F7B742CE2BD6A20133E7FA1980EB160ACF4E8131C48ABF7C11CD9FF341FD0A007A6BAB636B76276A940023FBD117C90364F3FB52507973E5681EFBE593009BCDBAEAE47A68DD65BA64877B64114E739503FAF92662622769CB2E2EB2F17E1AA9F96E11572B26437BA748847ED8BEA249C24FDD52831368C1163A5A79900905F541717EFE0D32DF8800623D44C32E4F259C935FFD87C18B80736E5E3529A1BFF6C4B369C9E49C543A239DB2D579C8F4020AC2DBCC7A63DDC338EEC4C0B96CFAF464EE699659CD34E13F955E763D5E31578763BD92863ADDFB119C4B95F3B6B0027A90D468831616C18A3D8F8935A40C8FAF968103EDD223652A2FB96634DB86C8E31F585BBE8554F95E1B57D99934DFCB1999312D8DC398886F36B70E3F39D60F316CF715FFA64049FB6F971F39AC514EE44388EB23842BE808FBF9F835B5F2C36BCB369CD6C176D453B9D52F7E42A32268C0D63145BE5490072009FABC24783F068938CD8D3DD3BEE35A48BB133F89DD4DD5CDEB38A9B54042F98FFFAFD7DD848DE060EBB052B7FD282053F3E8D1FBEEFC4AD575E80AF5E7D01761D69C3883BB1DCE36D10FFF3DDE42633BDD01C9B82623A3FA5BBAD4B7F15F7CA5830268CCDD4081383881E400887695BD3A31561EFC527D5CC84BB955AC8B172D9CCD48EE49CEF6F0FD8D1479EF84668F79176FCF8FF7C847D2FDD87B6DE61F4D1069EDAB23CB285CAB8FEBFBF48F22FB5AC7BEB333BFEF1321758DF4B452B6705B47D23E535E571A372697C4C0A9F35C3D84C8D7416801C810FA539D933F4CC6030F0F06082FD72EDCD2DB87186B16D539FB6C799E75A49AA941740A824A3666E169065A36D62341122F9F62B72F679B9910C03241305C90AB16B0C61DA302D7E792DD980C9899DACDC029D39A30E8F42A12E8DEE015AD59C90EBA4060938DC6D36046043553F1EFFB40558DB30151BED998F47E13366121DD41317404E4987D2BCE0EB1E59EA0B4BB7C7DBB1D94EB2E3C2E589BB526C6DFAC6687DA2BA0842452150458095174228CAA1255DFABE3C5E914CA3AF1BBDD7D6C2B57B21EAA8CEDE0D22ED9B038D1D9283402EA57C88D8BB35929EEE9D230877F5436519D9DD8FBE316383DB85D55E74BCDE410EE8548729DCCDC7A2F0D9327C408F56609C9F840052837CB4D9F841AFCF33A729EC98B467D8ED72D3D93801F2B83FF3D5E3E48D43623936494B70F0B645B4044D7E7B04167709FE8B3A0D4C80A0811505330A4D14448E4C6FA200735A1D349100266D447B16B3A99BB3BF22194C39AF17425EF4F90FE22A793FE64989AD7559A48215E5C8E8EF1D40715911E7AE111F87522D7AB6F3C13C8C85FE7EEA3521801C914FF4A12DFFF77B54F9F936C536B16BBDABBD0773CAB9E66753A79087B7A445785B5A8C5681B88D1B4F9C434E38917B8D6B68B951BB727AF250A515B406BB191F8CFA70826720CC910C4E24987FC1D287C1AA24B7906B722DD84F76C0FD648CA50972C4BB91926980722ABA0FD2A9829B7C0DD8A434A04A1CC0E7CCFBB1D67C00A5D2D96AEE7965E462426DD201E472F92C993269FC818282D2A4234C5200B9E27CA2CFE99EC1FB697DF709FDAC98DECE5E2C2D9FECDA764A2CC4E3D25A6C11E6461A4E8DE08A44BA190112B9D340E4466BE0D0EF0A9B094F5565C34CDDE7CBB919D8D03282662FA1C5C03338FC9DA2F785A44DFFBC361B15B4C8142A06FE89F685EC1DA1BDE59C1FC7E36EC8FFF899EFB57204F42845F895EF2ABCAC5E8D15E623D890F52EAAE4339ADAA262377612073269E0D119325592CFD069462901E44CF9441FA56738979AF543DAF6593032D08F19B42B88C92964E267E2E5785DBC90DA499EF15A83230DD11A4E7198473419C3DD901B3621EF54DC5368873DBAE85140569705B4F4D83AAA208F763B7DB53843733A78B9C70727390C555B64D490998BD3D30225AE2BB0E2C0000D280414972592F77CA44B534DF890C728F0CC99FAFD1EFF02E2DE055897F9096ECDF90372E9E4A4DABC31FCE7E108807C764CAEA83CC46DE6F6A52243005285C9F8AA3EA7F40C166421F09D979C438E9CF325FC5CBA0CBFC44A78051A65B90B71695C69ED3B463888D2694F5A9765AE9C686C8453CA681B6A2C9968262187446C28CBC0FA92C88C2393007BE4A417328569E047131492BD50A6299CF62FCAF1917A5069DA73F48331276A6072F91190DF1F5E816DC317E286DC8F5062DE85A0CF8B72D13BE890941FD4951A3FBDC810805C5FAA3855093FA203789C2356CB0F1EA8BCBB7C58CDD6C0895496E2F013555493615A08CBBE6803B901D1469E695C14742E204A220348A2AD80B8D2141D150B68715C26655C9CA2D6713E0CF644BE51A01844AA89F6B1F4B2B4BA11F7476A19E9217EC582DF0C5C0553E06294943776D54ABEFF35B324F739BD2E46AEC9A706717298599AFBEC4FFFFEEAFB4C969C66892ACC00E957F2E0205F197A0E1367D0A2BA891A6DA2063297C8B4B0CD8D6520247EA63F0EDB47322C96ECD4748EF3765740DB43C261EFB4D3B61602D51EE1F189E84DE45FA8E54D65711A067EE299DF715D14029E39975DDDA8BE127F507EE6BA46EB9F65CF6DFEFB6B2EB88FDB166594893252DD18E6403D23EECE74FFEAA18E9EBE4746C51F1DF40B0DFC75B52FCD5CC6DF9E38E08CF0672EA3B754594DFED15513EEDA95BC1A9C415C435B5875AACF31E1ADD6208E0EA8D83510420671E1BE5EDA65445DEF42523762A9758816B7E94368DD7A82BBB8179C91C1BA4889D48BAB1EE54CBEA1C7F372C23BBE36D773FFDC19A55BF955BA44A54D9FF8509AE79DCA43AFBAC45BA8CE993A483A60BADCD1BB9426CCB5EEC5205243E8BE940685E79767C211DD0AC13B979E3CE2C347E434C91F812524EDD4C7F9F932BE5F6F853D1ACF436BC9F76E1E471F6F01665C383FFAA7CB5C0D307EC7614CD1701D5CEA7A6357D6045EBD694EE8AF730063A456542F3A94E6F72D031B9E77CA7775F9B030025A840BF4D12F7225AED0B88EB993C27934D63813F8D6022BD691BF9FC6499471802C309BDB43D8D71FD2BC1816D216D9753526649297021383B4B92D8427F7D252020334010E831825FD1D97A38FFED1D052BB7AF8E63AEFC635F3F35FA4B0844AB29E55B2EB4479C9221909E373555E1990BFFDB653BA9E4E7E2A9AE8D2D186448439731D15C95D2C0A2683586A15F07043068A6DF4C48D25F213881F1148BCFE7B458D4C1B0623EF19BC8171150FFED1871E5D15D5C1E27C19247A8E801AE140FD1D317BFFE5B5FEDF5D33CBFF5FE7105AADB5D11F6A9C74AC7B70CD2B9DE2BDBB87A506B2F8E769401108130DA27BBD8B33903AF7CCCB13F08DA5E42C9E219057978AE73E0B6067476437E7D262117F77811976E2C0119F8A8DC47947FB692792F621B8F00868BA1AC57972195ADEF4A14C8232B4B824B8F3FAB9C1276757FD173D06398AA176A186591ADBFA1A36759BBEB1DB696EF08740F306E6068D17B486E980EA003298C5761173F34574900379CB08A1C0C0733AFAABCE1250932BE1C4804286021D780AA0389CAB263A38328B07CA8B0124FF95BE2565C11DEBEAC69F9E535DBC83B87B923194A39F2B71DDFE6C44406A47C1BFD76DB9699F53BAB475549E4F9B6EECB1A045BA574CD7A3DAE8825F0B9B9061112075AED22A4E389E110594909E69FFAEA72A2B7C746159E08F6B6ABD6FFC3F79147CBC2FC2670C740CF9EAB7F79AAE6D71C98BDADC62D57848ACA4390E2946FAE8A941A601A1013489BB98B3A2E0F2950B61712088AA4D563A2AB2C2ED3579A143CBAB7D6F95E5FD7FF29F11C40392DF45FF3B8C9AD3C3F2A263C362FDB0579EE9F48985435E39DBE7571DE4576D25077BABAA44F661D04C5AFBEF30241A316D923A966B55460AEC61676E46B8794E41686F757EE810717BEB5FE3BFC3F8BF182072CBAF1428850000000049454E44AE426082);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `users_email_unique`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
