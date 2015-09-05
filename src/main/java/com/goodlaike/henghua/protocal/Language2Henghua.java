package com.goodlaike.henghua.protocal;

import com.goodlaike.business.core.support.Constants;
import com.goodlaike.business.core.support.LanguageStore;

/**
 * 本地化语言对恒华的语言转换
 * 
 * @author jail
 */
public class Language2Henghua {

    /**
     * 根据语言获得恒华的语言ID <br>
     * 中文 cn = 0 <br>
     * 英文 en = 1
     * 
     * @param lang
     *            语言参数
     * @return int
     * @since 1.0.0
     * @author jail
     * @createTime 2015年9月3日下午9:53:34
     * @updator jail
     * @updateTime 2015年9月3日下午9:53:34
     */
    public static int getHenghuaParameter(String lang) {
        switch (LanguageStore.getLanguage(lang)) {
        case Constants.DEFAULT_LOCALIZATION:
            return 0;
        case "en":
            return 1;
        default:
            return 0;
        }
    }
}
