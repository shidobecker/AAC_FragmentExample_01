package com.example.android.fragmentexample

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_simple.*

class SimpleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_simple, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        radio_group.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = radio_group.findViewById<RadioButton>(checkedId)
            val index = radio_group.indexOfChild(radioButton)

            when (index) {
                YES -> fragment_header.text = getString(R.string.yes)
                NO -> fragment_header.text = getString(R.string.no)
            }
        }

        rating.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(context, "Rating is: $rating", Toast.LENGTH_LONG).show()
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
     /*   if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        const val YES = 0
        const val NO = 1

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                SimpleFragment().apply {
                    arguments = Bundle().apply {
                        //putString(ARG_PARAM1, param1)
                       // putString(ARG_PARAM2, param2)
                    }
                }
    }
}
