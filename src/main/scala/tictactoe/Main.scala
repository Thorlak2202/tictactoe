package tictactoe
import scala.io.StdIn.readInt

object Main {
  def main(args: Array[String]): Unit = {
    var gameMode: Int = 0

    gameMode = chooseGameMode()
  }

  def chooseGameMode() : Int = {
    var gameOn: Boolean = true
    var gameMode: Int = 0

    while (gameOn) {
      println(s"Choose the game mode:")
      println(s"1. Single player")
      println(s"2. Multiplayer")
      gameMode = readInt()

      if (gameMode == 1 || gameMode == 2) {
        gameOn = false
      } else {
        println("You have selected an invalid game mode, try again!\n\n")
      }
    }

    val board = new Board()
    val boardData = board.build()
    board.draw(boardData)

    println(s"\n\nYou have selected the game mode: $gameMode")
    println(s"Good Luck!")
    gameMode
  }
}
