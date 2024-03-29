package com.example.quanlykho.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlykho.fragment.DangKy;
import com.example.quanlykho.fragment.DanhSachThanhVien;


public class QuanLyThanhVienView_Adapter extends FragmentStateAdapter {
    public QuanLyThanhVienView_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DanhSachThanhVien();
            case 1:
                return new DangKy();
            default:
                return new DanhSachThanhVien();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
