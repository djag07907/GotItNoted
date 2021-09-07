package solutions.alva.of.son.gotItNoted.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.*
import solutions.alva.of.son.gotItNoted.entities.Notes


@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllNotes() : List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note:Notes)

    @Delete
    suspend fun deleteNote(note:Notes)
}