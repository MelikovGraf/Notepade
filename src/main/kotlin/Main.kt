fun main() {
    val origin = Notes(
        "123",
        "Заметки",
        "Здравствуйте Максим Ш.",
        Notes.Privacy.All,
        Notes.Privacy.All,
        Notes.Comments(null, null)
    )

    val origin1 = Notes(
        "001",
        "Напоминания",
        "Прощайте Максим Ш.",
        Notes.Privacy.Noone,
        Notes.Privacy.Noone,
        Notes.Comments(null, null)
    )

    val origin3 = Notes(
        "405",
        "Заметки",
        "Максим Ш.",
        Notes.Privacy.All,
        Notes.Privacy.All,
        Notes.Comments(null, null)
    )

    val originComment = Notes.Comments(
        1,
        "NEW COMMENTS"
    )

    val originCommentTwo = Notes.Comments(
        1,
        "Second COMMENTS"
    )


    println(WallService.add(origin))                        //1 Добавляем заметку
    println(WallService.addComment(origin,originComment))   //1 Добавляем комментарий
    println(WallService.editComment(originCommentTwo))         //3 Редактируем коммент
    println(WallService.getComment(originComment))                  //4 Вызываем коммент
    println(WallService.removeComment(origin,origin.comments))     //2 Удаляем комментарий из списка комментариев
    println(WallService.edit(origin1))                      //3 Редактируем заметку
    println(WallService.add(origin))
    println(WallService.remove(origin1))                    //2 Удаляем заметку
    println(WallService.get(origin3))                    //4 Вызываем заметку


}