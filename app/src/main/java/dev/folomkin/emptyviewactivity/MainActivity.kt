package dev.folomkin.emptyviewactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        val checked = checkBox.isChecked
        checkBox.isChecked = !checked
    }

    lateinit var checkBox: CheckBox
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // 1. Находим кнопку в макете по её ID
        val myButton: Button = findViewById(R.id.myButton)

        // 2. Вешаем обработчик нажатия
        myButton.setOnClickListener {
            // Этот код выполнится при нажатии на кнопку
            Toast.makeText(
                this,
                "Hello from button!",
                Toast.LENGTH_SHORT
            ).show()
        }


        checkBox = findViewById(R.id.checkbox)
        button = findViewById(R.id.button)

        button.setOnClickListener(this)

        checkBox.setOnClickListener { view ->
            val intent = Intent(this, RelativeActivity::class.java)
            intent.putExtra("NAME","My name is Dima")
            startActivity(intent)
        }

        Log.d("happy", "onCreate")

    }

    override fun onPause() {
        super.onPause()
        Log.d("happy", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("happy", "onStop")
    }


    override fun onStart() {
        super.onStart()
        Log.d("happy", "onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.d("happy", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("happy", "onDestroy")
    }
}