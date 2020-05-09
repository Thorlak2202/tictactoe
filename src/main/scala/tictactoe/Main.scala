package tictactoe
import scala.io.StdIn.{readLine, readInt}

object Main {
  def main(args: Array[String]): Unit = {
    var gameMode: Int = 0
    var gameOn: Boolean = true

    while (gameOn) {
      gameMode = chooseGameMode()

      if (gameMode == 1 || gameMode == 2) {
        println(s"\n\nYou have selected the game mode: $gameMode")
        println(s"Good Luck!")

        val board: Board = new Board()
        var boardData: Array[Array[String]] = board.board
        board.draw(boardData)

        var turn: Int = 0

        while (gameOn) {
          boardData = nextMove(boardData, turn)
          board.draw(boardData)
          turn += 1
        }
      } else {
        println(s"You have selected an invalid game mode, try again!\n\n")
      }
    }
  }

  def chooseGameMode() : Int = {
    var gameMode: Int = 0

    println(s"Choose the game mode:")
    println(s"1. Single player")
    println(s"2. Multiplayer")
    gameMode = readInt()
    gameMode
  }

  def nextMove(board: Array[Array[String]], turn: Int): Array[Array[String]] = {
    if (turn % 2 == 0) {
      pickMove(board, 1)
    } else {
      pickMove(board, 2)
    }
  }

  def pickMove(board: Array[Array[String]], player_id: Int): Array[Array[String]] = {
    println(s"Player $player_id, it's your turn.")
    println(s"Select your field number:")

    val field = readInt().toString
    val coords = for { row <- 0 to 2
                       col <- 0 to 2
                       if board(row)(col) == field
                     } yield(row, col)

    val x = coords.headOption.getOrElse(-1, -1)._1
    val y = coords.headOption.getOrElse(-1, -1)._2

    if (player_id == 1) {
      board(x)(y) = "X"
    } else {
      board(x)(y) = "O"
    }

    board
  }
}
