package co.edu.sanmateo.com.fodelin.Model;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.edu.sanmateo.com.fodelin.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends ArrayAdapter<ItemResultados>{

    Context mycontext;
    int mylayoutResoursesID;
    ItemResultados mydata [] = null;

    public Adapter(Context context, int layoutResoursesID, ItemResultados[]data){
        super(context, layoutResoursesID, data);

        this.mycontext = context;
        this.mylayoutResoursesID = layoutResoursesID;
        this.mydata = data;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ItemResultadosHolder holder = null;

        if (row == null){
            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row = inflater.inflate( mylayoutResoursesID, parent, false );

            holder = new ItemResultadosHolder();
            holder.imageView = (CircleImageView)row.findViewById( R.id.img_tipo );
            holder.textView = (TextView)row.findViewById( R.id.txt_nombre );
            holder.textView1 = (TextView)row.findViewById( R.id.txt_documento);
            holder.textView2 = (TextView)row.findViewById( R.id.txt_fecha );
            holder.textView3 = (TextView)row.findViewById( R.id.txt_compañia );
            row.setTag( holder );

        }else {
            holder = (ItemResultadosHolder)row.getTag();
        }

        ItemResultados itemResultados = mydata[position];
        holder.textView.setText( itemResultados.getTitulo());
        holder.textView1.setText( itemResultados.getDocumento());
        holder.textView2.setText( itemResultados.getFecha());
        holder.textView3.setText( itemResultados.getCompañia());
        holder.imageView.setImageResource( itemResultados.getImagenTipo() );
        return row;
    }

    static class ItemResultadosHolder{
        CircleImageView imageView;
        TextView textView, textView1, textView2, textView3;
    }
}