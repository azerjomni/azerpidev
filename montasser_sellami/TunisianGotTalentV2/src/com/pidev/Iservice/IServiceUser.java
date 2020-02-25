/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Iservice;


import com.pidev.Entite.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HPENVY
 */
public interface IServiceUser<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(T u) throws SQLException;
    public User update(String Nom ,String Prenom,String Email ,String Login ,String MotDePasse , String Sexe ,String DateNaissance ,int NumTelephone ,String TypeCompte , String TypeTalent , String ImgUser,int NbDiament,int idUser) throws SQLException;
    List<T> readAll() throws SQLException;
}
