package com.goodlaike.henghua.utils;

import org.apache.commons.lang3.StringUtils;

import com.goodlaike.framework.tools.utils.CoderUtil;

/**
 * 该死的恒华json工具类
 * 
 * @summary
 * @author Jail Hu
 * @Copyright (c) 2016, Lianjia Group All Rights Reserved.
 */
public final class HenghuaDamnJsonUtil {


  public static String format(String jsonStr) {
    if (StringUtils.isBlank(jsonStr)) {
      return jsonStr;
    }
    jsonStr = CoderUtil.decodeUnicode(jsonStr);
    // 将不合法的空数组转换成合法的数组表达式
    jsonStr = jsonStr.replaceAll("\\[\"\"\\]", "[]");
    // 将不合法的对象转换成合法的对象表达式
    // 该死的花括号处理
    jsonStr = jsonStr.replaceAll("\"\\{", "{").replaceAll("\\}\"", "}");
    // 该死的双引号处理
    jsonStr = jsonStr.replaceAll("\\\\\\\"", "\"");
    return jsonStr;
  }
  
  public static String formatForRegex(String jsonStr) {
    if (StringUtils.isBlank(jsonStr)) {
      return jsonStr;
    }
//    jsonStr = CoderUtil.decodeUnicode(jsonStr);
    // 去掉换行符与换行符的空格
    jsonStr = jsonStr.replaceAll("\\\\r\\\\n[ ]*","");
    // 将神奇的双引号变成标准的
    jsonStr = jsonStr.replaceAll("\\\\", "");
    return jsonStr;
  }
}
