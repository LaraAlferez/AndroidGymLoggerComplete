package gymfinalproject.stn991540084.larakirtanluigi

import androidx.room.*
import androidx.room.OnConflictStrategy.*

@Dao
interface SwimmingDatabaseDao {

    @Insert
    fun insertSwim(swimming: Swimming)

    @Update()
    fun updateSwim(swimming: Swimming)

    @Query("SELECT * FROM swimming_table")
    fun getALLSwim(): List<Swimming>

    @Query("DELETE FROM swimming_table")
    fun deleteLogs()
}