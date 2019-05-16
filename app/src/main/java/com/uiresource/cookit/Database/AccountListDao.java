package com.uiresource.cookit.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AccountListDao {

    @Query("SELECT * FROM AccountList")
    List<AccountList> getAll();

    @Query("SELECT * FROM AccountList WHERE id = :id")
    AccountList getById(String id);

    /*@Insert
    void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);*/
}
