package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    val PREV = "previousroll"
    var current = 0
    lateinit var dieTextView: TextView
    var dieSides: Int = 6

    // Factory method to create an instance of DieFragment with a specific number of sides
    companion object {
        fun newInstance(dieSides: Int): DieFragment {
            val fragment = DieFragment()
            val args = Bundle()
            args.putInt(fragment.DIESIDE, dieSides)  // Use the constant DIESIDE correctly
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dieSides = it.getInt(DIESIDE, 6)  // Default to 6 if not provided
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_die, container, false)
        dieTextView = view.findViewById(R.id.dieTextView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        throwDie()
        savedInstanceState?.getInt(PREV)?.let {
            current = it
            dieTextView.text = current.toString()
        }
        view.setOnClickListener {
            throwDie()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PREV, current)
    }

    fun throwDie() {
        current = Random.nextInt(dieSides) + 1
        dieTextView.text = current.toString()
    }
}
