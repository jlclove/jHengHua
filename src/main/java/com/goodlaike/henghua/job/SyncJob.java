package com.goodlaike.henghua.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.goodlaike.henghua.service.HenghuaService;

/**
 * 同步数据
 * 
 * @author Jail Hu
 *
 */
@Component
public class SyncJob {

	@Autowired
	private HenghuaService henghuaService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// 同步所有的样卡数据
	@Scheduled(cron = "0 0 3 * * *")
	public void syncAllSample() {
		StopWatch sw = new StopWatch();
		sw.start();
		logger.info("===>> 开始同步样卡");
		this.henghuaService.syncAllSample();
		sw.stop();
		logger.info("===>> 样卡同步完毕,共耗时：" + sw.getTotalTimeMillis() + "ms");
	}

	// 同步所有样品数据
	@Scheduled(cron = "10 0 3 * * *")
	public void syncAllSampleDetail() {
		StopWatch sw = new StopWatch();
		sw.start();
		logger.info("===>> 开始同步样品");
		this.henghuaService.syncAllSampleDetail();
		sw.stop();
		logger.info("===>> 样品同步完毕,共耗时：" + sw.getTotalTimeMillis() + "ms");
	}

	// 同步所有服装款式
	@Scheduled(cron = "20 0 3 * * *")
	public void syncAllCloth() {
		StopWatch sw = new StopWatch();
		sw.start();
		logger.info("===>> 开始同步服装");
		this.henghuaService.syncAllCloth();
		sw.stop();
		logger.info("===>> 服装同步完毕,共耗时：" + sw.getTotalTimeMillis() + "ms");
	}
}
