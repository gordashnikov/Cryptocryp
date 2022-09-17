package com.rustyrobot.cryptocryp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rustyrobot.cryptocryp.pojo.CoinPriceInfo

@Database(entities = [CoinPriceInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun coinPriceInfoDao(): CoinPriceInfoDao

    companion object {
        private const val DB_NAME = "main.db"
        private var db: AppDatabase? = null
        private val LOCK = Any()
        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { it }
                val instance: AppDatabase =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }
}