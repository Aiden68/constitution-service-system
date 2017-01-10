package com.aiden.nsfw.info.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiden.core.service.impl.BaseServiceImpl;
import com.aiden.nsfw.info.dao.InfoDao;
import com.aiden.nsfw.info.entity.Info;
import com.aiden.nsfw.info.service.InfoService;

@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {

	private InfoDao infoDao;
	
	@Resource
	public void setInfoDao(InfoDao infoDao) {
		super.setBaseDao(infoDao);
		this.infoDao = infoDao;
	}

}
