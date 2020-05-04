package com.ravi.shaadimatches.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ravi.shaadimatches.data.model.ShaadiMatchesModel
import com.ravi.shaadimatches.util.Constants

@Dao
interface ShadiMatchesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(batchModel: ShaadiMatchesModel?)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(batchModels: List<ShaadiMatchesModel?>?)

    @get:Query("SELECT * from shaadimatches")
    val allList: List<ShaadiMatchesModel>

    @get:Query("SELECT * from shaadimatches WHERE isAccept=1 ")
    val acceptedList: List<ShaadiMatchesModel?>?

    @get:Query("SELECT * from shaadimatches WHERE isReject=1 ")
    val rejectedList: List<ShaadiMatchesModel?>?

    @Query("UPDATE shaadimatches SET isAccept = :selection WHERE email =:emailId")
    fun updateOnAccept(selection: Int, emailId: String?)

    @Query("UPDATE shaadimatches SET isReject = :selection WHERE email =:emailId")
    fun updateOnReject(selection: Int, emailId: String?)

    @get:Query("SELECT COUNT(*) from shaadimatches")
    val totalCount: Int

    @Query("DELETE from shaadimatches")
    fun deleteAll()
}