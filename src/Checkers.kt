import java.util.*

//class Checkers which contains sub-functions to test for password safety
open class Checkers() {

    open fun nameCheck(name: String, p: String): Boolean {
        //returns false if name is in password
        return name !in p
    }

    open fun phonenoCheck(pno: String, p: String): Boolean {
        //returns false if phone number is in password
        return pno !in p
    }

    open fun dobCheck(dob: MutableList<String>, p: String): Boolean {
        /*We compare individual components of a birth day to password and see if there is similarity in password.For
        simplicity variable found is used to flag similarities.
         */
        var found:Int=1
        for(i in dob){
            if (i in p){
                found=0
                break
            }
        }
        return found != 0
    }
    open fun contactsCheck(members:MutableList<String>,p:String):Boolean{
        /*We compare each name of close ones of a birth day to password and see if there is similarity in password.For
        simplicity variable found is used to flag similarities.
         */
        var found:Int=1
        for(i in members){
            if (i in p){
                found=0
                break
            }
        }
        return found != 0
    }


}

class Data(): Checkers() {
    val name:String
    val pno:String
    val dob=mutableListOf<String>()
    val members= mutableListOf<String>()
    init {
        //Primary constructor init takes the values of required variables
        println("Init initializing")
        val y=Scanner(System.`in`)
        println("Enter your name (Capitalize first letter)")
        name=y.next()
        println("Enter your birth day (DD)")
        val dd:String=y.next()
        dob.add(dd)
        println("Enter your birth month (MM)")
        val mm:String=y.next()
        dob.add(dd)
        println("Enter your birth year (YY)")
        val yy:String=y.next()
        dob.add(yy)

        println("Enter your phone number")
        pno=y.next()
    }
    constructor(family: Int):this(){
        /*Secondary constructor if a person wants to add names of their close ones.It additionally gets and sets value
        of name of close ones in a list*/

        var i:Int=1
        val x = Scanner(System.`in`)
        while (i<=family){
            println("Enter name of your close one.")
            val e=x.next()

            members.add(e)
            i+=1
        }

    }
    fun checkPassword(){
    //This is function to check for individual password constraints by using functions of inherited class
        val z=Scanner(System.`in`)
        println("Enter password")
        val p:String=z.next()
        val m1 = nameCheck(name.capitalize(),p)
        val m2:Boolean=phonenoCheck(pno,p)
        val m3:Boolean=dobCheck(dob,p)

        val m4:Boolean
        /*Finally all constraints are grouped together to find if password if safe or unsafe. If any of constraint
        returns false then entire password is invalid. Also if is used for checking the case for or without closed ones.
         */
        if (members.isEmpty()){
            if(m1 && m2 && m3)
                println("Valid password")
            else
                println("Password is not safe")
        }
        else {

            m4=contactsCheck(members,p)
            if(m1 && m2 && m3 && m4)
                println("Valid password")
            else
                println("Password is not safe")
        }

    }

}