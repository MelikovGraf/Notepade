import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {


    @Test
    fun add() {
        WallService.clearArr()
        val origin = Notes(
            "405",
            "Заметки",
            "Максим Ш.",
            Notes.Privacy.All,
            Notes.Privacy.All,
            Notes.Comments(1, "Hello")
        )

        WallService.add(origin)
        assertNotEquals(0, origin.noteIds)
    }
}