package dk.itu.garbage

import java.util.HashMap

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
        itemsMap["coffee"] = "Irma"
        itemsMap["carrots"] = "Netto"
        itemsMap["milk"] = "Netto"
        itemsMap["bread"] = "bakery"
        itemsMap["butter"] = "Irma"
    }
}