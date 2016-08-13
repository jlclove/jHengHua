package com.goodlaike.henghua.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.business.core.controller.BaseRestController;
import com.goodlaike.business.core.helper.LanguageHelper;
import com.goodlaike.business.core.support.RestResult;
import com.goodlaike.henghua.RestResultWeb;
import com.goodlaike.henghua.entity.model.HenghuaCloth;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetailQuantity;
import com.goodlaike.henghua.service.HenghuaService;

/**
 * henghua 控制器
 * 
 * @author jail
 */
@RestController
@RequestMapping("henghua")
public class RestHenghuaController extends BaseRestController {

	@Autowired
	private HenghuaService henghuaService;

	/**
	 * 获得样卡分类列表
	 * 
	 * @param request
	 * @return
	 * @since 1.0.0
	 * @author jail
	 * @createTime 2015年9月4日下午12:00:20
	 * @updator jail
	 * @updateTime 2015年9月4日下午12:00:20
	 */
	@RequestMapping("sample/type")
	protected ResponseEntity<?> getSampleType(HttpServletRequest request) {
		return ResponseEntity.ok(henghuaService.getSampleType(LanguageHelper.getLocalization(request)));
	}

	/**
	 * 获得样卡详情数据
	 * 
	 * @param request
	 * @param cardId
	 * @return
	 * @since 1.0.0
	 * @author jail
	 * @createTime 2015年9月5日下午2:05:58
	 * @updator jail
	 * @updateTime 2015年9月5日下午2:05:58
	 */
	@RequestMapping(value = "sample/{cardId}", method = RequestMethod.GET)
	protected ResponseEntity<?> getSample(HttpServletRequest request, @PathVariable String cardId) {
		return ResponseEntity.ok(henghuaService.getSample(cardId));
	}

	/**
	 * 获得样品详情
	 * 
	 * @param request
	 * @param detailName
	 * @return
	 * @since 1.0.0
	 * @author jail
	 * @createTime 2015年9月4日下午11:58:23
	 * @updator jail
	 * @updateTime 2015年9月4日下午11:58:23
	 */
	@RequestMapping(value = "sample/detail/{detailId}", method = RequestMethod.GET)
	protected ResponseEntity<?> getSampleDetail(HttpServletRequest request, @PathVariable String detailId) {
		HenghuaSampleDetail detail = henghuaService.getSampleDetail(detailId);
		return detail == null ? super.notFound(RestResultWeb.NOTFOUND) : ResponseEntity.ok(detail);
	}

	/**
	 * 获得样品库存
	 * 
	 * @param request
	 * @param detailId
	 * @return
	 * @summary
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年7月10日 下午8:00:14
	 */
	@RequestMapping(value = "sample/detail/{detailId}/quantity", method = RequestMethod.GET)
	protected ResponseEntity<?> getSampleDetailQuantity(HttpServletRequest request, @PathVariable String detailId) {
		HenghuaSampleDetailQuantity detail = henghuaService.getSampleDetailQuantity(detailId);
		return detail == null ? super.notFound(RestResultWeb.NOTFOUND) : ResponseEntity.ok(detail);
	}

	/**
	 * 样卡搜索
	 * 
	 * @param request
	 * @param id
	 * @param level
	 * @param style
	 * @param gramWeight
	 * @param season
	 * @param zuzhi
	 * @param fabrics
	 * @param colorTypes
	 * @param clearTypes
	 * @param materialTypes
	 * @param keys
	 * @return
	 * @summary
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年7月11日 下午9:26:26
	 */
	@RequestMapping(value = "sample/search", method = RequestMethod.GET)
	protected ResponseEntity<?> searchSample(HttpServletRequest request,
			@RequestParam(value = "sinceId", defaultValue = "0") long id,
			@RequestParam(value = "level", required = false) String level,
			@RequestParam(value = "style", required = false) String style,
			@RequestParam(value = "gramWeight", required = false) String gramWeight,
			@RequestParam(value = "season", required = false) String season,
			@RequestParam(value = "zuzhi", required = false) String zuzhi,
			@RequestParam(value = "fabrics", required = false) String fabrics,
			@RequestParam(value = "colorTypes", required = false) String colorTypes,
			@RequestParam(value = "clearTypes", required = false) String clearTypes,
			@RequestParam(value = "materialTypes", required = false) String materialTypes,
			@RequestParam(value = "keys", required = false) String keys,
			@RequestParam(value = "isNew", required = false, defaultValue = "0") boolean isNew) {
		return ResponseEntity.ok(this.henghuaService.searchSample(id == 0 ? Long.MAX_VALUE : id, level, style,
				gramWeight, season, zuzhi, fabrics, colorTypes, clearTypes, materialTypes, keys, isNew));
	}

	/**
	 * 获得服装详情1（父详情，对应列表到详情页）
	 * 
	 * @param request
	 * @param serialNo
	 * @return
	 * @since 1.0.0
	 * @author jail
	 * @createTime 2015年9月5日下午4:45:11
	 * @updator jail
	 * @updateTime 2015年9月5日下午4:45:11
	 */
	@RequestMapping(value = "cloth/{serialNo}", method = RequestMethod.GET)
	protected ResponseEntity<?> getCloth(HttpServletRequest request, @PathVariable String serialNo) {
		HenghuaCloth clothDetail = henghuaService.getCloth(serialNo);
		return clothDetail == null ? super.notFound(RestResult.NOTFOUND) : ResponseEntity.ok(clothDetail);
	}

	/**
	 * 获得服装详情2（子详情）
	 * 
	 * @param request
	 * @param serialNo
	 * @return
	 * @since 1.0.0
	 * @author jail
	 * @createTime 2015年9月5日下午4:35:56
	 * @updator jail
	 * @updateTime 2015年9月5日下午4:35:56
	 */
	@RequestMapping(value = "cloth/detail/{serialNo}", method = RequestMethod.GET)
	protected ResponseEntity<?> getClothDetail(HttpServletRequest request, @PathVariable String serialNo) {
		HenghuaCloth cloth = this.henghuaService.getCloth(serialNo);
		return cloth == null ? super.notFound(RestResult.NOTFOUND) : ResponseEntity.ok(cloth);
	}

	/**
	 * 获得所有洗标
	 * 
	 * @param request
	 * @return
	 * @since 1.0.0
	 * @author jail
	 * @createTime 2015年9月5日下午5:20:40
	 * @updator jail
	 * @updateTime 2015年9月5日下午5:20:40
	 */
	@RequestMapping(value = "washing", method = RequestMethod.GET)
	protected ResponseEntity<?> getWashingMap(HttpServletRequest request) {
		return ResponseEntity.ok(henghuaService.getWashingAllMap());
	}

	/**
	 * 获得服装分类
	 * 
	 * @return
	 * @since 1.0.0
	 * @author jail
	 * @createTime 2015年9月5日下午6:54:53
	 * @updator jail
	 * @updateTime 2015年9月5日下午6:54:53
	 */
	@RequestMapping(value = "cloth/type", method = RequestMethod.GET)
	protected ResponseEntity<?> getClothType() {
		return ResponseEntity.ok(this.henghuaService.getClothType());
	}

	/**
	 * 服装搜索
	 * 
	 * @param id
	 *            其实ID
	 * @param material
	 *            原料，多选，用“,”号间隔
	 * @param wearStyle
	 *            穿着类别
	 * @param mainColor
	 *            颜色，多选，用“,”号间隔
	 * @param style
	 *            样式
	 * @param onUnderStyle
	 *            上下类别
	 * @param name
	 *            商品名称，多选，用“,”号间隔
	 * @param keys
	 *            关键词
	 * @return List<HenghuaCloth>
	 * @summary 服装搜索
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年7月11日 下午9:03:17
	 */
	@RequestMapping(value = "cloth/search", method = RequestMethod.GET)
	protected ResponseEntity<?> searchCloth(@RequestParam(value = "sinceId", defaultValue = "0") long id,
			@RequestParam(value = "material", required = false) String material,
			@RequestParam(value = "wearStyle", required = false) String wearStyle,
			@RequestParam(value = "mainColor", required = false) String mainColor,
			@RequestParam(value = "style", required = false) String style,
			@RequestParam(value = "onUnderStyle", required = false) String onUnderStyle,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "keys", required = false) String keys) {
		return ResponseEntity.ok(
				this.henghuaService.searchCloth(id, material, wearStyle, mainColor, style, onUnderStyle, name, keys));
	}
}
