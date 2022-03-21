package gymfinalproject.stn991540084.larakirtanluigi

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Swimming::class], version = 1, exportSchema = false)
abstract class SwimmingDatabase: RoomDatabase() {
    abstract fun SwimmingDatabaseDao(): SwimmingDatabaseDao
    companion object {

        @Volatile
        private var INSTANCE: SwimmingDatabase? = null

        fun getInstanceSwim(context: Context): SwimmingDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SwimmingDatabase::class.java,
                        "swimming_history_DB"
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