package com.example.foodorderapplication.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.foodorderapplication.R
import com.example.foodorderapplication.databinding.FragmentRecipeBinding
import com.example.foodorderapplication.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecipeFragment : Fragment() {

    private lateinit var fragmentRecipeBinding: FragmentRecipeBinding

    //private val registerViewModel:RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentRecipeBinding = FragmentRecipeBinding.inflate(layoutInflater,container,false)
        return fragmentRecipeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
           // showUsername()
            getEmojiByUnicode()
        }
    }

    @SuppressLint("SetTextI18n")
    suspend fun showUsername() {
//        registerViewModel.readData.collect {
//            fragmentRecipeBinding.usernameTxt.text = "${getString(R.string.hello)}, ${it.username} ${getEmojiByUnicode()}"
//        }
    }

    private fun getEmojiByUnicode(): String {
        return String(Character.toChars(0x1f44b))
    }

}