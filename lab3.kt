/**
* Universidad del Valle de Guatemala
* Programacion de Plataformas Moviles - Sec 20
* Andres Quezada - 21085
* 17/07/22
**/

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "2", null, false,null,true,"hola"))
    println(result)
}

fun typeOf(obj : Any?):String? {//function that sets the type of the item in the list
    return when (obj) {
        is Int -> "entero"
        is String -> "cadena" 
        is Boolean -> "booleano"
        else -> null
      }
}

fun infoVI(num : Int):String?{//function that gets info Version Int, return the info of the int
    return when{
        num % 10 == 0 ->  "M10"
        num % 5 == 0 -> "M5"
        num % 2 == 0 -> "M2"
        else -> null
    }
}

fun infoOf(obj : Any?):String? {//function that gets the info of the item in list
    return when (obj) {
        is Int -> infoVI(obj)
        is String -> "L${obj.length}"
        true -> "Verdadero"
        false -> "Falso"
        else -> null
      }
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    
    if (inputList == null) return null
    val wList = ArrayList<ItemData>()
    for (item in inputList.orEmpty()){
        if (item != null){
            val index = inputList.indexOf(item)
            val cItem = ItemData(index,item,typeOf(item),infoOf(item))
            wList.add(cItem)
        }
    }
    return wList
}