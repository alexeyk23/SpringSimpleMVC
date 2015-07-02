package com.ya.simplemvc.Service;

import com.ya.simplemvc.dao.ApplicationDAO;
import com.ya.simplemvc.model.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kunakovsky A. S.
 */
@Service
@Transactional
public class ApplicationService {
    @Autowired
    ApplicationDAO appDao;
    public List<Application> getAll() {
        return appDao.findAll();
    }

    public void add(Application a) {
        appDao.addApp(a);
    }
    
}
