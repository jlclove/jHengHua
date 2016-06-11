package com.goodlaike.henghua.config;

/**
 * Created with IntelliJ IDEA. Author: Jerry.hu Create: Jerry.hu (14-5-9 12:55)
 * Description: 公用常量类
 */
public final class BaseConstants {

	/**
	 * 配置文件编码
	 */
	public static final String ENCODING = "utf-8";
	/**
	 * 测试环境 env 常量
	 */
	public static final String ENV_DEVELOPMENT = "development";

	/**
	 * 集成环境 env 常量
	 */
	public static final String ENV_INTEGRATION = "integration";

	/**
	 * 生产环境 env 常量
	 */
	public static final String ENV_PRODUCTION = "production";

	/**
	 * mysql 新增字段和备注
	 * eg:ALTER TABLE {表名 0} ADD COLUMN {字段1} {类型2} {(长度3)} {4是否必填} {DEFAULT 5}COMMENT '{备注信息6}' ;
	 */
	public static final String MYSQL_ALTER_CREATE = "ALTER TABLE {0} ADD COLUMN {1} {2}{3} {4} {5} COMMENT '{6}' ";
	/**
	 * mysql 删除一列
	 * eg:ALTER TABLE {表名} DROP COLUMN {字段名称}
	 */
	public static final String MYSQL_ALTER_DROP = "ALTER TABLE {0} DROP COLUMN {1}";

	/**
	 * 用户密码的修饰前缀
	 */
	public static final String PASSWORD_PREFIX_USER = "GLU";
	/**
	 * 超级用户密码的修饰前缀
	 */
	public static final String PASSWORD_PREFIX_SUPERUSER = "GLSU";
}
