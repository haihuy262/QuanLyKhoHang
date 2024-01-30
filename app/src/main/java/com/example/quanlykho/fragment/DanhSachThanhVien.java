package com.example.quanlykho.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlykho.R;
import com.example.quanlykho.adapter.DanhSachNhanVien_adapter;
import com.example.quanlykho.data.ThanhVienDAO;
import com.example.quanlykho.model.ThanhVien;

import java.util.ArrayList;



public class DanhSachThanhVien extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<ThanhVien> list;
    private DanhSachNhanVien_adapter adapter;

    public DanhSachThanhVien() {
        // Required empty public constructor
    }


    public static DanhSachThanhVien newInstance() {
        DanhSachThanhVien fragment = new DanhSachThanhVien();
   ;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_sach_thanh_vien, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView reThanhVien = view.findViewById(R.id.danh_sach_thanh_vien);
        ThanhVienDAO dao = new ThanhVienDAO(getContext());
        list = dao.getAllData();
        adapter = new DanhSachNhanVien_adapter(getContext(),list,dao);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        reThanhVien.setLayoutManager(layoutManager);
        reThanhVien.setAdapter(adapter);

        super.onViewCreated(view, savedInstanceState);
    }
}