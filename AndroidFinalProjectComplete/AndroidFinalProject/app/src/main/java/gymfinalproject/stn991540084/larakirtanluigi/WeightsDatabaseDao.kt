package gymfinalproject.stn991540084.larakirtanluigi

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WeightsDatabaseDao {
    @Insert
    fun insertWeight(weights : Weights)

    @Update
    fun updateWeight(weights: Weights)

    @Query("SELECT * FROM free_weights_table")
    fun getFreeWeights(): List<Weights>

    @Query("DELETE FROM free_weights_table")
    fun deleteLog()
}