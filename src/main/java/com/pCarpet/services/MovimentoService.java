package com.pCarpet.services;

import com.pCarpet.dao.BadgeRepository;
//import main.dao.BadgereaderDAO;
import com.pCarpet.dao.MovimentoRepository;
import com.pCarpet.model.Badge;
import com.pCarpet.model.Movimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MovimentoService {

    private MovimentoRepository movimentoRepository;
	private Object badgeRepository;
	private Object badgereaderRepository;
@Autowired
    public MovimentoService(MovimentoRepository movimento) {
        this.movimentoRepository = movimento;
    }
    public List<Badge> getAllBadges () {
        return ((BadgeRepository) this.badgeRepository).getAllBadges();
    }
    public List<Movimento> getAllMovimenti () {
        return this.movimentoRepository.getAllMovimenti();
    }
    public List<Movimento> getAllUserMovimenti (String iduser) {
        return this.movimentoRepository.getAllUserMovimenti(iduser);
    }
  /*  public List<BadgeReader> getAllBadgeReaders () {
        return (((BadgeReaderDAO) this.badgeReaderDAO).getBadgeReaders());
    }
*/
    public boolean insertMovimento (Movimento movimento) {
        return this.movimentoRepository.insertMovimento(movimento);
    }
    
    public boolean deleteMovimento (int idBadgeReader, int idBadge, String datainizio) {
        return this.movimentoRepository.deleteMovimento(idBadgeReader, idBadge, datainizio);
    }
}
