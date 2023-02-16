package com.example.app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.app.R
import com.example.app.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var _binding: FragmentSearchBinding
    private lateinit var listView: ListView
    private lateinit var listAdapter: ArrayAdapter<String>
    private lateinit var languageList: ArrayList<String>
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = _binding.listSearch
        searchView = _binding.searchView

        languageList = ArrayList()
        languageList.add("C")
        languageList.add("Javascript")
        languageList.add("Go")
        languageList.add("Kotlin")
        languageList.add("Java")

        listAdapter = ArrayAdapter<String>(
            view.context,
            android.R.layout.simple_list_item_1,
            languageList
        )

        listView.adapter = listAdapter

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (languageList.contains(query)) {
                    listAdapter.filter.filter(query)
                }else {
                    Toast.makeText(view.context, "No language found", Toast.LENGTH_SHORT).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                listAdapter.filter.filter(newText)
                return false
            }

        })

    }
}