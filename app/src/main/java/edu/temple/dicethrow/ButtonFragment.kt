package edu.temple.dicethrow

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ButtonFragment : Fragment() {
    private var listener: ButtonInterface? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ButtonInterface) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnButtonClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button, container, false).apply {
            findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
                (requireActivity() as ButtonInterface).buttonClicked()
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface ButtonInterface{
        fun buttonClicked()
    }
}
