package cingo.service;

import cingo.model.Log;
import cingo.dao.LogDAO;
import cingo.rest.LogResource;

import java.util.List;

public class LogService {
    private LogDAO logDAO = new LogDAO();

    public List<Log> listLog() {
        return logDAO.listAll();
    }

    public void saveLog(Log log) {
        logDAO.saveOrUpdate(log);
    }

    public void updateLog(Long id, Log log) {
        Log existente = logDAO.searchId(Id);
        if (existente != null) {
            existente.setConteudo(log.getConteudo());
            existente.setVezes(log.getVezes());
            logDAO.saveOrUpdate();
        }
    }

    public  void deleteLog(Long id){
        Log log = logDAO.searchId(id);
        if (log != null) {
            logDAO.delete(log);
        }
    }


}
