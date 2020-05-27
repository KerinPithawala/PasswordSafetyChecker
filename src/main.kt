import java.util.*


fun main(){
    val a=Scanner(System.`in`)
    val r: Any
    println("Number of close one's")
    val choice:Int=a.nextInt()

    when(choice){
      0-> r=Data()
        else->r=Data(choice)
    }

    r.checkPassword()
}