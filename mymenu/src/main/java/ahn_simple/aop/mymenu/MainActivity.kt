package ahn_simple.aop.mymenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.menu_option_item_1 -> {
                makeToast("selected the first option menu")
                return true
            }
            R.id.sub_1_in_item_1 -> {
                makeToast("this is first submenu in the first")
                return true
            }
            R.id.sub_2_in_item_1 -> {
                makeToast("this is second submenu in the first")
                return true
            }
            R.id.sub_3_in_item_1 -> {
                makeToast("this is third submenu in the first")
                return true
            }
            R.id.menu_option_item_2 -> {
                makeToast("selected the second option menu")
                return true
            }
            R.id.menu_option_item_3 -> {
                makeToast("selected the third option menu")
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun makeToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}