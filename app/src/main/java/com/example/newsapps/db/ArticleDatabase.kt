package com.example.newsapps.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapps.mvvmnewsapp.Article

@Database(
        entities = [Article::class]
        ,version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase(){

    abstract fun getArticleDao(): ArticleDao

//    companion object {
//        @Volatile
//        //other threat can immediately see the when thread changes this instance
//        private var INSTANCE: ArticleDatabase? = null
//        private val Lock = Any()
//        fun getInstance(appContext: Context) =
//                INSTANCE
//                        ?: synchronized(Lock) {
//                            INSTANCE
//                                    ?: createDatabase(appContext).also { INSTANCE = it }
//                        }
//
//        private fun createDatabase(appContext: Context) =
//                Room.databaseBuilder(appContext, ArticleDatabase::class.java, "newsapp_db.db")
//                        .build()
//    }
    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(appContext: Context): ArticleDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        appContext.applicationContext,
                        ArticleDatabase::class.java,
                        "newsapp_db.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
