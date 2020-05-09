package tictactoe

class Board {
  val board: Array[Array[String]] = build()

  def build(): Array[Array[String]] = {
    val arr = Array.ofDim[String](3, 3)

    arr(0)(0) = "1"
    arr(0)(1) = "2"
    arr(0)(2) = "3"
    arr(1)(0) = "4"
    arr(1)(1) = "5"
    arr(1)(2) = "6"
    arr(2)(0) = "7"
    arr(2)(1) = "8"
    arr(2)(2) = "9"
    arr
  }

  def draw(arr: Array[Array[String]]): Unit = {
    for (i <- arr.indices) {
      print(" ")
      print(arr(i)(0))
      print(" | ")
      print(arr(i)(1))
      print(" | ")
      print(arr(i)(2))

      if (i < 2)
        println("\n---+---+---")
    }

    println("\n")
  }

  def winner(arr: Array[Array[String]]): Boolean = {
    var getWinner: Boolean = false
    var j:Int  = 0

    // Horizontal
    for (i <- 0 to 2) {
      if (arr(i)(0) == arr(i)(1) || arr(i)(0) == arr(i)(2)) {
        getWinner = true
      }
    }
    // Verticals
    for (i <- 0 to 2) {
      if (arr(0)(i) == arr(1)(i) && arr(0)(i) == arr(2)(i)) {
        getWinner = true
      }
    }
    // Diagonals
    if (arr(2)(2) == arr(1)(1) && arr(2)(2) == arr(0)(0)) {
      getWinner = true
    }
    if (arr(0)(0) == arr(1)(1) && arr(0)(0) == arr(2)(2)) {
      getWinner = true
    }


    if (getWinner == true){
      println("==============================")
      println("|     WE HAVE A WINNER       |")
      println("|      ᕦ( ͡° ͜ʖ ͡°)ᕤ          |")
      println("==============================")
      println("|       Type restart          |")
      println("|       to play again!        |")
      println("===============================")
    }
  getWinner
  }

}
