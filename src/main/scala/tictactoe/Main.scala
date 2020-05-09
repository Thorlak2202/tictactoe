package tictactoe
import scala.io.StdIn.{readLine, readInt}
import util.control.Breaks._

object Main {
  def main(args: Array[String]): Unit = {
    var gameOn: Boolean = true

    while (gameOn) {
      welcome()

      var board: Board = new Board()
      var boardData: Array[Array[String]] = board.board
      var turn: Int = 0
      var getWinner: Boolean = false

      board.draw(boardData)

      while (gameOn) {
        var restarted: Boolean = false
        boardData = nextMove(boardData, turn)
        board.draw(boardData)
        getWinner = board.winner(boardData)

        if (getWinner) {
          if (chooseRestartGame()) {
            turn = 0
            restarted = true
            board = new Board()
            boardData = board.board
          } else {
            gameOn = false
          }
        }

        if (!getWinner && turn == 8) {
          board.tie()

          if (chooseRestartGame()) {
            turn = 0
            restarted = true
            board = new Board()
            boardData = board.board
          } else {
            gameOn = false
          }
        }

        if (!restarted)
          turn += 1
      }
    }
  }

  def welcome() : Unit = {
    println(" █░█░█ █▀▀ █░░ █▀▀ █▀█ █▀▄▀█ █▀▀   ▀█▀ █▀█")
    println(" ▀▄▀▄▀ ██▄ █▄▄ █▄▄ █▄█ █░▀░█ ██▄   ░█░ █▄█ ")
    println("\n")
    println("█▀▄▀█ █░█ █░░ ▀█▀ █ █▀█ █░░ ▄▀█ █▄█ █▀▀ █▀█")
    println("█░▀░█ █▄█ █▄▄ ░█░ █ █▀▀ █▄▄ █▀█ ░█░ ██▄ █▀▄")
    println("\n")
    println( "▀█▀ █ █▀▀   ▀█▀ ▄▀█ █▀▀   ▀█▀ █▀█ █▀▀")
    println( "░█░ █ █▄▄   ░█░ █▀█ █▄▄   ░█░ █▄█ ██▄")
    println("\n\n")
  }

  def chooseRestartGame(): Boolean = {
    var restart = true

    println("==============================")
    println("        Do you want to        ")
    println("       play again? (Y/N)      ")
    println("===============================")

    if (readLine() == "N" || readLine() == "n") {
      restart = false
    }

    restart
  }

  def nextMove(board: Array[Array[String]], turn: Int): Array[Array[String]] = {
    if (turn % 2 == 0) {
      pickMove(board, 1)
    } else {
      pickMove(board, 2)
    }
  }

  def pickMove(board: Array[Array[String]], player_id: Int): Array[Array[String]] = {
    breakable {
      while (true) {
        println(s"Player $player_id, it's your turn.")
        println(s"Select your field number:")

        val field = readInt()

        if (field >= 1 && field <= 9) {
          val coords = for {row <- 0 to 2
                            col <- 0 to 2
                            if board(row)(col) == field.toString
                            } yield (row, col)

          val x = coords.headOption.getOrElse(-1, -1)._1
          val y = coords.headOption.getOrElse(-1, -1)._2

          if (coords != Vector() && (board(x)(y) != "X" || board(x)(y) != "O")) {
            if (player_id == 1) {
              board(x)(y) = "X"
            } else {
              board(x)(y) = "O"
            }

            break
          } else {
            println("Invalid field, select another field")
          }
        } else {
          println("This field doesn't exist in the board, select another field")
        }
      }
    }

    board
  }
}
