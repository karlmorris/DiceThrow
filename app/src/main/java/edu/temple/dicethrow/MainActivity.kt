package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var fragmentbutton =findViewById<Button>(R.id.rollDiceButton)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val existingFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)

        if (existingFragment == null) {
            val dieFragment = DieFragment.newInstance(6)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, dieFragment)
                .commit()
        }
    }
}
