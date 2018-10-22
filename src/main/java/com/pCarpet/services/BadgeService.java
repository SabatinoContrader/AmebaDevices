package com.pCarpet.services;

import com.pCarpet.dao.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pCarpet.model.Badge;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Service
public class BadgeService {
	 private BadgeRepository badgeRepository;
@Autowired
	    public BadgeService() {
	        this.badgeRepository = new BadgeRepository();
	    }

	    public List<Badge> getAllBadges () {
	        return this.badgeRepository.getAllBadges();
	    }
	    
	    public Badge getBadge (int id) {
	        return this.badgeRepository.getBadge(id);
	    }
	    public List<Badge> getAllBadgesN () {
	        return this.badgeRepository.getAllBadgesN();
	    }

	    public boolean insertBadge (Badge badge) {
	        return this.badgeRepository.insertBadge(badge);
	    }
	    public boolean deleteBadge (int idBadge) {
	    	return this.badgeRepository.DeleteBadge(idBadge);
	    }
	    
	    public boolean updateBadge(HttpServletRequest request) {
	    	return this.badgeRepository.UpdateBadge(request);
	    }
	}




