package dk.itu.garbage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddingActivity : AppCompatActivity() {
    //GUI
    private lateinit var inputWhat : EditText
    private lateinit var inputWhere : EditText
    private lateinit var addButton : Button

    //Database singleton
    private lateinit var itemsDB : ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_adding_activity)

        itemsDB = ItemsDB.get()

        //associate GUI and id


        //associate GUI and id
        inputWhat = findViewById(R.id.what_text)
        inputWhere = findViewById(R.id.where_text)
        addButton = findViewById(R.id.add_new_item)

        addButton.setOnClickListener {
            val what = inputWhat.text.toString().lowercase().trim()
            val where = inputWhere.text.toString().lowercase().trim()

            if ((what.isNotEmpty()) && (where.isNotEmpty())) {
                itemsDB.addItem(what, where)
                inputWhat.setText("")
                inputWhere.setText("")
            } else {
                Toast.makeText(this, R.string.empty_toast, Toast.LENGTH_LONG).show()
            }
        }
    }
}