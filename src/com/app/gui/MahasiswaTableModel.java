/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gui;

import com.app.entity.Mahasiswa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bboyr
 */
public class MahasiswaTableModel extends AbstractTableModel {
    private List<Mahasiswa> list;

    public MahasiswaTableModel(List<Mahasiswa> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return list.get(rowIndex).getValue(columnIndex);
    }
    
    String header[] = {"Nim","Nama","Jurusan","Alamat","Email","Telepon"};

    @Override
    public String getColumnName(int column) {
        return header [column];
    }
    
}
