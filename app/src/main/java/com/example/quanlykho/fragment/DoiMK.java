package com.example.quanlykho.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.quanlykho.R;
import com.example.quanlykho.data.ThanhVienDAO;
import com.example.quanlykho.model.ThanhVien;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;



public class DoiMK extends Fragment {

    List<ThanhVien> thanhVienList;
    public DoiMK() {
        // Required empty public constructor
    }


    public static DoiMK newInstance() {
        DoiMK fragment = new DoiMK();

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
        return inflater.inflate(R.layout.fragment_doi_m_k, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextInputEditText edMatKhauCu = view.findViewById(R.id.edMatKhauCu);
        TextInputEditText edMatKhauMoi = view.findViewById(R.id.edMatKhauMoi);
        TextInputEditText edNhapLaiMatKhauMoi = view.findViewById(R.id.edNhapLaiMatKhauMoi);
        AppCompatButton btnDoiMatKhau = view.findViewById(R.id.btnDoiMatKhau);

        ThanhVienDAO thanhVienDAO = new ThanhVienDAO(view.getContext());

        thanhVienList = thanhVienDAO.getAllData();
        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String matKhauCu = edMatKhauCu.getText().toString();
                String matKhauMoi = edMatKhauMoi.getText().toString();
                String nhapLaiMatKhauMoi = edNhapLaiMatKhauMoi.getText().toString();

                SharedPreferences sharedPreferences = getContext().getSharedPreferences("USER_FILE", MODE_PRIVATE);
                String username = sharedPreferences.getString("USERNAME", "");

                if (matKhauCu.trim().equals("") || matKhauMoi.trim().equals("") || nhapLaiMatKhauMoi.trim().equals("")) {
                    Toast.makeText(view.getContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (int i = 0; i < thanhVienList.size(); i++) {

                    if (thanhVienList.get(i).getHoTen_tv().equals(username)) {

                        if (!matKhauCu.equals(thanhVienList.get(i).getMatKhau_tv())) {
                            Toast.makeText(view.getContext(), "Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (matKhauMoi.equals(matKhauCu)) {
                            Toast.makeText(view.getContext(), "Mật khẩu mới không được trùng với mật khẩu cũ", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (!matKhauMoi.equals(nhapLaiMatKhauMoi)) {
                            Toast.makeText(view.getContext(), "Mật khẩu mới không trùng khớp, vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        thanhVienDAO.update(new ThanhVien(thanhVienList.get(i).getId_tv(), thanhVienList.get(i).getHoTen_tv(), edMatKhauMoi.getText().toString(), thanhVienList.get(i).getRole_tv()));
                        Toast.makeText(view.getContext(), "Cập nhật mật khẩu thành công", Toast.LENGTH_SHORT).show();

                        edMatKhauCu.setText("");
                        edMatKhauMoi.setText("");
                        edNhapLaiMatKhauMoi.setText("");
                    }
                }
                thanhVienList.clear();
                thanhVienList = thanhVienDAO.getAllData();
            }
        });

    }
}