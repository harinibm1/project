/**
 @Author : Palani Kannan
 Date : Aug 22,2015
 File : CustomListViewAdapter.java
 Package : com.util
*/

package com.listview;

import java.util.List;

import com.sesame.R;


import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<RowItem> 
{
	 
    Context context;
 
    public CustomListViewAdapter(Context context, int resourceId,List<RowItem> items) 
    {
        super(context, resourceId, items);
        this.context = context;
    }
 
    /*private view holder class*/
    private class ViewHolder 
    {
        ImageView imageView;
        TextView qnDesc;
        TextView qnLabel;
        TextView surveyId;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) 
        {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.surveyId = (TextView) convertView.findViewById(R.id.survey_id);
            holder.qnLabel = (TextView) convertView.findViewById(R.id.qn_lbl);
            holder.qnDesc = (TextView) convertView.findViewById(R.id.qn_desc);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } 
        else
            holder = (ViewHolder) convertView.getTag();
 
        holder.surveyId.setText(rowItem.getSurveyId());
        holder.qnDesc.setText(rowItem.getQnNumber());
        holder.qnLabel.setText(rowItem.getSurveyId());
        
        //Setting The Image From Drawable Dir Using Int Id
        //holder.imageView.setImageResource(rowItem.getImageId());
        holder.imageView.setImageResource(R.drawable.add);
        
/*        //holder.imageView.setImageResource(R.drawable.mob_search);
        
      //Setting The Image From Sdcard
        String symbolFileName = rowItem.getImageName().trim();
        String outputPath = Environment.getExternalStorageDirectory()+ "/PMSE/"+symbolFileName; 
        //voterImage.setImageURI(Uri.parse(imagePath));//Input As String filePath(ImageView)
        holder.imageView.setImageURI(Uri.parse(outputPath));
*/        
 
        return convertView;
    }
}
