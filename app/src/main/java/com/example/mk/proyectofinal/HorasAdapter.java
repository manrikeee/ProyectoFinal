package com.example.mk.proyectofinal;

/**
 * Created by Mk on 13/06/2016.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HorasAdapter extends RecyclerView.Adapter<HorasAdapter.ItemViewHolder>{
    List<Productos> horas;
    static double total=0;
    MyDialogFragment dialog;

    public HorasAdapter(List<String> horas,MyDialogFragment dialog) {
        MainActivity.carro.setVisible(true);
        this.dialog=dialog;

        this.horas = ExpandableListAdapter.productos_pedidos;
    }

    @Override
    public HorasAdapter.ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dialog, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(final HorasAdapter.ItemViewHolder holder, final int position) {

        holder.time.setText(horas.get(position).getProducto().toString());
        holder.precio.setText( String.valueOf(horas.get(position).getPrecio())) ;
//        holder.total.setText("EEEEEE");
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // horas.remove(position);
                ExpandableListAdapter.productos_pedidos.remove(position);
                if(horas.size()==0){
                    MainActivity.carro.setVisible(false);
                    dialog.dismiss();
                }

                notifyDataSetChanged();
            }
        });
        MyDialogFragment.Actualizartotal();



    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public int getItemCount() {

        return horas.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        public ImageButton del;
        TextView precio;


        ImageView reloj;

        ItemViewHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.text1);
            del = (ImageButton) itemView.findViewById(R.id.delete);
            precio= (TextView) itemView.findViewById(R.id.precio);



        }
    }

}

