package com.goodlaike.henghua.entity.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 
 * @author jail
 */
@Alias("vSample")
@JSONType(asm = false)
public class VHenghuaSample extends HenghuaSample {

  private static final long serialVersionUID = 1L;

  private List<HenghuaSampleDetail> detailList = new ArrayList<>();

  public List<HenghuaSampleDetail> getDetailList() {
    return detailList;
  }

  public void setDetailList(List<HenghuaSampleDetail> detailList) {
    this.detailList = detailList;
  }
}
