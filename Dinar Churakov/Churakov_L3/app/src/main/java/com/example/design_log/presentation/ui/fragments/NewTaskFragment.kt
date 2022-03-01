package com.example.design_log.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.design_log.R
import com.example.design_log.common.preference.PreferenceManager
import com.example.design_log.data.https.ApiService
import com.example.design_log.data.https.model.NewTask
import com.example.design_log.databinding.FragmentNewTaskBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewTaskFragment : Fragment() {

    lateinit var binding: FragmentNewTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        val preferenceManager = PreferenceManager(context!!)

        binding.addNewTaskButton.setOnClickListener {

            if (binding.newTaskEditText.text.isNullOrBlank()) {
                Toast.makeText(activity, "Введите текст", Toast.LENGTH_SHORT).show()
            } else {
                ApiService.retrofit.createNewTask(
                    NewTask(binding.newTaskEditText.text.toString()),
                    "Bearer ${preferenceManager.readLoginPreference()}"
                ).enqueue(
                    object : Callback<Unit> {
                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    activity,
                                    "Задача успешно создана",
                                    Toast.LENGTH_SHORT
                                ).show()
                                findNavController()
                                    .navigate(R.id.action_newTaskFragment_to_menuHome)
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
        }

        return binding.root
    }
}
