/**
* Universidad del Valle de Guatemala
* Programacion de Plataformas Moviles - Sec 20
* Andres Quezada - 21085
* 23/07/22
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
    println(processList(listOf(25, "2", null, false,null,true,"hola")))
}

fun infoOf(obj : Any?):String? {//function that gets the info of the item in list
    return when (obj) {
        is Int -> return when{
        num % 10 == 0 ->  "M10"
        num % 5 == 0 -> "M5"
        num % 2 == 0 -> "M2"
        else -> null}
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
       item?.let{
            when (item){
                is Int -> wList.add(ItemData(inputList.indexOf(item),item,"entero",infoOf(item)))
                is String -> wList.add(ItemData(inputList.indexOf(item),item,"cadena",infoOf(item)))
                is Boolean -> wList.add(ItemData(inputList.indexOf(item),item,"booleano",infoOf(item)))
                else -> wList.add(ItemData(inputList.indexOf(item),item,null,null))
            }
        }
    }
    return wList
}