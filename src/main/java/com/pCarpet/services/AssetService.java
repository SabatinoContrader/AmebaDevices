package com.pCarpet.services;



import com.pCarpet.dao.AssetRepository;
import com.pCarpet.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

	@Service
	public class AssetService {

    private AssetRepository assetRepository;
    //private UserAssetDAO userAssetDAO;
@Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Asset> getAllAssets () {
        return this.assetRepository.getAllAssets();
    }
    
    public List<Asset> getAllAssetsN () {
        return this.assetRepository.getAllAssetsN();
    }
    
    public Asset getAsset (int id) {
        return this.assetRepository.getAsset(id);
    }
    /*
    public List<User> getAllClienti () {
        return this.userDAO.getAllClienti();
    }
    
    public List<User> getAllClientiAss(){
    	return this.userDAO.getAllClientiAss();
    }
    */

    public boolean insertAsset (Asset asset) {
        return this.assetRepository.insertAsset(asset);
    }
    
    public boolean deleteAsset(int idAsset) {
    	return this.assetRepository.deleteAsset(idAsset);
    }
    
    /*
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    */
    
    public boolean updateAsset(HttpServletRequest request) {
    	return this.assetRepository.updateAsset(request);
    }
}