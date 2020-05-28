package com.example.practise_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practise_recycler.models.Nation

class MainActivity : AppCompatActivity(), NationFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, NationFragment.newInstance(1))
                    .commitNow()
        }
    }

    override fun onListFragmentInteraction(item: Nation?) {
        print(item?.flagImage)
    }
}
