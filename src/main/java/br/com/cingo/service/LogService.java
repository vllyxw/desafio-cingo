package cingo.service;

import cingo.model.Log;
import cingo.dao.LogDAO;
import java.util.List;

public class LogService {
    private LogDAO logDAO = new LogDAO();

    public List<Log> listLog() {
        return logDAO.listAll();
    }

    public void saveLog(Log log) {
        logDAO.saveOrUpdate(log);
    }

    public Log updateLog(Long id, Log logToUpdate) {
        Log existente = logDAO.searchId(id);
        if (existente != null && logToUpdate != null) {
            existente.setConteudo(logToUpdate.getConteudo());
            existente.setVezes(logToUpdate.getVezes());
            logDAO.saveOrUpdate(existente);
        }
        return existente;
    }

    public void deleteLog(Long id) {
        Log log = logDAO.searchId(id);
        if (log != null) {
            logDAO.delete(log);
        }
    }
}
