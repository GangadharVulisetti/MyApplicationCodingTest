package com.pavanvulisetti.myapplication.ui.usercards

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.pavanvulisetti.myapplication.CardApplication
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.databinding.ActivityUsersListBinding
import com.pavanvulisetti.myapplication.di.component.DaggerActivityComponent
import com.pavanvulisetti.myapplication.di.module.ActivityModule
import com.pavanvulisetti.myapplication.ui.base.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListActivity : AppCompatActivity() {

    @Inject
    lateinit var userListViewModel: UsersListViewModel

    @Inject
    lateinit var userListAdapter: UserListAdapter

    @Inject
    lateinit var userHorizontalListAdapter: UserHorizontalListAdapter

    private lateinit var binding: ActivityUsersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
        setUpObserver()
    }

    private fun setUpUI() {

        val horizontalRecyclerView = binding.horizontalDisplayRecyclerView
        horizontalRecyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        horizontalRecyclerView.adapter = userHorizontalListAdapter


        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userListAdapter
    }

    private fun setUpObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                userListViewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            renderList(it.data)
                            binding.horizontalDisplayRecyclerView.visibility = View.VISIBLE
                            binding.recyclerView.visibility = View.VISIBLE
                        }

                        is UiState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.recyclerView.visibility = View.GONE
                            binding.horizontalDisplayRecyclerView.visibility = View.GONE
                        }

                        is UiState.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this@UsersListActivity, it.message, Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
        }
    }

    private fun renderList(list: List<Result>) {
        userHorizontalListAdapter.addData(list)
        userListAdapter.addData(list)
    }

    private fun injectDependencies() {
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as CardApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}