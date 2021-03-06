package com.example.myapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model.Daf;
import com.example.myapp.R;
import com.example.myapp.activity.SplashActivity;
import com.example.myapp.databinding.FragmentTypeStudyBinding;

import java.util.ArrayList;


public class TypeStudyFragment extends Fragment {
    public static final String TAG = TypeStudyFragment.class.getSimpleName();
    FragmentTypeStudyBinding binding;
    ArrayList<Daf> myList1 = new ArrayList<>();
    ViewPagerShewStudyFragment firstStudy = ViewPagerShewStudyFragment.newInstance(myList1) ;



    public TypeStudyFragment() {

    }


    public static TypeStudyFragment newInstance(ArrayList<Daf> myList1 ) {
        TypeStudyFragment fragment = new TypeStudyFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(SplashActivity.KEY_EXTRA_List1,myList1);

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
        binding = FragmentTypeStudyBinding.inflate(inflater, container, false);
        openFragment(firstStudy, ViewPagerShewStudyFragment.TAG );
        initViews();
        return binding.getRoot();
    }
    private void initViews() {
        binding.FTPFIRSTSTUDYBUTTON.setOnClickListener(v -> openFragment(firstStudy, ViewPagerShewStudyFragment.TAG ));
        binding.FTPTOWSTUDYBUTTON.setOnClickListener(v -> openFragment(ViewPagerShewStudyFragment.newInstance(myList1), ViewPagerShewStudyFragment.TAG ));
        binding.FTPTHREETSTUDYBUTTON.setOnClickListener(v -> openFragment(ViewPagerShewStudyFragment.newInstance(myList1), ViewPagerShewStudyFragment.TAG ));
    }
    public void openFragment(Fragment myfragment, String tag){

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.FTP_framelayout,myfragment)
                .addToBackStack(tag)
                .commit();

    }
}