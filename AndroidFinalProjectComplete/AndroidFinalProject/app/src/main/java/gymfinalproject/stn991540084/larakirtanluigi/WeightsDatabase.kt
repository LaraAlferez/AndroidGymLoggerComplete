package gymfinalproject.stn991540084.larakirtanluigi

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Weights::class], version = 1, exportSchema = false)
abstract class WeightsDatabase : RoomDatabase() {
    abstract fun weightsDatabaseDao(): WeightsDatabaseDao
    companion object {

        @Volatile
        private var INSTANCE: WeightsDatabase? = null

        fun getInstanceWeight(context: Context): WeightsDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WeightsDatabase::class.java,
                        "weights_history_DB"
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