package edu.temple.dicethrow

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var die1: DieFragment
    private lateinit var die2: DieFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        die1 = DieFragment.newInstance(6)
        die2 = DieFragment.newInstance(6)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container1, die1)
            .replace(R.id.container2, die2)
            .commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            die1.throwDie()
            die2.throwDie()
        }

    }
}