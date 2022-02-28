package dk.itu.garbage

import java.util.HashMap
import java.io.File
import java.io.BufferedReader

class ItemsDB {
    // val is equivalent to finale
    private val itemsMap : HashMap<String, String> = HashMap<String, String>()

    init {
        fillItemsDB();
    }

    companion object {
        private var sItemsDB : ItemsDB? = null

        fun initialize() {
            if (sItemsDB == null) {
                sItemsDB = ItemsDB()
            }
        }

        fun get() : ItemsDB {
            return sItemsDB ?:
            throw IllegalStateException("ItemsDB must be initialized")
        }
    }

    fun size() : Int {
        return itemsMap.size
    }

    fun searchItems(input : String) : String {
        val dbItem: String

        if (itemsMap.containsKey(input)) {
            // use indexing with map
            dbItem = "$input should be placed in: ${itemsMap[input]}"
            return "$dbItem"
        }
        return "$input not found"
    }

    fun addItem(what : String, where : String) {
        itemsMap[what] = where
    }

    private fun fillItemsDB() {
        itemsMap["coffee"] = "Bio"
        itemsMap["carrots"] = "Bio"
        itemsMap["milk carton"] = "Residual Waste"
        itemsMap["bread"] = "Bio"
        itemsMap["butter"] = "Bio"
        itemsMap["peanut butter"] = "Bio"
        itemsMap["phone"] = "Electronic Waste"


        /*
        val reader : BufferedReader = File("src/main/assets/garbage.txt").bufferedReader()
        val lineList = mutableListOf<String>()
        reader.useLines {
            lines -> lines.forEach {
                lineList.add(it)
            }
            lineList.forEach {
                val line = it.split(",")
                itemsMap[line[0]] = line[1]
            }
        }
        */
    }

}

