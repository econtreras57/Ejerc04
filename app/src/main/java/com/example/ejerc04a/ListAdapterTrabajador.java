package com.example.ejerc04a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerc04a.domain.ObjetoTrabajador;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterTrabajador
        extends RecyclerView.Adapter<ListAdapterTrabajador.TrabajadorViewHolder> {

    public OnItemClickListener mlistener;
    private Context mContext;
    private List<ObjetoTrabajador> items = new ArrayList<>();   // items, definición solamente

    public ListAdapterTrabajador(
            OnItemClickListener listener,
            Context context,
            ArrayList<ObjetoTrabajador> item
    )     {

        this.mlistener = listener;
        this.mContext = context;
        this.items = item;

    }

    public interface OnItemClickListener {
        void onItemClicked(View v);
    }
    public void add(ObjetoTrabajador item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }
    @Override
    public TrabajadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from
                (parent.getContext()).inflate(R.layout.ly_item_trabajador, parent, false);

        TrabajadorViewHolder rvMainAdapterViewHolder = new TrabajadorViewHolder(view);

        return rvMainAdapterViewHolder;
    }
    @Override
    public void onBindViewHolder(final TrabajadorViewHolder holder, int position) {

        ObjetoTrabajador ObjetoTrabajador = items.get(position);

        holder.nombre.setText(ObjetoTrabajador.getNombre());
        holder.dni.setText(ObjetoTrabajador.getDni());
        holder.direccion.setText(ObjetoTrabajador.getDireccion());
        holder.salario.setText(ObjetoTrabajador.getSalario());

        holder.position.setText(Integer.toString(position));     // guarda la posición (funcionará?)

    }
    @Override
    public int getItemCount() {

        return items.size();
    }

    class TrabajadorViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView nombre;
        TextView dni;
        TextView direccion;
        TextView salario;

        TextView position;   // para guardar la pos.


        public TrabajadorViewHolder(View v) {
            super(v);

            nombre=(TextView)v.findViewById(R.id.tv_nombre);
            dni=(TextView)v.findViewById(R.id.tv_dni);
            direccion=(TextView)v.findViewById(R.id.tv_direccion);
            salario=(TextView)v.findViewById(R.id.tv_salario);

            position=(TextView)v.<View>findViewById(R.id.tv_position);

            v.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

      /*    SharedPreferences preferencias =
                v.getContext().getSharedPreferences("TareaSeleccionada", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString("id_tarea", id_tarea.getText().toString());
            editor.putString("detalleTarea", detalleTarea.getText().toString());
            editor.putString("fechaTarea", fechaTarea.getText().toString());
            editor.putString("nombreTarea", nombreTarea.getText().toString());
            editor.putString("terminada", terminada.getText().toString());
            editor.commit();
*/
            mlistener.onItemClicked(v );

        }
    }

}

