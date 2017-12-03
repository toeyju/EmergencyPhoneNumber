package com.example.emergencyphonenumber.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emergencyphonenumber.R;
import com.example.emergencyphonenumber.model.PhoneItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by RTA on 11/27/2017.
 */

public class PhoneListAdapter extends ArrayAdapter<PhoneItem> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<PhoneItem> mPhoneItemList;

    public PhoneListAdapter(@NonNull Context context, int layoutResId, @NonNull ArrayList<PhoneItem> phoneItemsList) {
        super(context, layoutResId, phoneItemsList);

        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mPhoneItemList = phoneItemsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        PhoneItem item = mPhoneItemList.get(position);

        ImageView phoneImageView = itemLayout.findViewById(R.id.phone_image_view);
        TextView phoneTitleTextView = itemLayout.findViewById(R.id.phone_title_text_view);
        TextView phoneNumberTextView = itemLayout.findViewById(R.id.phone_number_text_view);

        phoneTitleTextView.setText(item.title);
        phoneNumberTextView.setText(item.number);

        String pictureFileName = item.picture;

        AssetManager am = mContext.getAssets();
        try{
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            phoneImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return itemLayout;

    }

}
