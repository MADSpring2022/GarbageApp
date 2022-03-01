package dk.itu.garbage

import android.content.Context
import java.util.HashMap
import java.io.BufferedReader
import java.io.IOException

class ItemsDB(context: Context) {
    // val is equivalent to finale
    private val itemsMap : HashMap<String, String> = HashMap<String, String>()

    init {
        fillItemsDB(context, "garbage.txt")
    }

    companion object {
        private var sItemsDB : ItemsDB? = null

        fun initialize(context: Context) {
            if (sItemsDB == null) {
                sItemsDB = ItemsDB(context)
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
            return dbItem
        }
        return "$input not found"
    }

    fun addItem(what : String, where : String) {
        itemsMap[what] = where
    }

    private fun fillItemsDB(context: Context, filename : String) {
            //get items and categories from file
            try {
                //read file
                var reader : BufferedReader = context.assets.open(filename).bufferedReader()
                //assign the return value of readLine to variable.
                var line = reader.readLine();
                //while there is something in the file
                while (line != null) {
                    // assign input to array, split at white space
                    val itemsFile = line.lowercase().split(",");
                    // put the the input into the map ofItemsDB as k/v pair
                    itemsMap[itemsFile[0]] = itemsFile[1]
                    //get content of next line
                    line = reader.readLine();
                }
            } catch (e : IOException) {
                println(e)
            }
        }



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


