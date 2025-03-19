package edu.temple.dicethrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the first die with 6 sides
        val dieFragment1 = DieFragment.newInstance(20)
        val fragmentTransaction1: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction1.replace(R.id.dieFragmentContainer1, dieFragment1)
        fragmentTransaction1.commit()

        // Create the second die with 6 sides
        val dieFragment2 = DieFragment.newInstance(20)
        val fragmentTransaction2: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction2.replace(R.id.dieFragmentContainer2, dieFragment2)
        fragmentTransaction2.commit()

        // Set up the roll button to roll both dice
        val rollButton = findViewById<Button>(R.id.rollButton)
        rollButton.setOnClickListener {
            dieFragment1.throwDie()  // Roll the first die
            dieFragment2.throwDie()  // Roll the second die
        }
    }
}

