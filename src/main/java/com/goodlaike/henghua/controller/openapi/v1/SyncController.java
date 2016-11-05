package com.goodlaike.henghua.controller.openapi.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.business.core.controller.BaseRestController;
import com.goodlaike.henghua.RestResultWeb;
import com.goodlaike.henghua.entity.model.HenghuaCloth;
import com.goodlaike.henghua.entity.model.HenghuaSample;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.service.HenghuaService;

@RequestMapping("v1/sync")
@RestController
public class SyncController extends BaseRestController {

	@Autowired
	private HenghuaService henghuaService;

	/**
	 * 样品同步（完整数据）
	 * 
	 * @param params
	 *            {@link HenghuaSampleDetail}
	 * @return
	 */
	@RequestMapping(value = "sampleDetail", method = RequestMethod.POST)
	protected ResponseEntity<?> syncSampleDetail(@RequestParam(name = "detailId", required = false) String detailId,
			@RequestParam(name = "desc_jpg", required = false) String desc_jpg,
			@RequestParam(name = "desc_png", required = false) String desc_png,
			@RequestParam(name = "desc_video", required = false) String desc_video,
			@RequestParam(name = "cardIds", required = false) String cardIds,
			@RequestParam(name = "nameCn", required = false) String nameCn,
			@RequestParam(name = "nameEn", required = false) String nameEn,
			@RequestParam(name = "level", required = false) String level,
			@RequestParam(name = "material", required = false) String material,
			@RequestParam(name = "style", required = false) String style,
			@RequestParam(name = "season", required = false) String season,
			@RequestParam(name = "gramWeight", required = false) String gramWeight,
			@RequestParam(name = "fabrics", required = false) String fabrics,
			@RequestParam(name = "tissue", required = false) String zuzhi,
			@RequestParam(name = "colorTypes", required = false) String colorTypes,
			@RequestParam(name = "materialTypes", required = false) String materialTypes,
			@RequestParam(name = "clearTypes", required = false) String clearTypes,
			@RequestParam(name = "breadth", required = false) String breadth) {
		Assert.hasText(detailId, "the argument [detailId] must not be null or empty");
		HenghuaSampleDetail detail = new HenghuaSampleDetail();
		detail.setDetailId(detailId);
		detail.setCardIds(cardIds);
		detail.setDesc_jpg(desc_jpg);
		detail.setDesc_png(desc_png);
		detail.setDesc_video(desc_video);
		detail.setNameCn(nameCn);
		detail.setNameEn(nameEn);
		detail.setLevel(level);
		detail.setMaterial(materialTypes);
		detail.setStyle(style);
		detail.setSeason(season);
		detail.setGramWeight(gramWeight);
		detail.setFabrics(fabrics);
		detail.setZuzhi(zuzhi);
		detail.setColorTypes(colorTypes);
		detail.setMaterialTypes(materialTypes);
		detail.setClearTypes(clearTypes);
		detail.setBreadth(breadth);
		try {
			this.henghuaService.syncSampleDetail(detail);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 样品同步（根据样品ID）
	 * 
	 * @param detailId
	 *            样品ID
	 * @return
	 */
	@RequestMapping(value = "sampleDetail/{detailId}", method = { RequestMethod.POST, RequestMethod.PUT })
	protected ResponseEntity<?> syncSampleDetailByDetailId(@PathVariable("detailId") String detailId) {
		Assert.hasText(detailId, "the argument [detailId] must not be null or empty");
		try {
			if (this.henghuaService.syncSampleDetail(detailId)) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 样品同步（根据样品ID删除）
	 * 
	 * @param detailId
	 *            样品ID
	 * @return
	 */
	@RequestMapping(value = "sampleDetail/{detailId}", method = { RequestMethod.DELETE })
	protected ResponseEntity<?> deleteSampleDetailByDetailId(@PathVariable("detailId") String detailId) {
		try {
			this.henghuaService.deleteByDetailId(detailId);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 样卡同步（根据样卡ID）
	 * 
	 * @param cardId
	 *            样卡ID
	 * @return
	 */
	@RequestMapping(value = "sample/{cardId}", method = { RequestMethod.POST, RequestMethod.PUT })
	protected ResponseEntity<?> syncSampleByCardId(@PathVariable("cardId") String cardId) {
		Assert.hasText(cardId, "the argument [cardId] must not be null or empty");
		try {
			if (this.henghuaService.syncSample(cardId)) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 样卡同步（直接样卡数据）
	 * 
	 * @param {@link
	 * 			HenghuaSample}
	 * @return
	 */
	@RequestMapping(value = "sample", method = { RequestMethod.POST })
	protected ResponseEntity<?> syncSample(@RequestParam(name = "cardId", required = false) String cardId,
			@RequestParam(name = "alias", required = false) String alias,
			@RequestParam(name = "nick", required = false) String nick,
			@RequestParam(name = "sampleList", required = false) String sampleList,
			@RequestParam(name = "material", required = false) String material,
			@RequestParam(name = "descCn", required = false) String descCn,
			@RequestParam(name = "descEn", required = false) String descEn,
			@RequestParam(name = "cardCreateTime", required = false) String cardCreateTime) {
		Assert.hasText(cardId, "the argument [cardId] must not be null or empty");
		HenghuaSample sample = new HenghuaSample();
		sample.setCardId(cardId);
		sample.setAlias(alias);
		sample.setNick(nick);
		sample.setSampleList(sampleList);
		sample.setMaterial(material);
		sample.setDescCn(descCn);
		sample.setDescEn(descEn);
		if (!StringUtils.isEmpty(cardCreateTime)) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				sample.setCardCreateTime(df.parse(cardCreateTime));
			} catch (ParseException e) {
				return super.serverError(RestResultWeb.SERVERERROR.rebuild("建卡日期格式不合法，必须是【yyyy-MM-dd HH:mm:ss】 格式"));
			}
		}
		try {
			this.henghuaService.syncSample(sample);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 样卡同步（根据样卡ID 删除）
	 * 
	 * @param cardId
	 *            样卡ID
	 * @return
	 */
	@RequestMapping(value = "sample/{cardId}", method = { RequestMethod.DELETE })
	protected ResponseEntity<?> deleteSampleByCardId(@PathVariable("cardId") String cardId) {
		try {
			this.henghuaService.deleteByCardId(cardId);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 服装同步（根据 serialNo）
	 * 
	 * @param serialNo
	 * @return
	 */
	@RequestMapping(value = "cloth/{serialNo}", method = { RequestMethod.POST, RequestMethod.PUT })
	protected ResponseEntity<?> syncClothBySerialNo(@PathVariable("serialNo") String serialNo) {
		Assert.hasText(serialNo, "the argument [serialNo] must not be null or empty");
		try {
			if (this.henghuaService.syncCloth(serialNo)) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 服装同步 （直接服装数据）
	 * 
	 * @param serialNo
	 * @return
	 */
	@RequestMapping(value = "cloth", method = { RequestMethod.POST })
	protected ResponseEntity<?> syncCloth(@RequestParam(value = "serialNo", required = false) String serialNo,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "desc_jpg", required = false) String desc_jpg,
			@RequestParam(value = "desc_png", required = false) String desc_png,
			@RequestParam(value = "desc_video", required = false) String desc_video,
			@RequestParam(value = "sonCodeList", required = false) String sonCodeList,
			@RequestParam(value = "sizeList", required = false) String sizeList,
			@RequestParam(value = "onUnderStyle", required = false) String onUnderStyle,
			@RequestParam(value = "wearStyle", required = false) String wearStyle,
			@RequestParam(value = "style", required = false) String style,
			@RequestParam(value = "material", required = false) String material,
			@RequestParam(value = "mainColor", required = false) String mainColor,
			@RequestParam(value = "detailId", required = false) String detailId,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "unit", required = false) String unit,
			@RequestParam(value = "washCodes", required = false) String washCodes) {
		Assert.hasText(serialNo, "the argument [serialNo] must not be null or empty");
		HenghuaCloth cloth = new HenghuaCloth();
		cloth.setSerialNo(serialNo);
		cloth.setName(name);
		cloth.setDesc_jpg(desc_jpg);
		cloth.setDesc_png(desc_png);
		cloth.setDesc_video(desc_video);
		cloth.setSonCodeList(sonCodeList);
		cloth.setSizeList(sizeList);
		cloth.setOnUnderStyle(onUnderStyle);
		cloth.setWearStyle(wearStyle);
		cloth.setStyle(style);
		cloth.setMaterial(material);
		cloth.setMainColor(mainColor);
		cloth.setDetailId(detailId);
		cloth.setPrice(price);
		cloth.setUnit(unit);
		cloth.setWashCodes(washCodes);
		try {
			this.henghuaService.syncCloth(cloth);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}

	/**
	 * 服装同步（根据 serialNo删除）
	 * 
	 * @param serialNo
	 * @return
	 */
	@RequestMapping(value = "cloth/{serialNo}", method = { RequestMethod.DELETE })
	protected ResponseEntity<?> deleteClothBySerialNo(@PathVariable("serialNo") String serialNo) {
		try {
			this.henghuaService.deleteBySerialNo(serialNo);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return super.serverError(RestResultWeb.SERVERERROR.rebuild(e.getMessage()));
		}
	}
}
