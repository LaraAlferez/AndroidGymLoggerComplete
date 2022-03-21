package gymfinalproject.stn991540084.larakirtanluigi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "swimming_table")
data class Swimming (
    @PrimaryKey(autoGenerate = true)
    var swimID: Long = 0L,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "laps")
    var laps: Int,

    @ColumnInfo(name = "best_time")
    val time: String
)