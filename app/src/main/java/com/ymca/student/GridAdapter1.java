package com.ymca.student;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.content.ContextCompat.startActivity;


public class GridAdapter1 extends BaseAdapter {

    Context context;
    private final String [] values;
    private final int [] images;
    LayoutInflater layoutInflater;

    public GridAdapter1(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        Holder holder = new Holder();
        View rowView;

        rowView = layoutInflater.inflate(R.layout.single_item1, null);
        holder.tv =( TextView) rowView.findViewById(R.id.textview1);
        holder.img = (ImageView) rowView.findViewById(R.id.imageview1);

        holder.tv.setText(values[position]);
        holder.img.setImageResource(images[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x=values[position];
               Toast.makeText(context, "You Clicked "+values[position], Toast.LENGTH_LONG).show();
//               if(x.equals("Post Vacancies"))
//               {
//                   Intent my=new Intent(GridAdapter1.this,requirementsClass.class);
//                   startActivity(my);
//               }
            }
        });

        return rowView;
    }

    private void startActivity(Intent my) {
        startActivity(my);
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }


}
