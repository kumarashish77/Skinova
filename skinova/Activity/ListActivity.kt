package com.example.skinova.Activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.skinova.Adapter.ListFilteredAdapter
import com.example.skinova.ViewModel.MainViewModel
import com.example.skinova.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private  var viewModel= MainViewModel()
    private var id: String =""
    private var title: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        getBundle()
        initList()
    }

    private fun initList() {
        binding.apply {
            binding.backBtn.setOnClickListener { finish() }
            progressBarList.visibility= View.VISIBLE
            viewModel.popular.observe(this@ListActivity, Observer {
                viewList.layoutManager=GridLayoutManager(this@ListActivity,2)
                viewList.adapter=ListFilteredAdapter(it) 
                progressBarList.visibility= View.GONE
            })
            viewModel.loadFiltered(id)
        }
    }

    private fun getBundle(){
        id = intent.getStringExtra("id") ?:""
        title = intent.getStringExtra("title") ?:""
        binding.CategoryTxt.text=title
    }
}