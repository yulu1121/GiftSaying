package com.example.administrator.giftsaying.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.giftsaying.R;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;
import com.example.administrator.giftsaying.utils.CalendarUtils;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by Administrator on 2017/2/8.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Map<String,List<ChoiceBean.DataBean.ItemsBean>> choiceMap;
    private Context context;
    public ExpandableAdapter(Map<String,List<ChoiceBean.DataBean.ItemsBean>> choiceMap,Context context){
        this.choiceMap = choiceMap;
        this.context = context;
    }
    @Override
    public int getGroupCount() {
        return choiceMap.keySet().toArray().length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Object[] objects = choiceMap.keySet().toArray();
        String key = (String) objects[groupPosition];
        return choiceMap.get(key).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if(null==textView){
            textView = new TextView(context);
        }
        Object[] objects = choiceMap.keySet().toArray();
        String key = (String) objects[groupPosition];
        String week = CalendarUtils.getWeek(key);
        textView.setText("["+key+"]"+"\t\t"+week);
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;
        ExpandChlidViewHolder viewHolder;
        if(null==view){
          view=LayoutInflater.from(context).inflate(R.layout.first_main_item,parent,false);
            viewHolder = new ExpandChlidViewHolder(view);
        }else {
           viewHolder = (ExpandChlidViewHolder) view.getTag();
        }
        Object[] objects = choiceMap.keySet().toArray();
        String key = (String) objects[groupPosition];
        List<ChoiceBean.DataBean.ItemsBean> itemsList = choiceMap.get(key);
        ChoiceBean.DataBean.ItemsBean itemsBean = itemsList.get(childPosition);
        Picasso.with(context).load(itemsBean.getCover_image_url()).into(viewHolder.firstMainBack);
        viewHolder.firstMainTitle.setText(itemsBean.getTitle());
        viewHolder.firstMainClicks.setText(String.valueOf(itemsBean.getLikes_count()));
        return view;
    }
      class ExpandChlidViewHolder{
        @BindView(R.id.first_main_item_iv)
        ImageView firstMainBack;
        @BindView(R.id.first_main_title_tv)
        TextView firstMainTitle;
        @BindView(R.id.first_main_click_rb)
        RadioButton firstMainClicks;
        public ExpandChlidViewHolder(View view){
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
