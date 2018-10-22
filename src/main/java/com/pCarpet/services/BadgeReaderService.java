package com.pCarpet.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.model.BadgeReader;
@Service
public class BadgeReaderService {

	private BadgeReaderRepository badgeReaderRepository;
@Autowired
    public BadgeReaderService() {
        this.badgeReaderRepository = new BadgeReaderRepository();
    }

    public List<BadgeReader> getAllBadgeReaders () {
        return this.badgeReaderRepository.getAllBadgeReaders();
    }
    
    public List<BadgeReader> getAllBadgeReadersIdAsset (int idAsset) {
        return this.badgeReaderRepository.getAllBadgeReadersIdAsset(idAsset);
    }
    
    public List<BadgeReader> getBadgeReader (int id) {
        return this.badgeReaderRepository.getBadgeReader(id);
    }

    public boolean insertBadgeReader (BadgeReader badgeReader) {
        return this.badgeReaderRepository.insertBadgeReader(badgeReader);
    }
    public boolean deleteBadgeReadear (int idBadgeReader) {
    	return this.badgeReaderRepository.deleteBadgeReadear(idBadgeReader);
    }
    
    public boolean updateBadgeReader(HttpServletRequest request) {
    	return this.badgeReaderRepository.updateBadgeReader(request);
    }
	
}
