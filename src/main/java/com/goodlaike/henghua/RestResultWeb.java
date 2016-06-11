package com.goodlaike.henghua;

import com.goodlaike.business.core.support.RestResult;

/**
 * 
 * @author jail
 */
public class RestResultWeb extends RestResult{

    private static final long serialVersionUID = 1L;

    /**
     * 服务器异常
     */
    public static final RestResult SERVERERROR = RestResult.code(500).message("服务器异常【{?}】");
}
