package lucca.android.com.criminaldatabase.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucca.android.com.criminaldatabase.R

/**
 * Created by lucca on 12/06/2018.
 */

class FragmentListar : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragmentlistar , container, false)

        return root
    }

}