package com.example.foodorderapplication.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodorderapplication.R
import com.example.foodorderapplication.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var fragmentRegisterBinding: FragmentRegisterBinding

    private var email = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentRegisterBinding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return fragmentRegisterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleErrorChangeListenerEmailEditText()

        fragmentRegisterBinding.submitBtn.setOnClickListener {
            checkNullField()
        }
    }


    private fun checkNullField(){
        val name = fragmentRegisterBinding.nameEdt.text.toString()
        val lastname = fragmentRegisterBinding.lastNameEdt.text.toString()
        val username = fragmentRegisterBinding.usernameEdt.text.toString()
        val email = fragmentRegisterBinding.emailEdt.text.toString()
        val errorEmail = fragmentRegisterBinding.emailTxtLay.error

        if (name.isEmpty() || lastname.isEmpty() || username.isEmpty() || email.isEmpty()) {
            Toast.makeText(requireContext(), "please fill all fields", Toast.LENGTH_SHORT).show()
        }else if(errorEmail==getString(R.string.emailNotInvalid)){
            Toast.makeText(requireContext(),"input valid email",Toast.LENGTH_SHORT).show()
        }else{
            findNavController().navigate(R.id.action_registerFragment_to_recipeFragment)
        }
    }



    private fun handleErrorChangeListenerEmailEditText(){
        fragmentRegisterBinding.apply {

            emailEdt.addTextChangedListener(object:TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    if(emailEdt.text!!.isEmpty()|| p0.toString().contains("@"))
                    {
                        email = p0.toString()
                        emailTxtLay.error = ""
                    }
                    else{
                        emailTxtLay.error = getString(R.string.emailNotInvalid)
                    }
                }

            })
        }
    }
}