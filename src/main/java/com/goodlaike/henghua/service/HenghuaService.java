package com.goodlaike.henghua.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.goodlaike.business.core.support.LanguageStore;
import com.goodlaike.henghua.dao.HenghuaClothDao;
import com.goodlaike.henghua.dao.HenghuaSampleDao;
import com.goodlaike.henghua.dao.HenghuaSampleDetailDao;
import com.goodlaike.henghua.entity.model.HenghuaCloth;
import com.goodlaike.henghua.entity.model.HenghuaClothQuantity;
import com.goodlaike.henghua.entity.model.HenghuaExhibition;
import com.goodlaike.henghua.entity.model.HenghuaSample;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetail;
import com.goodlaike.henghua.entity.model.HenghuaSampleDetailQuantity;
import com.goodlaike.henghua.entity.model.VHenghuaSample;
import com.goodlaike.henghua.entity.model.Washing;
import com.goodlaike.henghua.protocal.RestHenghua;
import com.goodlaike.henghua.protocal.SearchFilter;

/**
 * 
 * @author jail
 */
@Service
@Lazy(true)
@EnableCaching(proxyTargetClass = true)
public class HenghuaService {

	@Autowired
	private HenghuaSampleDao henghuaSampleDao;
	@Autowired
	private HenghuaSampleDetailDao henghuaSampleDetailDao;
	@Autowired
	private HenghuaClothDao henghuaClothDao;
	@Autowired
	private RestHenghua restHenghua;

	/**
	 * 根据 样卡名获得样卡详情
	 * 
	 * @param cardId
	 *            样卡名
	 * @return HenghuaSample
	 * @author jail
	 */
	@Cacheable(value = "sample", key = "'HenghuaService.getSample.'+#cardId")
	public HenghuaSample getSample(String cardId) {
		HenghuaSample sample = henghuaSampleDao.findSample(cardId);
		if (sample != null) {
			bindSampleDetailData(Arrays.asList(sample));
		}
		return sample;
	}

	/**
	 * 样卡搜索
	 * 
	 * @param lang
	 * @param filter
	 * @return
	 * @author jail
	 */
	public List<HenghuaSample> searchSample(long id, String level, String style, String gramWeight, String season,
			String zuzhi, String fabrics, String colorTypes, String clearTypes, String materialTypes, String keys,
			boolean isNew) {
		List<HenghuaSample> list = this.henghuaSampleDao.search(id, level, style, gramWeight, season, zuzhi, fabrics,
				colorTypes, clearTypes, materialTypes, keys, isNew);
		bindSampleDetailData(list);
		return list;
	}

	/**
	 * 绑定样品数据到 detailList
	 * 
	 * @param list
	 * @summary
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年6月11日 下午7:46:23
	 */
	private void bindSampleDetailData(List<HenghuaSample> list) {
		if (list.size() == 0) {
			return;
		}
		Map<String, Object> map = list.stream().collect(Collectors.toMap(HenghuaSample::getCardId, (s) -> {
			return StringUtils.isNotBlank(s.getSampleList()) ? Arrays.asList(s.getSampleList().split(","))
					: Collections.emptyList();
		}));
		Map<String, List<HenghuaSampleDetail>> resultMap = this.getSampleDetailMap(map);
		list.forEach(sample -> {
			((VHenghuaSample) sample).setDetailList(resultMap.get(sample.getCardId()));
		});
	}

	/**
	 * 获取样品到样卡
	 * 
	 * @param sample
	 * @author jail
	 */
	private Map<String, List<HenghuaSampleDetail>> getSampleDetailMap(Map<String, Object> map) {
		return this.henghuaSampleDetailDao.findSampleDetails(map).stream()
				.collect(Collectors.groupingBy(HenghuaSampleDetail::getCardId));
	}

	/**
	 * 同步所有的样卡数据
	 * 
	 * @author jail
	 */
	public void syncAllSample() {
		List<HenghuaSample> list = this.restHenghua.restSampleAll();
		henghuaSampleDao.batchReplaceInto(list, true);
	}

	/**
	 * 同步单条样卡数据
	 * 
	 * @param cardId
	 *            样卡编码
	 * @return boolean
	 */
	public boolean syncSample(String cardId) {
		HenghuaSample sample = this.getSampleFromHost(cardId);
		if (sample == null) {
			return false;
		}
		return this.syncSample(sample);
	}

	/**
	 * 同步单条样卡数据
	 * 
	 * @param sample
	 * @return
	 */
	public boolean syncSample(HenghuaSample sample) {
		Assert.notNull(sample, "样卡数据不能为空");
		return this.henghuaSampleDao.batchReplaceInto(Arrays.asList(sample), false) == 1;
	}

	/**
	 * 根据 cardId 删除样卡
	 * 
	 * @param cardId
	 *            样卡 ID
	 * @return 影响行数
	 */
	@CacheEvict(value = "sample", key = "'HenghuaService.getSample.'+#cardId")
	public int deleteByCardId(String cardId) {
		return this.henghuaSampleDao.deleteByCardId(cardId);
	}

	/**
	 * 从官方主机获得样卡详情
	 * 
	 * @param cardId
	 *            样卡ID
	 * @return HenghuaSample
	 * @summary 从官方主机获得样卡详情
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年6月5日 上午11:34:09
	 */
	public HenghuaSample getSampleFromHost(String cardId) {
		return this.restHenghua.restSample(cardId);
	}

	/**
	 * 获得样品详情
	 * 
	 * @param detailName
	 * @return HenghuaSampleDetail
	 * @author jail
	 */
	@Cacheable(value = "sampleDetail", key = "'HenghuaService.getSampleDetail.'+#detailId")
	public HenghuaSampleDetail getSampleDetail(String detailId) {
		return this.henghuaSampleDetailDao.findSampleDetail(detailId);
	}

	/**
	 * 根据样品ID删除样品
	 * 
	 * @param detailId
	 *            样品ID
	 * @return
	 */
	@CacheEvict(value = "sampleDetail", key = "'HenghuaService.getSampleDetail.'+#detailId")
	public int deleteByDetailId(String detailId) {
		return this.henghuaSampleDetailDao.deleteByDetailId(detailId);
	}

	/**
	 * 从官方主机根据样品编号获得样品详情
	 * 
	 * @param detailId
	 *            样品编号
	 * @return HenghuaSampleDetail2
	 * @summary 从官方主机根据样品编号获得样品详情
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年6月5日 下午4:27:20
	 */
	public HenghuaSampleDetail getSampleDetailFromHost(String detailId) {
		return this.restHenghua.restSampleDatail(detailId);
	}

	/**
	 * 获得指定样品库存信息
	 * 
	 * @param detailId
	 *            样品编码
	 * @return HenghuaSampleDetailQuantity
	 */
	public HenghuaSampleDetailQuantity getSampleDetailQuantity(String detailId) {
		return this.restHenghua.restSampleDetailQuantity(detailId);
	}

	/**
	 * 同步所有的样卡数据
	 * 
	 * @author jail
	 */
	public void syncAllSampleDetail() {
		List<HenghuaSampleDetail> list = this.restHenghua.restSampleDatailAll();
		this.henghuaSampleDetailDao.batchReplaceInto(list, true);
	}

	/**
	 * 根据样品ID同步指定样品数据
	 * 
	 * @param detailId
	 *            样品ID
	 * @summary 同步指定样品数据
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年6月5日 下午5:50:51
	 */
	public boolean syncSampleDetail(String detailId) {
		HenghuaSampleDetail detail = this.restHenghua.restSampleDatail(detailId);
		return this.syncSampleDetail(detail);
	}

	/**
	 * 根据样品对象同步指定样品数据
	 * 
	 * @param detail
	 *            样品对象
	 * @summary 根据样品对象同步指定样品数据
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年6月5日 下午6:09:12
	 */
	public boolean syncSampleDetail(HenghuaSampleDetail detail) {
		Assert.notNull(detail, "样品数据不能为空");
		Assert.hasText(detail.getDetailId(), "the argument [detailId] must not be null or empty");
		return this.henghuaSampleDetailDao.batchReplaceInto(Arrays.asList(detail), false) == 1;
	}

	/**
	 * 同步服装数据
	 * 
	 * @author jail
	 */
	public void syncAllCloth() {
		henghuaClothDao.batchReplaceInto(this.restHenghua.restClothAll(), true);
	}

	/**
	 * 获得指定服装
	 * 
	 * @param serialNo
	 * @return
	 * @author jail
	 */
	@Cacheable(value = "cloth", key = "'HenghuaService.getCloth.'+#serialNo")
	public HenghuaCloth getCloth(String serialNo) {
		return henghuaClothDao.findCloth(serialNo);
	}

	/**
	 * 根据 SerialNo 删除服装
	 * 
	 * @param serialNo
	 * @return
	 */
	@CacheEvict(value = "cloth", key = "'HenghuaService.getCloth.'+#serialNo")
	public int deleteBySerialNo(String serialNo) {
		return this.henghuaClothDao.deleteBySerialNo(serialNo);
	}

	/**
	 * 从官方主机根据服装编号获得服装详情
	 * 
	 * @param serialNo
	 *            服装编号
	 * @return HenghuaCloth
	 */
	public HenghuaCloth getClothFromHost(String serialNo) {
		return this.restHenghua.restCloth(serialNo);
	}

	/**
	 * 单条 同步 服装信息
	 * 
	 * @param cloth
	 *            服装对象
	 * @return boolean
	 */
	public boolean syncCloth(HenghuaCloth cloth) {
		Assert.notNull(cloth, "the argument [cloth] must not be null");
		return this.henghuaClothDao.batchReplaceInto(Arrays.asList(cloth), false) == 1;
	}

	/**
	 * 单条 同步 服装信息
	 * 
	 * @param serialNo
	 *            服装编号
	 * @return boolean
	 */
	public boolean syncCloth(String serialNo) {
		HenghuaCloth cloth = this.getClothFromHost(serialNo);
		return this.syncCloth(cloth);
	}

	/**
	 * 获得指定服装库存信息
	 * 
	 * @param sonSerialNo
	 *            服装子序列号，对应 {@link HenghuaCloth#getSonCodeList()}
	 * @return HenghuaClothQuantity
	 * @summary 获得指定服装库存信息
	 * @author Jail Hu
	 * @version v1
	 * @since 2016年7月10日 下午9:50:32
	 */
	@Cacheable(value = "cloth", key = "'HenghuaService.getClothQuantity.'+#sonSerialNo")
	public HenghuaClothQuantity getClothQuantity(String sonSerialNo) {
		return this.restHenghua.restClothQuantity(sonSerialNo);
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
	public List<HenghuaCloth> searchCloth(long id, String material, String wearStyle, String mainColor, String style,
			String onUnderStyle, String name, String keys) {
		return this.henghuaClothDao.search(id, material, wearStyle, mainColor, style, onUnderStyle, name, keys);
	}

	/**
	 * 获得 样品分类
	 * 
	 * @param lang
	 * @return
	 * @author jail
	 */
	@Cacheable(value = "globalConfig", key = "'HenghuaService.getSampleType.'+#lang")
	public List<SearchFilter> getSampleType(String lang) {
		lang = LanguageStore.getLanguage(lang);
		Map<String, List<String>> map = this.restHenghua.restSampleType(lang);
		List<SearchFilter> filterList = new ArrayList<>();
		map.forEach((k, v) -> {
			filterList.add(new SearchFilter(k, v, SearchFilter.FilterType.SAMPLE));
		});
		return filterList;
	}

	/**
	 * 获得洗标缓存MAP
	 * 
	 * @return
	 * @author jail
	 */
	@Cacheable(value = "globalConfig", key = "'HenghuaService.getWashingAllMap'")
	public Map<Integer, Washing> getWashingAllMap() {
		return this.restHenghua.restWashingAllMap();
	}

	/**
	 * 获得 服装分类
	 * 
	 * @return List<SampleFilter>
	 * @author jail
	 */
	@Cacheable(value = "globalConfig", key = "'HenghuaService.getClothType'")
	public List<SearchFilter> getClothType() {
		Map<String, List<String>> map = this.restHenghua.restClothType();
		List<SearchFilter> filterList = new ArrayList<>();
		map.forEach((k, v) -> {
			filterList.add(new SearchFilter(k, v, SearchFilter.FilterType.CLOTH));
		});
		return filterList;
	}

	public void test() {
		this.henghuaSampleDetailDao.test();
	}

	/**
	 * 获得最新活动列表(所有)
	 * 
	 * @return List<HenghuaExhibition>
	 */
	@Cacheable(value = "globalConfig", key = "'HenghuaService.getExhibitionAll'")
	public List<HenghuaExhibition> getExhibitionAll() {
		return this.restHenghua.restHenghuaExhibitionAll();
	}
}
