package com.example.myapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model.Daf;
import com.example.myapp.activity.SplashActivity;
import com.example.myapp.adapters.ViewPagerDataLearningAdapter;
import com.example.myapp.databinding.FragmentViewPagerShewStudyBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPagerShewStudyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPagerShewStudyFragment extends Fragment {

    public static final String TAG = ViewPagerShewStudyFragment.class.getSimpleName();

    FragmentViewPagerShewStudyBinding binding;
    private ViewPager myViewpajer;
    private ViewPagerDataLearningAdapter viewPagerDataLearningAdapter;
    private ArrayList<Fragment> myListDataLernen = new ArrayList<>();
    private OnFragmentInteractionListener mListener;
    ArrayList<Daf> myList1 = new ArrayList<>();

    public ViewPagerShewStudyFragment() {

    }


    public static ViewPagerShewStudyFragment newInstance(ArrayList<Daf>myList1) {
        ViewPagerShewStudyFragment fragment = new ViewPagerShewStudyFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(SplashActivity.KEY_EXTRA_List1, myList1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myList1 = getArguments().getParcelableArrayList(SplashActivity.KEY_EXTRA_List1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewPagerShewStudyBinding.inflate(inflater, container, false);
        initMyViewPager();
        return binding.getRoot();
    }

    private void initMyViewPager() {
        myViewpajer = binding.FFSViewpager;
        viewPagerDataLearningAdapter = new ViewPagerDataLearningAdapter(getActivity().getSupportFragmentManager(),initMyListStudy(),getContext());
        myViewpajer.setAdapter(viewPagerDataLearningAdapter);
        TabLayout tabLayout = binding.FFSTabLayout;
//        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        tabLayout.setupWithViewPager(myViewpajer, true);
    }
    private ArrayList<Fragment> initMyListStudy() {
        ShewStudyRvFragment myShewStudyRvFragment =  ShewStudyRvFragment.newInstance(myList1);
        myListDataLernen.add(myShewStudyRvFragment);
        myListDataLernen.add(myShewStudyRvFragment);
        myListDataLernen.add(myShewStudyRvFragment);
        return myListDataLernen;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    public interface OnFragmentInteractionListener {

    }
}