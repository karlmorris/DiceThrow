package edu.temple.dicethrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var dieFragment: DieFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollButton=findViewById(R.id.rollDiceButton)
        val fragment= supportFragmentManager.findFragmentById(R.id.fragmentContainerView)as? DieFragment
        rollButton.setOnClickListener {
            dieFragment.throwDie()
        }


    }


}
