package gymfinalproject.stn991540084.larakirtanluigi;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "free_weights_table")
data class Weights (
    @PrimaryKey(autoGenerate = true)
    var weightId: Long = 0L,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "weight")
    var weights: Int,

    @ColumnInfo(name = "reps")
    var reps: Int
)