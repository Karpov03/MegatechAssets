package com.megatech.domain.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megatech.domain.rest.dao.AssetDAO;
import com.megatech.domain.rest.model.Assets;

@Service("assetService")
public class AssetRestService {

	@Autowired
	AssetDAO assetDao;

	@Transactional
	public List<Assets> getAllAssets() {
		return assetDao.getAllAssets();
	}

	@Transactional
	public Assets getAsset(int id) {
		return assetDao.getAssets(id);
	}

	@Transactional
	public void addAsset(Assets asset) {
		assetDao.addAssets(asset);
	}

	@Transactional
	public synchronized boolean addAssets1(Assets asset) {
		assetDao.addAssets1(asset);

		return true;
	}

	@Transactional
	public void updateAssets(Assets asset) {
		assetDao.updateAssets(asset);

	}

	@Transactional
	public void updateAssets1(Assets asset) {

		assetDao.updateAssets1(asset);
	}

	@Transactional
	public void deleteAssets(int id) {
		assetDao.deleteAssets(id);
	}
}
