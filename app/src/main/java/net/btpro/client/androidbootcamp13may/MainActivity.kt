package net.btpro.client.androidbootcamp13may

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import com.google.android.material.snackbar.Snackbar
import net.btpro.client.androidbootcamp13may.databinding.ActivityMainBinding
import net.btpro.client.androidbootcamp13may.databinding.ItemAlertBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener {
            Toast.makeText(applicationContext, "Toast Mesaj Uzun", Toast.LENGTH_LONG).show()
        }

        binding.buttonSnackbar.setOnClickListener {
            Snackbar.make(it, "Profilden çıxılsın mı?", Snackbar.LENGTH_LONG).setAction("Beli") {
                Snackbar.make(it, "HEsapdan çıxıldı", Snackbar.LENGTH_SHORT).show()
            }.show()
        }

        binding.buttonAlert.setOnClickListener {
            // setAlertView()
            setCustomAlertView()
        }

        binding.buttonMenu.setOnClickListener {
            val popup = PopupMenu(this@MainActivity, binding.buttonMenu)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_islem -> {
                        Toast.makeText(applicationContext, "İşleme tıklandı", Toast.LENGTH_LONG).show()
                        true
                    }

                    R.id.action_hesab -> {
                        Toast.makeText(applicationContext, "Hesaba tıklandı", Toast.LENGTH_LONG).show()
                        true
                    }

                    else -> false
                }

            }

            popup.show()

        }


    }

    private fun setAlertView() {
        val alert = AlertDialog.Builder(this@MainActivity)

        alert.setTitle("Xeberdarlıq")
        alert.setMessage("Çıxmaw isteyirsiniz mi?")

        alert.setPositiveButton("Beli") { _, _ ->
            Toast.makeText(applicationContext, "Hesabdan Çıxış yapıldı", Toast.LENGTH_LONG).show()
        }

        alert.setNegativeButton("Xeyir") { _, _ ->

        }

        alert.create().show()
    }

    private fun setCustomAlertView() {
        val tasarim = ItemAlertBinding.inflate(layoutInflater)

        val alert = AlertDialog.Builder(this@MainActivity)

        alert.setTitle("Nömre yazın")
        alert.setView(tasarim.root)

        alert.setPositiveButton("Beli") { _, _ ->

            val number = tasarim.editTextText.text.toString()

            Toast.makeText(applicationContext, number, Toast.LENGTH_LONG).show()
        }

        alert.setNegativeButton("Xeyir") { _, _ ->

        }

        alert.create().show()

    }


}