package com.goodlaike.henghua.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

	// 同步所有样品数据
	@Scheduled(cron = "0 0 3 * * *")
	public void syncAllSampleDetail() {
		this.henghuaService.syncAllSampleDetail();
	}

	// 同步所有的样卡数据
	@Scheduled(cron = "10 0 3 * * *")
	public void syncAllSample() {
		this.henghuaService.syncAllSample();
	}

	// 同步所有服装款式
	@Scheduled(cron = "20 0 3 * * *")
	public void syncAllCloth() {
		this.henghuaService.syncAllCloth();
	}
}
