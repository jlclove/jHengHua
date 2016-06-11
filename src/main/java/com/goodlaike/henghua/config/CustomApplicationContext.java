package com.goodlaike.henghua.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @Description: SpringContext辅助类，用于在非spring管理的类中获取spring管理的bean
 */
@Component
public class CustomApplicationContext implements ApplicationContextAware {

  private static ApplicationContext context;


  /**
   * 根据类型获取SpringContext中的bean
   * 
   * @param clazz
   * @return
   */
  public static <T> T getBeanByName(String beanName, Class<T> clazz) {
    return context.getBean(beanName, clazz);
  }

  /**
   * 根据类型获取SpringContext中的bean
   * 
   * @param clazz
   * @return
   */
  public static <T> T getBeanByClass(Class<T> clazz) {
    return context.getBean(clazz);
  }

  @Override
  public void setApplicationContext(ApplicationContext arg0) throws BeansException {
    context = arg0;
  }

}
