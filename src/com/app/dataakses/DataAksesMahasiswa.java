/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dataakses;

import com.app.entity.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bboyr
 */
public class DataAksesMahasiswa {
    private Connection conn;

    public DataAksesMahasiswa(Connection conn) {
        this.conn = conn;
    }
    
    public List<Mahasiswa> getAll() throws SQLException{
        String sql = "SELECT * FROM mahasiswa";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Mahasiswa> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Mahasiswa(rs));
        }
        return list;
    }
    
    public Mahasiswa getMahasiswaByID(String id) throws SQLException{
        String sql = "SELECT * FROM mahasiswa WHERE nim = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet rs = statement.executeQuery();
        Mahasiswa mahasiswa = null;
        if (rs.next()){
            mahasiswa = new Mahasiswa(rs);
        }
        return mahasiswa;
    }
    
    public boolean insert(Mahasiswa mahasiswa) throws SQLException{
        String sql = "INSERT INTO mahasiswa VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,mahasiswa.getNim());
        statement.setString(2,mahasiswa.getNama());
        statement.setString(3,mahasiswa.getJurusan());
        statement.setString(4,mahasiswa.getAlamat());
        statement.setString(5,mahasiswa.getEmail());
        statement.setString(6,mahasiswa.getTelepon());
        int result = statement.executeUpdate();
        return result == 1;
    }
    
    public boolean update(Mahasiswa mahasiswa) throws SQLException{
        String sql = "UPDATE mahasiswa SET nama=?,jurusan=?,alamat=?,email=?,telepon=? WHERE nim=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,mahasiswa.getNama());
        statement.setString(2,mahasiswa.getJurusan());
        statement.setString(3,mahasiswa.getAlamat());
        statement.setString(4,mahasiswa.getEmail());
        statement.setString(5,mahasiswa.getTelepon());
        statement.setString(6,mahasiswa.getNim());
        int result = statement.executeUpdate();
        return result == 1;
    }
    
    public boolean delete(String id) throws SQLException{
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,id);
        int result = statement.executeUpdate();
        return result == 1;
    }
}
