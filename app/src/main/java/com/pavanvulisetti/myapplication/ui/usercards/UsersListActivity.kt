package com.pavanvulisetti.myapplication.ui.usercards

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavanvulisetti.codingsessiontwo.ui.base.UiState
import com.pavanvulisetti.myapplication.CardApplication
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.databinding.ActivityTopHeadlineBinding
import com.pavanvulisetti.myapplication.di.component.DaggerActivityComponent
import com.pavanvulisetti.myapplication.di.module.ActivityModule
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListActivity : AppCompatActivity() {

    @Inject
    lateinit var userListViewModel: UsersListViewModel

    @Inject
    lateinit var userListAdapter: UserListAdapter

    private lateinit var binding: ActivityTopHeadlineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        binding = ActivityTopHeadlineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
        setUpObserver()
    }

    private fun setUpUI() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = userListAdapter

    }

    private fun setUpObserver() {
        userListViewModel.getUiState().observe(this) {
            when (it) {
                is UiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    renderList(it.data)
                    binding.recyclerView.visibility = View.VISIBLE
                }

                is UiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }

                is UiState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@UsersListActivity, it.message, Toast.LENGTH_LONG)
                        .show()
                    print("****** ${it.message}")
                }
            }
        }
    }

    private fun renderList(list: List<Result>) {
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