package dk.itu.garbage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GarbageActivity : AppCompatActivity() {
    //GUI
    private lateinit var searchItems : Button
    private lateinit var toAddItem : Button
    private lateinit var item : TextView

    //Database singleton
    private lateinit var itemsDB : ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_garbage)

        ItemsDB.initialize()
        itemsDB = ItemsDB.get()

        item = findViewById(R.id.input_text)
        searchItems = findViewById(R.id.where_button)
        toAddItem = findViewById(R.id.to_add_item)

        searchItems.setOnClickListener {
            item.text = itemsDB.searchItems(item.text.toString())
        }

        toAddItem.setOnClickListener {
            val intent = Intent(this, AddingActivity::class.java)
            startActivity(intent)
        }


    }



}