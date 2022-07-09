fun main() {
  
    println("Welcome for our GENERATOR!")
    println("")
    println("Here we'll draw a triangle")
    println("Enter the value of the triangle: ")
  
    var value_Triangle = readLine()
    var cont = 0
    //var cont_2 = 5
  
    println("The value of the triangle is: $value_Triangle")
    println("And... the triangle looks like this: ")
  
    for (i in 1..5){
      for(j in 0..cont){
        print("*")
      }
      println("")
      cont = cont + 1 
    }
  
    println("")
      
    //for (i in 1..5){
      //for(j in cont_2){
       //print("*")
     // }
      //println("")
     // cont_2 = cont_2 - 1 
   // }
  }