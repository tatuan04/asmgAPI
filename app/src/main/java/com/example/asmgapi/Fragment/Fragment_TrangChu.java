package com.example.asmgapi.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmgapi.Adapter.adapter_slide;
import com.example.asmgapi.Adapter.test;
import com.example.asmgapi.Model.Slideiten;
import com.example.asmgapi.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class Fragment_TrangChu extends Fragment {


    ViewPager2 viewpage;
    CircleIndicator3 chamduoi;
    private List<Slideiten> slidelist;
    private Handler slideHanlder = new Handler(Looper.getMainLooper());
    RecyclerView rcvsanpham_tt;
    public Fragment_TrangChu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__trang_chu, container, false);
        viewpage = view.findViewById(R.id.viewpage);
        chamduoi = view.findViewById(R.id.chamduoi);
        // slider
        rcvsanpham_tt =view.findViewById(R.id.rcvsanpham_tt);
        slidelist = new ArrayList<>(); // Khởi tạo slidelist trước khi sử dụng
        slidelist.add(new Slideiten(R.drawable.sdkghdf));
        slidelist.add(new Slideiten(R.drawable.vjdhbfgj));
        slidelist.add(new Slideiten(R.drawable.hjsdg));
        slidelist.add(new Slideiten(R.drawable.sdkghdf));
        slidelist.add(new Slideiten(R.drawable.vjdhbfgj));
        slidelist.add(new Slideiten(R.drawable.hjsdg));
        viewpage.setAdapter(new adapter_slide(slidelist, viewpage));
        chamduoi.setViewPager(viewpage);
        String[] sampleProducts = {"Product 1", "Product 2", "Product 3", "Product 4", "Product 5"};
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvsanpham_tt.setLayoutManager(layoutManager);
        test adapter = new test(sampleProducts);
        rcvsanpham_tt.setAdapter(adapter);
        //cài đặt thuộc tính viewpager 2
        viewpage.setClipToPadding(false);
        viewpage.setClipChildren(false);
        viewpage.setOffscreenPageLimit(3);///nhìn đc 3 ảnh :2 ảnh 2 bên và một ảnh ở giữa
        viewpage.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewpage.setPageTransformer(compositePageTransformer);
        viewpage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHanlder.removeCallbacks(sildeRunnable);
                slideHanlder.postDelayed(sildeRunnable, 3000);

            }
        });
        return view;
    }
    private Runnable sildeRunnable = new Runnable() {
        @Override
        public void run() {
//            binding.viewpage.setCurrentItem(binding.viewpage.getCurrentItem() + 1);
            int vitri = viewpage.getCurrentItem();
            if (vitri == slidelist.size() - 1) {
                viewpage.setCurrentItem(0);
            } else {
                viewpage.setCurrentItem(vitri + 1);
            }
        }
    };
    @Override
    public void onPause() {
        //khi thoat ra ngoai man home
        super.onPause();
        slideHanlder.removeCallbacks(sildeRunnable);
    }

    @Override
    public void onResume() {
        //khi quay tro lai man home
        super.onResume();
        slideHanlder.postDelayed(sildeRunnable, 3000);
    }
}