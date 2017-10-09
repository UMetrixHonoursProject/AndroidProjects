package com.sample.pablo.breadcrumbs.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.pablo.breadcrumbs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 23/10/16.
 */

public class SamplePageAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> registeredFragments = new ArrayList<>();
    private List<String> registeredTitles = new ArrayList<>();

    public SamplePageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return registeredFragments.get(position);
    }


    @Override
    public int getItemPosition(Object object) {
        int index = registeredFragments.indexOf (object);
        if (index == -1)
            return POSITION_NONE;
        else
            return index;
    }


    @Override
    public int getCount() {
        return registeredFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return registeredTitles.get(position);
    }

    @Override
    public float getPageWidth (int position) {
        return 0.93f;
    }

    public void addItem(String title, Fragment fragment) {
        registeredFragments.add(fragment);
        registeredTitles.add(title);
        notifyDataSetChanged();
    }

    public View getTabView(Context context, int position, int selectedPosition) {
        int drawable;
        if (position == selectedPosition) {
            drawable = R.drawable.tab_selecionada;
        } else if (position == selectedPosition-1) {
            drawable = R.drawable.tab_nao_selecionada_prev;
        } else {
            drawable = R.drawable.tab_nao_selecionada;
        }

        View view = View.inflate(context, R.layout.tab_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        ImageView icon = (ImageView) view.findViewById(R.id.btnClose);
        icon.setTag(position);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pageIndex = Integer.parseInt(v.getTag().toString());

                if (pageIndex >= 0) {
                    registeredFragments.remove(pageIndex);
                    registeredTitles.remove(pageIndex);
                    notifyDataSetChanged();
                }
            }
        });
        ViewGroup layout = (ViewGroup) view.findViewById(R.id.root);

        layout.setBackgroundResource(drawable);
        title.setText(this.getPageTitle(position));

        return view;
    }
}
