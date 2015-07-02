/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tentityManagerplate file, choose Tools | TentityManagerplates
 * and open the tentityManagerplate in the editor.
 */
package com.ya.simplemvc.dao;

import com.ya.simplemvc.model.Application;
import com.ya.simplemvc.model.Permission;
import com.ya.simplemvc.model.Privilege;
import com.ya.simplemvc.model.Role;
import com.ya.simplemvc.model.User;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.sf.ehcache.constructs.asynchronous.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Класс ApplicationDAO 
 */
@Repository
public class ApplicationDAO extends AbstractFacade<Application> {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PrivilegeDAO privDao;
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    /**
     * Метод добавления приложения
     * @param app - добавляемое приложение
     * @return true, если добавлено приложение
     */
    public boolean addApp(Application app) {
        Query q = entityManager.createQuery("SELECT a FROM Application a WHERE a.nameApp=?1 ")
                .setParameter(1, app.getNameApp());
        if (q.getResultList().size() > 0) {
            return false;
        }
        super.edit(app);
        return true;
    }
    /**
     * Метод удаления приложения
     * @param id_app - идентификатор удаляемого приложения
     */
    public void deleteApp(int id_app)
    {
        Application app = entityManager.find(Application.class, id_app);
            for (Permission p : app.getPermissions()) {
                for (Role role : p.getRoles()) {
                    role.getPermissions().remove(p);
                }
                entityManager.remove(p);
            }
            for (Privilege p : app.getPrivs()) {
                p.getApps().remove(app);
            }
            entityManager.remove(app);
    }
    /**
     * 
     * @param id_app
     * @param nameApp
     * @param selectedPrivs
     * @return
     * @throws Exception 
     */
    public boolean updateApp(int id_app, String nameApp, List<String> selectedPrivs) throws Exception
    {
        Application app = entityManager.find(Application.class, id_app);
            if(app.getNameApp().equals(nameApp))
                return false;
            app.setNameApp(nameApp);
            Set<Privilege> currPrivs = new HashSet<Privilege>();
            currPrivs.addAll(app.getPrivs());
            //удаляем привилегию
            for (Privilege privilege : currPrivs) {
                if (!selectedPrivs.contains(String.valueOf(privilege.getIdPriv()))) {
                    for (Permission permission : app.getPermissions()) {
                        //если удаляем привилегию у приложения, на которое есть разрешение,
                        //то следует записать команду для каждого пользователя
                        if (permission.getPrivelege().getIdPriv() == privilege.getIdPriv()) {
//                            for (Role role : permission.getRoles()) {
//                                for (User user : role.getUsers()) {
//                           //         Command command = new Command(user.getIdUser(), permission.getApplication().getIdApp(), permission.getPrivelege().getIdPriv(), "revoke priv", new Date());
//                       //             entityManager.persist(command);
//                                }
//                            }
                            app.getPermissions().remove(permission);
                        }
                    }
                    app.getPrivs().remove(privilege);
                }
            }
            //добавляем привилегию
            for (String idPriv : selectedPrivs) {
                Privilege p = privDao.find(Integer.valueOf(idPriv));
                app.getPrivs().add(p);
            }
        return true;
    }
    public ApplicationDAO() {
        super(Application.class);
    }

    
}
