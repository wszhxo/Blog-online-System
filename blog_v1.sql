/*
Navicat MySQL Data Transfer

Source Server         : 张某
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : blog_v1

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-08-16 18:30:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `summary` varchar(255) DEFAULT NULL,
  `content` longtext,
  `html_content` longtext,
  `img_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `hits` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `likeit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('2', '自我介绍', '---\r\ntitle: 求职java开发实习生\r\ndate: 1314-5-20 66:66:66 \r\ntags: about\r\n---\r\n\r\n\r\n#  个人信息\r\n\r\n- 张洪祥 / 男 /1998\r\n- 本科/南京理工大学紫金学院/软件开发专业\r\n- 老家:浙江省金华市/  现住:江苏省南京市\r\n\r\n--------\r\n# 联系方式\r\n\r\n- QQ:	2500621077\r\n- 邮箱:	cuber.zhx@qq.com\r\n- 电话：15150576706 \r\n\r\n\r\n--------\r\n\r\n# 在校经历\r\n\r\n- 专业课成绩优异,获得过奖学金 \r\n- 熟练的使用HTML、CSS和JavaScript进行Web前端开发，熟悉jQuery\r\n- 熟练掌握java面向对象思想, 集合, 泛型, IO流,多线程, JDBC以及熟悉反射,异常;\r\n- 熟练基于JSP和Servlet的Java Web开发,熟悉MVC思想 \r\n- 熟悉Hibernate,MybatisORM框架,SpringMVC,Struts2视图层框架\r\n- 熟悉Spring的IOC容器和AOP思想,及框架整合 \r\n- 熟悉Mysql,Oracle关系型数据库,能熟练地使用SQL和PL/SQL进行数据库编程\r\n- 熟练使用Eclipse工具, 熟悉Tomcat应用服务器的使用,了解SVN,Git,maven \r\n- 能独立开发各种管理系统的业务。\r\n\r\n--------\r\n\r\n\r\n# 获得证书\r\n\r\n- Java软件工程师证书\r\n\r\n--------\r\n\r\n# 兴趣爱好\r\n\r\n- 精通魔方\r\n- 象棋/五子棋\r\n\r\n--------\r\n\r\n#  自我评价\r\n\r\n- 融会贯通能力强\r\n- 本人有追求极致的精神\r\n- 个性文静，容易相处，团队荣誉感强\r\n\r\n--------\r\n', '<div id=\"result\">\r\n            <h1 id=\"\">个人信息</h1>\r\n                <ul>\r\n                    <li>张洪祥 / 男 /1998</li>\r\n                    <li>本科/南京理工大学紫金学院/软件开发专业</li>\r\n                    <li>老家:浙江省金华市/  现住:江苏省南京市</li>\r\n                </ul>\r\n                <hr>\r\n                <h1 id=\"-1\">联系方式</h1>\r\n                <ul>\r\n                    <li>QQ:    2500621077</li>\r\n                    <li>邮箱:    cuber.zhx@qq.com</li>\r\n                    <li>电话：15150576706 </li>\r\n                </ul>\r\n                <hr>\r\n                <h1 id=\"-2\">在校经历</h1>\r\n                <ul>\r\n                    <li>专业课成绩优异,获得过奖学金 </li>\r\n                    <li>熟练的使用HTML、CSS和JavaScript进行Web前端开发，熟悉jQuery</li>\r\n                    <li>熟练掌握java面向对象思想, 集合, 泛型, IO流,多线程, JDBC以及熟悉反射,异常;</li>\r\n                    <li>熟练基于JSP和Servlet的Java Web开发,熟悉MVC思想 </li>\r\n                    <li>熟悉Hibernate,MybatisORM框架,SpringMVC,Struts2视图层框架</li>\r\n                    <li>熟悉Spring的IOC容器和AOP思想,及框架整合 </li>\r\n                    <li>熟悉Mysql,Oracle关系型数据库,能熟练地使用SQL和PL/SQL进行数据库编程</li>\r\n                    <li>熟练使用Eclipse工具, 熟悉Tomcat应用服务器的使用,了解SVN,Git,maven </li>\r\n                    <li>能独立开发各种管理系统的业务。</li>\r\n                </ul>\r\n                <hr>\r\n                <h1 id=\"-3\">获得证书</h1>\r\n                <ul>\r\n                    <li>Java软件工程师证书</li>\r\n                </ul>\r\n                <hr>\r\n                <h1 id=\"-4\">兴趣爱好</h1>\r\n                <ul>\r\n                    <li>精通魔方</li>\r\n                    <li>象棋/五子棋</li>\r\n                </ul>\r\n                <hr>\r\n                <h1 id=\"-5\">自我评价</h1>\r\n                <ul>\r\n                    <li>融会贯通能力强</li>\r\n                    <li>本人有追求极致的精神</li>\r\n                    <li>个性文静，容易相处，团队荣誉感强</li>\r\n                </ul>\r\n                <hr>\r\n        </div>', '1', '自我介绍', '2019-07-01 20:57:31', '2019-07-26 18:49:39', '1', '199', '2', '4');
INSERT INTO `blog` VALUES ('25', '建站一个多月的记录,以及使用技术的心得', '以后再修改', '<p>以后再修改</p>\n', 'http://pic.coderzhx.cn/FjoaUXlNsBK_jlgiXTG34D5iUHk_', '建站记录以及心得!', '2019-08-10 16:11:47', '2019-08-15 14:40:13', '2', '22', '4', '0');
INSERT INTO `blog` VALUES ('26', '测试', '### 蛇\n# 洪\n![](/resource/upload/2019/8/16/9999999999999999999.png)', '<h3 id=\"h3-u86C7\"><a name=\"蛇\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>蛇</h3><h1 id=\"h1-u6D2A\"><a name=\"洪\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>洪</h1><p><img src=\"/resource/upload/2019/8/16/9999999999999999999.png\" alt=\"\">\n', 'http://pic.coderzhx.cn/FqfE9MNWhePLkq30w9l_nPDZs5WV', '测试', '2019-08-16 15:40:44', '2019-08-16 15:40:44', '1', '2', '2', '1');

-- ----------------------------
-- Table structure for `blog_category`
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('2', 'Thymeleaf', '2019-07-20 16:06:18', '2019-08-08 20:50:31', '1', '/blog/category/2', '1');
INSERT INTO `blog_category` VALUES ('3', 'Layui', '2019-08-08 20:51:39', '2019-08-08 20:51:42', '2', '/blog/category/3', null);
INSERT INTO `blog_category` VALUES ('4', '建站记录', '2019-08-15 14:36:20', null, null, '/blog/category/4', null);

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qq` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `common` text,
  `create_time` datetime DEFAULT NULL,
  `hits` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '990777580', '1', '1', '2019-07-17 21:27:28', '8', '1');
INSERT INTO `comment` VALUES ('3', '50647957', '为e', '二位', '2019-08-12 11:17:11', '0', '1');

-- ----------------------------
-- Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `description` text,
  `html_desc` text,
  `qq` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `wechatgzh` varchar(255) DEFAULT NULL,
  `beian` varchar(255) DEFAULT NULL,
  `wechat_icon` varchar(255) DEFAULT NULL,
  `weixinpay` varchar(255) DEFAULT NULL,
  `Alipay` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `github` varchar(255) DEFAULT NULL,
  `banquan` varchar(255) DEFAULT NULL,
  `tongji` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', '张洪祥', 'http://puu1qclkk.bkt.clouddn.com/cube2', 'coderzhx', '这是介绍', '<div id=\"result\"><hr>\n<h1 id=\"\">个人信息</h1>\n<ul>\n<li>张洪祥 / 男 /1998</li>\n<li>本科/南京理工大学紫金学院/软件开发专业</li>\n<li>老家:浙江省金华市/  现住:江苏省南京市</li>\n</ul>\n<hr>\n<h1 id=\"-1\">联系方式</h1>\n<ul>\n<li>QQ:    2500621077</li>\n<li>邮箱:    cuber.zhx@qq.com</li>\n<li>电话：15150576706 </li>\n</ul>\n<hr>\n<h1 id=\"-2\">在校经历</h1>\n<ul>\n<li>专业课成绩优异,获得过奖学金 </li>\n<li>熟练的使用HTML、CSS和JavaScript进行Web前端开发，熟悉jQuery</li>\n<li>熟练掌握java面向对象思想, 集合, 泛型, IO流,多线程, JDBC以及熟悉反射,异常;</li>\n<li>熟练基于JSP和Servlet的Java Web开发,熟悉MVC思想 </li>\n<li>熟悉Hibernate,MybatisORM框架,SpringMVC,Struts2视图层框架</li>\n<li>熟悉Spring的IOC容器和AOP思想,及框架整合 </li>\n<li>熟悉Mysql,Oracle关系型数据库,能熟练地使用SQL和PL/SQL进行数据库编程</li>\n<li>熟练使用Eclipse工具, 熟悉Tomcat应用服务器的使用,了解SVN,Git,maven </li>\n<li>能独立开发各种管理系统的业务。</li>\n</ul>\n<hr>\n<h1 id=\"-3\">获得证书</h1>\n<ul>\n<li>Java软件工程师证书</li>\n</ul>\n<hr>\n<h1 id=\"-4\">兴趣爱好</h1>\n<ul>\n<li>精通魔方</li>\n<li>象棋/五子棋</li>\n</ul>\n<hr>\n<h1 id=\"-5\">自我评价</h1>\n<ul>\n<li>融会贯通能力强</li>\n<li>本人有追求极致的精神</li>\n<li>个性文静，容易相处，团队荣誉感强</li>\n</ul>\n<hr></div>', '2500621077', '15150576706', '暂无', '浙ICP备19028608号', 'http://puu1qclkk.bkt.clouddn.com/weixinico', 'http://puu1qclkk.bkt.clouddn.com/weichat', 'http://puu1qclkk.bkt.clouddn.com/zhifubao', '个人博客,小张个人博客,小张,java,Spring', '一个在java学习过程中逐渐变强的男人', '小张个人博客 - 我是一个喜欢java的程序员这是我的个人博客网站', '2019-08-11 20:01:20', '在校大学生', 'https://github.com/wszhxo', 'Copyright2019张洪祥.AllRightsReserved.', '<script>\nvar _hmt = _hmt || [];\n(function() {\n  var hm = document.createElement(\"script\");\n  hm.src = \"https://hm.baidu.com/hm.js?cfe7728851ca6a336d3d6845fb244f55\";\n  var s = document.getElementsByTagName(\"script\")[0]; \n  s.parentNode.insertBefore(hm, s);\n})();\n</script>\n');

-- ----------------------------
-- Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isuse` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES ('1', '1', '杨青博客', '2', '2019-07-26 14:01:25', 'https://www.yangqq.com/');
INSERT INTO `link` VALUES ('2', '1', '我Github搭建的博客', '1', '2019-07-18 14:03:00', 'https://cuberzhx.cn/');
INSERT INTO `link` VALUES ('3', '1', '测试', '5', '2019-08-16 15:35:14', '测试');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '网站首页', '1', '1', null, '/');
INSERT INTO `menu` VALUES ('2', '0', '关于我', '6', '1', null, '/aboutme');
INSERT INTO `menu` VALUES ('3', '0', '时间轴', '5', '1', null, '/time');
INSERT INTO `menu` VALUES ('4', '0', '留言', '4', '1', null, '/message');
INSERT INTO `menu` VALUES ('5', '0', '资源分享', '3', '1', null, '/share');
INSERT INTO `menu` VALUES ('6', '0', '文章', '2', '0', null, '/');
INSERT INTO `menu` VALUES ('11', '0', '测试', null, '0', null, null);
INSERT INTO `menu` VALUES ('12', '11', '测试的儿子', null, '0', null, '/测试');

-- ----------------------------
-- Table structure for `menu_admin`
-- ----------------------------
DROP TABLE IF EXISTS `menu_admin`;
CREATE TABLE `menu_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_admin
-- ----------------------------
INSERT INTO `menu_admin` VALUES ('1', '0', '网站配置', '1', '1', null, null);
INSERT INTO `menu_admin` VALUES ('2', '0', '文章管理', '6', '1', null, null);
INSERT INTO `menu_admin` VALUES ('3', '0', '资源管理', '5', '1', null, null);
INSERT INTO `menu_admin` VALUES ('4', '1', '友情链接', '1', '1', null, '/admin/link');
INSERT INTO `menu_admin` VALUES ('12', '1', '前台菜单', '2', '1', null, '/menu');
INSERT INTO `menu_admin` VALUES ('13', '1', '后台菜单', '3', '1', null, '/adminMenu');
INSERT INTO `menu_admin` VALUES ('14', '1', '基础配置', '4', '1', null, '/config/');
INSERT INTO `menu_admin` VALUES ('15', '2', '文章列表', '1', '1', null, '/admin/blog');
INSERT INTO `menu_admin` VALUES ('16', '2', '标签管理', '2', '1', null, '/admin/tags');
INSERT INTO `menu_admin` VALUES ('17', '2', '分类管理', '3', '1', null, '/admin/category');
INSERT INTO `menu_admin` VALUES ('18', '0', '消息管理', '7', '1', null, '');
INSERT INTO `menu_admin` VALUES ('19', '18', '留言', '1', '1', null, '/admin/comment');
INSERT INTO `menu_admin` VALUES ('20', '3', '软件分享', null, '1', null, '/admin/share');

-- ----------------------------
-- Table structure for `resources`
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `resource` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('1', 'http://pic.coderzhx.cn/FjoaUXlNsBK_jlgiXTG34D5iUHk_', '3', '链接：https://pan.baidu.com/s/1MxuTgbIk4QKDyjxrySfmhg  提取码：rjzu  复制这段内容后打开百度网盘手机App，操作更方便哦');

-- ----------------------------
-- Table structure for `tags`
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) DEFAULT NULL,
  `tag_name` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES ('33', '25', 'Thymeleaf', '/blog/tags/Thymeleaf');
INSERT INTO `tags` VALUES ('37', '26', 'Thymeleaf', '/blog/tags/Thymeleaf');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'a7fe0f564abf904823e35bd2f41d03c5');

-- ----------------------------
-- Table structure for `visitcount`
-- ----------------------------
DROP TABLE IF EXISTS `visitcount`;
CREATE TABLE `visitcount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `reqUrl` varchar(255) DEFAULT NULL,
  `reqtime` datetime DEFAULT NULL,
  `reqcount` int(11) DEFAULT NULL,
  `browser` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ipindex` (`ip`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitcount
-- ----------------------------
INSERT INTO `visitcount` VALUES ('1', '127.0.0.1', null, '2019-08-15 15:51:11', '1', 'Chrome');
INSERT INTO `visitcount` VALUES ('2', '127.3.0.6', null, '2019-08-20 15:52:08', '3', 'Chrome');
INSERT INTO `visitcount` VALUES ('3', '0:0:0:0:0:0:0:1', null, '2019-08-15 15:56:12', '94', 'Chrome');
INSERT INTO `visitcount` VALUES ('4', '192.168.2.103', null, '2019-08-15 18:12:16', '4', 'Chrome');
