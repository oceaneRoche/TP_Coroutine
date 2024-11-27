package com.example.bindingadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bindingadapter.databinding.ActivityMainBinding
import com.example.bindingadapter.pojo.EtuItem
import com.example.bindingadapter.retrofit.API_Retrofit
import com.example.bindingadapter.view_model.EtuViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: EtuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(EtuViewModel::class.java)
        binding.lifecycleOwner = this@MainActivity
        binding.liveData=viewModel
        viewModel.initData()
        binding.buttonEtudiant.setOnClickListener{getEtudiant()}
        binding.buttonAllEtudiants.setOnClickListener{getAllEtudiants()}

    }

    private fun getAllEtudiants() {
        GlobalScope.launch(Dispatchers.Main) {
            var response = API_Retrofit.api.getAllEtudiants();
            if (response.isSuccessful) {
                viewModel.initData()
                response.body()?.let {
                    viewModel.updateData(it)
                }
            }
        }
    }

    private fun getEtudiant() {
        GlobalScope.launch(Dispatchers.Main) {
            var response = API_Retrofit.api.getEtudiant()
            if (response.isSuccessful) {
                viewModel.initData()
                response.body()?.let {
                    viewModel.updateData(it)
                }
            }
        }
    }
}