package com.villaverde.labcalificado.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.villaverde.labcalificado.R;
import com.villaverde.labcalificado.activitys.DatosActivity;
import com.villaverde.labcalificado.modelo.Comidas;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;


public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {

    private List<Comidas> comida;
    View itemView;

    public void setPeople(List<Comidas> people) {
        this.comida = people;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView pictureImage;
        TextView fullnameText;
        TextView numberText;


        public ViewHolder(View itemView) {
            super(itemView);
            pictureImage = itemView.findViewById(R.id.picture_image);
            fullnameText = itemView.findViewById(R.id.fullname_text);
            numberText= itemView.findViewById(R.id.number_text);

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vistas, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Comidas Comidas = comida.get(position);

        int resId = holder.itemView.getContext().getResources().getIdentifier(Comidas.getPicture(), "drawable", holder.itemView.getContext().getPackageName());
        holder.pictureImage.setImageResource(resId);

        holder.fullnameText.setText(Comidas.getFullname());
        holder.numberText.setText(Comidas.getNumber());

        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), DatosActivity.class);
//                itemView.getContext().startActivity(intent);
                intent.putExtra("name", Comidas.getFullname());
                intent.putExtra("descrip", Comidas.getDescripcion());
                intent.putExtra("phone", Comidas.getNumber());
                intent.putExtra("image", Comidas.getPicture());
                intent.putExtra("email", Comidas.getEmail());
                intent.putExtra("direc", Comidas.getDireccion());
                intent.putExtra("url", Comidas.getUrl());

                holder.itemView.getContext().startActivity(intent);
            }

        });
    }
    @Override
    public int getItemCount() {
        return comida.size();
    }

    public void filterList(ArrayList<Comidas> filteredList){
        comida = filteredList;
        notifyDataSetChanged();
    }

}

