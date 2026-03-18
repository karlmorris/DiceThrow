package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add fragments only the first time the activity is created
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, DieFragment.newInstance(6))
                .replace(R.id.fragmentContainerView2, DieFragment.newInstance(10))
                .commit()
        }

        val rollButton = findViewById<Button>(R.id.rollDiceButton)
        // Set a click listener for the button
        rollButton.setOnClickListener {
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? DieFragment)?.throwDie()
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as? DieFragment)?.throwDie()
        }
    }
}