package com.example.design_log.presentation.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.design_log.R
import com.example.design_log.common.preference.PreferenceManager
import com.example.design_log.data.https.ApiService
import com.example.design_log.data.https.model.TasksResponse
import com.example.design_log.databinding.FragmentTasksBinding
import com.example.design_log.presentation.adapters.recyclerview.TasksAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TasksFragment : Fragment() {

    lateinit var binding: FragmentTasksBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)

        binding.newTaskButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuHome_to_newTaskFragment)
        }
        val adapter = TasksAdapter()
        binding.recyclerTask.adapter = adapter

        val sharedPreference = PreferenceManager(context!!)

        ApiService.retrofit.getTasks("Bearer ${sharedPreference.readLoginPreference()}").enqueue(
            object : Callback<List<TasksResponse>> {
                override fun onResponse(
                    call: Call<List<TasksResponse>>,
                    response: Response<List<TasksResponse>>
                ) {
                    when (response.code()) {
                        200 -> {
                            val list = response.body()!!
                            adapter.submitList(list)
                        }
                        400 -> Toast.makeText(
                            activity,
                            "Проблемы при получении задач",
                            Toast.LENGTH_SHORT
                        ).show()

                        401 -> Toast.makeText(
                            activity,
                            "Отсутствуе токен",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<List<TasksResponse>>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )

        adapter.onItemClick = { id ->

            ApiService.retrofit.successTask(
                id,
                "Bearer ${sharedPreference.readLoginPreference()}"
            ).enqueue(
                object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        when (response.code()) {
                            200 -> {
                                Toast.makeText(activity, "отмечено", Toast.LENGTH_SHORT).show()
                            }

                            400 -> Toast.makeText(
                                activity,
                                "Задача с указанным id не найдена",
                                Toast.LENGTH_SHORT
                            ).show()

                            401 -> Toast.makeText(
                                activity,
                                "Некоректный токен доступа",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }

        adapter.onItemLongClick = { id ->

            ApiService.retrofit.deleteTask(
                id,
                "Bearer ${sharedPreference.readLoginPreference()}"
            ).enqueue(
                object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {

                        if (response.code() == 200) {
                            //возникли проблемы с анимацией удаления, а так удаляет
                            Toast.makeText(
                                activity,
                                "Успешно удалено",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                activity,
                                "Задача с указанным id не найдена",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        return binding.root
    }
}
