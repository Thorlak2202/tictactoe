package tictactoe

class Board {
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

  def draw(arr:Array[Array[String]]): Unit = {
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
  }
}
