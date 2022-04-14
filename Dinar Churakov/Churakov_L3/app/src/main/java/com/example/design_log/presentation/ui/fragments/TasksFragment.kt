package com.example.design_log.presentation.ui.fragments

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.design_log.R
import com.example.design_log.common.preference.PreferenceManager
import com.example.design_log.data.https.ApiService
import com.example.design_log.data.https.model.NewTask
import com.example.design_log.data.https.model.TasksResponse
import com.example.design_log.databinding.FragmentTasksBinding
import com.example.design_log.databinding.NewTaskDialogBinding
import com.example.design_log.presentation.adapters.recyclerview.TasksAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class TasksFragment : Fragment() {

    lateinit var binding: FragmentTasksBinding
    lateinit var adapter: TasksAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        val sharedPreference = PreferenceManager(requireContext())

        binding.newTaskButton.setOnClickListener {
            createNewTaskDialog(sharedPreference)
        }

        getTasks(sharedPreference)

        adapter = TasksAdapter()
        binding.recyclerTask.adapter = adapter

        adapter.onItemClick = { id ->

            ApiService.retrofit.successTask(
                id,
                "Bearer ${sharedPreference.readLoginPreference()}"
            ).enqueue(
                object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        when (response.code()) {
                            HttpURLConnection.HTTP_OK -> {
                                Toast.makeText(
                                    activity,
                                    getString(R.string.task_ok_mark_request),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            HttpURLConnection.HTTP_BAD_REQUEST -> Toast.makeText(
                                activity,
                                getString(R.string.no_found_id_request),
                                Toast.LENGTH_SHORT
                            ).show()

                            HttpURLConnection.HTTP_UNAUTHORIZED -> Toast.makeText(
                                activity,
                                getString(R.string.missing_token_error),
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

                        if (response.isSuccessful) {
                            adapter.removeItem(id)
                            Toast.makeText(
                                activity,
                                getString(R.string.task_ok_delete_request),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                activity,
                                getString(R.string.no_found_id_request),
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

    private fun getTasks(sharedPreference: PreferenceManager) {
        ApiService.retrofit.getTasks("Bearer ${sharedPreference.readLoginPreference()}").enqueue(
            object : Callback<List<TasksResponse>> {
                override fun onResponse(
                    call: Call<List<TasksResponse>>,
                    response: Response<List<TasksResponse>>
                ) {
                    when (response.code()) {
                        HttpURLConnection.HTTP_OK -> {
                            val list = response.body()!!
                            adapter.submitList(list)
                        }
                        HttpURLConnection.HTTP_BAD_REQUEST -> Toast.makeText(
                            activity,
                            getString(R.string.task_bad_request),
                            Toast.LENGTH_SHORT
                        ).show()

                        HttpURLConnection.HTTP_UNAUTHORIZED -> Toast.makeText(
                            activity,
                            getString(R.string.missing_token_error),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<List<TasksResponse>>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    private fun createNewTaskDialog(sharedPreference: PreferenceManager) {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val dialogBinding = NewTaskDialogBinding.inflate(LayoutInflater.from(requireContext()))
        dialogBuilder.setView(dialogBinding.root)
        dialogBuilder.setCancelable(true)
        val dialog = dialogBuilder.create()
        dialog.show()

        dialogBinding.addNewTaskButton.setOnClickListener {

            if (dialogBinding.newTaskEditText.text.isNullOrBlank()) {
                Toast.makeText(activity, "Введите текст", Toast.LENGTH_SHORT).show()
            } else {
                ApiService.retrofit.createNewTask(
                    NewTask(dialogBinding.newTaskEditText.text.toString()),
                    "Bearer ${sharedPreference.readLoginPreference()}"
                ).enqueue(
                    object : Callback<Unit> {
                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    activity,
                                    getString(R.string.new_task_successful_request),
                                    Toast.LENGTH_SHORT
                                ).show()
                                dialog.dismiss()
                                getTasks(sharedPreference)
                            } else {
                                Toast.makeText(
                                    activity,
                                    getString(R.string.request_error),
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
        }
    }
}
