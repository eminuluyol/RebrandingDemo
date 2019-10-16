package com.taurus.prerebrandingdemo

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.tabs.TabLayout

class MaterialComponentsShowcaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.material_components_showcase_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val extendedFab = view.findViewById<ExtendedFloatingActionButton>(R.id.extended_fab)
        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_title)
        val cardView = view.findViewById<MaterialCardView>(R.id.material_card_view_checkable)
        val tabLayout = view.findViewById<TabLayout>(R.id.material_tab_layout)
        (requireActivity() as AppCompatActivity).run {
            setSupportActionBar(toolbar)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeAsUpIndicator(R.drawable.action_nav_lefthand)
            setHasOptionsMenu(true)

        }
        toolbarTitle.text = "Rebranding Demo"
        extendedFab.setOnClickListener {
            extendedFab.toggleFabState()
        }
        cardView.setOnClickListener {
            cardView.isChecked = !cardView.isChecked
        }

      tabLayout.getTabAt(0)?.orCreateBadge?.apply {
            isVisible = true
            number = 99
        }

        tabLayout.getTabAt(1)?.orCreateBadge?.apply {
            isVisible = true
            number = 21
        }

        tabLayout.getTabAt(2)?.orCreateBadge?.apply {
            isVisible = true
            number = 88
        }

        val materialBottomSheet = MaterialModalBottomSheet()

        toolbar.setOnMenuItemClickListener {
            materialBottomSheet.show(childFragmentManager, MaterialModalBottomSheet.TAG)
            return@setOnMenuItemClickListener false
        }


    }

    private fun ExtendedFloatingActionButton.toggleFabState() {
        if (isExtended) {
            shrink()
        } else {
            extend()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.my_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}
