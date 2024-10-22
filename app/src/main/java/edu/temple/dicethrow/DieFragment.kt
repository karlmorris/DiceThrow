package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {
    var rollValue: Int = 0
    val DIESIDE = "sidenumber"
    val ROLL_VALUE = "rollValue"
    lateinit var dieTextView: TextView
    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        arguments?.let {
            dieSides = it.getInt(DIESIDE, 6)
        }

        if (savedInstanceState != null) {
            rollValue = savedInstanceState.getInt(ROLL_VALUE, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
            dieTextView.text = rollValue.toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (rollValue == 0) {
            throwDie()
        }
    }

    fun throwDie() {
        val result = Random.nextInt(1, dieSides + 1)
        rollValue = result
        dieTextView.text = result.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROLL_VALUE, rollValue)
    }

    companion object {
        fun newInstance(sides: Int): DieFragment {
            val fragment = DieFragment()
            val args = Bundle()
            args.putInt("sidenumber", sides)
            fragment.arguments = args
            return fragment
        }
    }
}
