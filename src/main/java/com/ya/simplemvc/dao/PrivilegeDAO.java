package com.ya.simplemvc.dao;

import com.ya.simplemvc.model.Application;
import com.ya.simplemvc.model.Permission;
import com.ya.simplemvc.model.Privilege;
import com.ya.simplemvc.model.Role;
import com.ya.simplemvc.model.User;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class PrivilegeDAO extends AbstractFacade<Privilege> {
     @Autowired
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
/**
     * Добавить привилегию
     * @param r - привилегия
     * @return true если добавление, false если привилегия с таким именем есть
     * @throws Exception
     */
    public boolean addPrivilege(Privilege r) throws Exception {      
        //проверяем, есть ли уже такое
        Query q = entityManager.createQuery("SELECT p FROM Privilege p WHERE p.namePriv=?1 ")
                .setParameter(1, r.getNamePriv());
        if (q.getResultList().size() > 0) {
            return false;
        }
        entityManager.persist(r);
        return true;
    }
    /**
     * Удаление привилегии по ID
     * @param id_priv ID привилегии
     * @throws Exception
     */
    public void deletePrivilege(int id_priv) throws Exception {
            Privilege privilege = entityManager.find(Privilege.class, id_priv);
            for (Application app : privilege.getApps()) {
                for (Permission perm : app.getPermissions()) {
                    if (perm.getPrivelege().getIdPriv() == id_priv) {
                        for (Role role : perm.getRoles()) {
//                            for (User user : role.getUsers()) {
//                                Command c = new Command(user.getIdUser(), perm.getApplication().getIdApp(),
//                                        perm.getPrivelege().getIdPriv(), "revoke priv", new Date());
//                                entityManager.persist(c);
//                            }
                            role.getPermissions().remove(perm);
                        }              
                        app.getPermissions().remove(perm);
                        entityManager.remove(perm);
                    }                  
                }
                app.getPrivs().remove(privilege);                
            }
            entityManager.remove(privilege);         
    }
    public PrivilegeDAO() {
        super(Privilege.class);
    }
    
}
