package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import java.util.Locale
import kotlin.random.Random

class DieFragment : Fragment() {
    val DIESIDE = "sidenumber"
    val ROLL_VALUE = "rollValue"
    lateinit var dieTextView: TextView
    var dieSides: Int = 20
    val dieViewModel:DieViewModel by lazy {
        ViewModelProvider(requireActivity())[DieViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides=this
            }
        }

//        if (savedInstanceState != null) {
//            rollValue = savedInstanceState.getInt(ROLL_VALUE, 0)

      //  }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
            //dieTextView.text = rollValue.toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dieViewModel.getDieRoll().observe(viewLifecycleOwner){
            dieTextView.text=it.toString()
        }
        if(dieViewModel.getDieRoll().value==null){
            throwDie()
        }

    }

    fun throwDie() {
        dieViewModel.setDieRoll(Random.nextInt(1, dieSides + 1))
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
