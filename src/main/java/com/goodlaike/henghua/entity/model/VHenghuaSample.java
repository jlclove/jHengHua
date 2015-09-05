package com.goodlaike.henghua.entity.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @author jail
 */
@Alias("vSample")
public class VHenghuaSample extends HenghuaSample {

    private static final long serialVersionUID = 5227356351542906864L;

    public List<HenghuaSampleDetail> detailList = new ArrayList<>();
}
