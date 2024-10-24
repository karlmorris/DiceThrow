package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

private val DIESIDE = "sidenumber"
private val KEY = "key"

class DieFragment : Fragment() {

    private val dieViewModel: DieViewModel by lazy {
        ViewModelProvider(requireActivity())[DieViewModel::class.java]
    }

    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    //var diceroll: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //updates text by the viewmodel
        dieViewModel.getDieRoll().observe(viewLifecycleOwner){
            dieTextView.text = it.toString()
        }

        if(dieViewModel.getDieRoll().value == null)
        {
            throwDie()
        }

    }

    fun throwDie() {
        dieViewModel.setDieRoll(Random.nextInt(dieSides) + 1)
    }

    companion object
    {
        fun newInstance(sides : Int) : DieFragment
        {
            //create bundle with an Int where the key is DIESIDE
            //and value is the sides
            val bundle = Bundle()
            bundle.putInt(DIESIDE, sides)
            //Create instance of DieFragment, set arguement to bundle, and return fragment
            val fragment = DieFragment()
            fragment.arguments = bundle

            return fragment
        }
    }
}