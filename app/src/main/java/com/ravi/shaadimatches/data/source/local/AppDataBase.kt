package com.ravi.shaadimatches.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ravi.shaadimatches.data.Converters
import com.ravi.shaadimatches.data.model.ShaadiMatchesModel
import com.ravi.shaadimatches.util.Constants

@Database(entities = [ShaadiMatchesModel::class], version = Constants.DB_VERSION)
@TypeConverters(Converters::class)
public abstract class AppDataBase : RoomDatabase() {
    abstract fun shadiMatchesDao(): ShadiMatchesDao

}