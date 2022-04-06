import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test(expected = PostNotFoundException::class) // функция выдает ошибку (проверил через мейн), но почему то не засчитывается тест как верный. Не могу понять
    fun shouldThrow() {
        WallService.clearArr()
        val origin = Notes(
            "405",
            "Заметки",
            "Максим Ш.",
            Notes.Privacy.All,
            Notes.Privacy.All,
            Notes.Comments(1, "Hello")
        )

        val originCommentTwo = Notes.Comments(
            1,
            "Second COMMENTS"
        )
        WallService.add(origin)
        WallService.editComment(originCommentTwo)
    }

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