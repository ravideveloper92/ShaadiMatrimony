package com.ravi.shaadimatches.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ravi.shaadimatches.data.source.local.AppDataBase
import com.ravi.shaadimatches.util.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors


@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application) : Context
    {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context):AppDataBase
    {
        return Room.databaseBuilder(context,AppDataBase::class.java,Constants.DB_NAME)
            .allowMainThreadQueries()
            .build()

    }

}