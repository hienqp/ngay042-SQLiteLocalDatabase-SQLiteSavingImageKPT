package com.hienqp.sqlitesavingimagekpt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoVatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DoVat> doVatList;

    public DoVatAdapter(Context context, int layout, List<DoVat> doVatList) {
        this.context = context;
        this.layout = layout;
        this.doVatList = doVatList;
    }

    @Override
    public int getCount() {
        return doVatList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTen, txtMoTa;
        ImageView imgHinh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTen = (TextView) convertView.findViewById(R.id.textviewMoTaCustom);
            holder.txtMoTa = (TextView) convertView.findViewById(R.id.textviewMoTaCustom);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imageHinhCustom);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DoVat doVat = doVatList.get(position);

        holder.txtTen.setText(doVat.getTen());
        holder.txtMoTa.setText(doVat.getMoTa());

        // ĐỂ CÓ THỂ LẤY DỮ LIỆU MẢNG BYTE GÁN LÊN 1 VIEW, CẦN CHUYỂN MẢNG BYTE VỀ DẠNG BITMAP
        byte[] hinhAnh = doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);

        holder.imgHinh.setImageBitmap(bitmap);

        return convertView;
    }
}
