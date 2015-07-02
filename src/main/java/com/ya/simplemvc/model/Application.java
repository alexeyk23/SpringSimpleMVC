/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ya.simplemvc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Класс Application
 */
@Entity
@Table(name = "\"Application\"")
public class Application implements Serializable {

    @Id
    @Column(name = "id_app")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_app_gen")
    @SequenceGenerator(name = "id_app_gen", sequenceName = "\"Application_id_app_seq\"")
    private int idApp; //id
    @Column(name = "name_app")
    private String nameApp;
    @OneToMany(mappedBy = "application")
    private Set<Permission> permissions = new HashSet<Permission>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "\"App_priv\"",
            joinColumns = {
                @JoinColumn(name = "id_app", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "id_priv", nullable = false, updatable = false)})
    private Set<Privilege> privs = new HashSet<Privilege>();

    //Констуктор с параметрами

    public Application(String nameApp, Set<Privilege> privileges) {
        this.nameApp = nameApp;
        this.privs = privileges;
    }

    public Application() {
    }

    // методы получения и установки полей:

    public Set<Privilege> getPrivs() {
        return privs;
    }

    public void setPrivs(Set<Privilege> privs) {
        this.privs = privs;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public int getIdApp() {
        return idApp;
    }

    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }

    public String getNameApp() {
        return nameApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idApp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Application other = (Application) obj;
        return this.idApp == other.idApp;
    }
}
