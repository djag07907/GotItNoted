package solutions.alva.of.son.gotItNoted.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import solutions.alva.of.son.gotItNoted.dao.NoteDao
import solutions.alva.of.son.gotItNoted.entities.Notes
import java.security.AccessControlContext

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {

    companion object{
        var notesDatabase: NotesDatabase? = null

    @Synchronized
    fun getDatabase(context: Context): NotesDatabase{

        if (notesDatabase == null){
            notesDatabase = Room.databaseBuilder(
                context,
                NotesDatabase::class.java,
                "notes.db"
            ).build()
        }
        return notesDatabase!!
        }
    }

    abstract fun noteDao(): NoteDao
}