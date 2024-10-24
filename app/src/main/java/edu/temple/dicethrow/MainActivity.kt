package edu.temple.dicethrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            val dieFragment = DieFragment.newInstance(6)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, dieFragment)
                .commit()
        }

    }

    override fun buttonClicked() {
        ( supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? DieFragment)?.throwDie()
    }
}
