CREATE DATABASE gatering;
-- 创建表 employee表（主键id，empId，name，pwd，job）
-- 用户表
#DROP TABLE employee;
CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT, #id 自增
	empId VARCHAR(50) UNIQUE NOT NULL DEFAULT '',#员工号
	pwd CHAR(32) NOT NULL DEFAULT '',#密码md5
	`name` VARCHAR(50) NOT NULL DEFAULT '',# 姓名
	job VARCHAR(50) NOT NULL DEFAULT ''#岗位
)CHARACTER SET utf8 COLLATE utf8_bin;
-- 添加测试数据
INSERT INTO employee VALUES(NULL,'1001',MD5('123456'),'张三','经理');
INSERT INTO employee VALUES(NULL,'1002',MD5('123456'),'李四','服务员');
INSERT INTO employee VALUES(NULL,'1003',MD5('123456'),'王五','收银员');
INSERT INTO employee VALUES(NULL,'1004',MD5('123456'),'小明','经理');

SELECT * FROM employee;

-- 创建餐桌表
CREATE TABLE diningTable(
	id INT PRIMARY KEY AUTO_INCREMENT,#餐桌编号
	state VARCHAR(20) NOT NULL DEFAULT '', #餐桌状态
	orderName VARCHAR(50) NOT NULL DEFAULT '',#预定人的名字
	orderTel VARCHAR(20) NOT NULL DEFAULT ''
)CHARACTER SET utf8 COLLATE utf8_bin;
-- 添加数据
INSERT INTO diningTable VALUES(NULL,'空','','');
INSERT INTO diningTable VALUES(NULL,'空','','');
INSERT INTO diningTable VALUES(NULL,'空','','');
INSERT INTO diningTable VALUES(NULL,'空','','');
SELECT * FROM diningTable;

-- 创建menu表	菜谱
CREATE TABLE menu(
	id INT PRIMARY KEY AUTO_INCREMENT,#菜谱编号
	NAME VARCHAR(50) NOT NULL DEFAULT '',#菜品名称
	TYPE VARCHAR(50) NOT NULL DEFAULT '',#菜品种类
	price DOUBLE NOT NULL DEFAULT 0#价格
)CHARACTER SET utf8 COLLATE utf8_bin;
-- 添加数据
INSERT INTO menu VALUE(NULL,'宫保鸡丁','热菜',10);
INSERT INTO menu VALUE(NULL,'山药鲅鱼','凉菜',20);
INSERT INTO menu VALUE(NULL,'八宝饭','主食',30);
INSERT INTO menu VALUE(NULL,'叉烧包','热菜',40);
INSERT INTO menu VALUE(NULL,'银丝卷','甜食',50);
INSERT INTO menu VALUE(NULL,'水煮鱼','热菜',70);
INSERT INTO menu VALUE(NULL,'海带汤','汤类',80);
INSERT INTO menu VALUE(NULL,'鸡蛋汤','汤类',90);
SELECT * FROM menu;

-- 创建bill 账单表
CREATE TABLE bill(
	id INT PRIMARY KEY AUTO_INCREMENT,#自增主键
	billId VARCHAR(50) NOT NULL DEFAULT '',#账单号可以按自己规则生成
	menuid INT NOT NULL DEFAULT 0,#菜品的编号，也可以使用外键
	nums INT NOT NULL DEFAULT 0,# 分数
	money DOUBLE NOT NULL DEFAULT 0,#金额
	diningTableId INT NOT NULL DEFAULT 0,#餐桌
	billdate DATETIME NOT NULL,#订单日期
	state VARCHAR(50) NOT NULL DEFAULT ''# 状态 ‘未结账‘ ‘已结账‘
)CHARACTER SET utf8 COLLATE utf8_bin;
SELECT * FROM bill;
