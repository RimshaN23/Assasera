package com.yolo.assasera.ui.post_a_request

import android.app.ProgressDialog.show
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.yolo.assasera.R
import com.yolo.assasera.databinding.FragmentPostARequestBinding

class post_a_request_Fragment : Fragment() {

    lateinit var binding:  FragmentPostARequestBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPostARequestBinding.inflate(inflater, container, false)
         binding.selectProperty.setOnClickListener {
            PopupMenu(context, binding.selectProperty).apply {
                menuInflater.inflate(R.menu.option_menu, menu)
                setOnMenuItemClickListener { item ->
                    binding.selectProperty.setText(item.title)
                    true
                }
                show()
            }
        }

        return binding.root
    }

}