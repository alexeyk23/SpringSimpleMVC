
package com.ya.simplemvc.Service;

import com.ya.simplemvc.dao.PrivilegeDAO;
import com.ya.simplemvc.model.Privilege;
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
public class PrivilegeService {
    @Autowired
    PrivilegeDAO privileteDAO;
    
    public List<Privilege> getAll() {
        return privileteDAO.findAll();
    }
}
