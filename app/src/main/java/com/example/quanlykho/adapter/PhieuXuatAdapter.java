package com.example.quanlykho.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlykho.R;
import com.example.quanlykho.data.PhieuXkDAO;
import com.example.quanlykho.data.SanPhamDAO;
import com.example.quanlykho.model.PhieuXuatKho;
import com.example.quanlykho.model.SanPham;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class PhieuXuatAdapter extends RecyclerView.Adapter<PhieuXuatAdapter.ViewHolder> {

    Context myContext;
    ArrayList<PhieuXuatKho> list;
    ArrayList<SanPham> listSanPham;
    ArrayAdapter<SanPham> adapterSanPham;

    public PhieuXuatAdapter(Context myContext, ArrayList<PhieuXuatKho> list) {
        this.myContext = myContext;
        this.list = list;
    }

    public void setData(ArrayList<PhieuXuatKho> list) {
        this.list = list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) myContext).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_phieu_xuat_kho, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhieuXuatKho idPhieu = list.get(position);
        PhieuXkDAO phieuXkDAO = new PhieuXkDAO(myContext);

        holder.ten.setText(list.get(position).getTentv());
        holder.tvTenSp.setText(list.get(position).getId_sp() + "");
        holder.tvSoLuong.setText(list.get(position).getSoluong() + "");
        holder.tvNgayXuat.setText(list.get(position).getNgayXuat());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTenSp, tvSoLuong, tvNgayXuat, ten;
        ImageView ivXoa, ivSua;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenSp = itemView.findViewById(R.id.tvTenSanPhamPhieuXuat);
            tvSoLuong = itemView.findViewById(R.id.tvSoLuongSanPhamPhieuXuat);
            tvNgayXuat = itemView.findViewById(R.id.tvNgayXuatSanPhamPhieuXuat);
            ivSua = itemView.findViewById(R.id.ivSuaSPPhieuXuat);
            ten = itemView.findViewById(R.id.tennv);
            ivXoa = itemView.findViewById(R.id.ivXoaSPPhieuXuat);


        }
    }

}
