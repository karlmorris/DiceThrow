package edu.temple.dicethrow

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonOnclickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportFragmentManager.findFragmentById(R.id.dieContainer) !is DieFragment)
            supportFragmentManager.beginTransaction()
                .replace(R.id.dieContainer, DieFragment.newInstance(10))
                .commit()

    }

    override fun onClick() {
        (supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment).throwDie()
    }
}