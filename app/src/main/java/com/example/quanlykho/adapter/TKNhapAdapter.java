package com.example.quanlykho.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlykho.R;
import com.example.quanlykho.data.SanPhamDAO;
import com.example.quanlykho.data.ThongKeDAO;
import com.example.quanlykho.model.NhapKho;
import com.example.quanlykho.model.SanPham;

import java.util.ArrayList;



public class TKNhapAdapter extends RecyclerView.Adapter<TKNhapAdapter.ViewHolder> {
    private ArrayList<NhapKho> list_nhap;
    Context context;

    private ThongKeDAO dao;
    SanPhamDAO sanPhamDAO;

    public TKNhapAdapter(ArrayList<NhapKho> list_nhap, Context context) {

        this.list_nhap = list_nhap;
        this.context = context;
        sanPhamDAO=new SanPhamDAO(context);
    }

    public void setData( ArrayList<NhapKho> list_nhap) {
        this.list_nhap = list_nhap;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_statis_nhap, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NhapKho nhapKho = list_nhap.get(position);
        SanPham sanPham=sanPhamDAO.getByID1(String.valueOf(nhapKho.getSp_Id()));
        holder.tvIdSPl.setText((position+1)+". "+sanPham.getTen_sp() + "");
        holder.tvXuat.setText("Nhập: "+ nhapKho.getTonKho()+  " sp");

    }

    @Override
    public int getItemCount() {
        if(list_nhap==null)
            return 0;
        return list_nhap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdSPl,  tvXuat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdSPl = itemView.findViewById(R.id.tv_id_sp);
            tvXuat = itemView.findViewById(R.id.tv_xuat);


        }
    }

}
