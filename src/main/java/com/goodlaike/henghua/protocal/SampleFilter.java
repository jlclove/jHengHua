package com.goodlaike.henghua.protocal;

import java.io.Serializable;
import java.util.List;

public class SampleFilter implements Serializable {

  private static final long serialVersionUID = 1L;
  private String text;
  private String column;
  private List<String> values;
  /**
   * 是否多选
   */
  private boolean multiOption = false;

  /**
   * 获得 text
   * 
   * @return String
   */
  public String getText() {
    return text;
  }

  /**
   * 设置 text
   * 
   * @param text String
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * 获得 column
   * 
   * @return String
   */
  public String getColumn() {
    return column;
  }

  /**
   * 设置 column
   * 
   * @param column String
   */
  public void setColumn(String column) {
    this.column = column;
  }

  /**
   * 获得 values
   * 
   * @return List<String>
   */
  public List<String> getValues() {
    return values;
  }

  /**
   * 设置 values
   * 
   * @param values List<String>
   */
  public void setValues(List<String> values) {
    this.values = values;
  }

  /**
   * 获得 multiOption
   * @return boolean
   */
  public boolean isMultiOption() {
    return multiOption;
  }

  /**
   * 设置  multiOption
   * @param multiOption boolean
   */
  public void setMultiOption(boolean multiOption) {
    this.multiOption = multiOption;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "SampleFilter [text=" + text + ", column=" + column + ", values=" + values + "]";
  }

  public SampleFilter() {
    // TODO Auto-generated constructor stub
  }

  public SampleFilter(String text, List<String> values) {
    this.text = text;
    this.column = this.convertTextToColumn(text);
    this.values = values;
    this.multiOption = this.convertTextToMultiOption(text);
  }

  /**
   * 从接口文本转化为数据列
   * @param text
   * @return
   * @summary
   * @author Jail Hu
   * @version v1
   * @since 2016年7月10日 下午8:17:04
   */
  private String convertTextToColumn(String text) {
    switch (text) {
      case "克重":
        return "gramWeight";
      case "品级":
        return "level";
      case "季节":
        return "season";
      case "组织":
        return "zuzhi";
      case "风格":
        return "style";
      case "织物名称":
        return "fabrics";
      case "颜色": // 多选
        return "colorTypes";
      case "整理方式": // 多选
        return "clearTypes";
      case "原料": // 多选
        return "materialTypes";
      default:
        return "";
    }
  }
  
  /**
   * 设置是否多选的属性
   * @param text
   * @return
   * @summary
   * @author Jail Hu
   * @version v1
   * @since 2016年7月10日 下午8:16:52
   */
  private boolean convertTextToMultiOption(String text) {
    switch (text) {
      case "原料": 
      case "颜色":
      case "整理方式":
        return true;
      default:
        return false;
    }
  }
}
