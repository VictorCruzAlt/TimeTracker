package iuAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import timetracker.iuandroid.R;
import java.util.ArrayList;

public class ActivityListAdapter extends ArrayAdapter<DadesActivitat> {

    private final Context context;
    private ArrayList<DadesActivitat> act;
    private final Integer[] integers;

    public ActivityListAdapter(Context context, ArrayList<DadesActivitat> act, Integer[] integers) {
        super(context, R.layout.fila_llista,act);

        this.context=context;
        this.act=act;
        this.integers=integers;
    }

    public View getView(int position,View convertView, ViewGroup parent){
        //Obtenemos los datos para esta posicion
        DadesActivitat act = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_llista, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.icon);
        ImageView imageView3 = (ImageView) convertView.findViewById(R.id.icon3);
        TextView txtNom = (TextView) convertView.findViewById(R.id.nom);
        TextView txtDurada = (TextView) convertView.findViewById(R.id.durada);

        //Escogemos un icono dependiendo del tipo de actividad
        if(act.isProjecte()){
            imageView.setImageResource(integers[0]);
            imageView3.setImageResource(integers[2]);
        }
        else{
            imageView.setImageResource(integers[1]);
            imageView3.setImageResource(0);
        }
        txtNom.setText(act.nomToString());
        txtDurada.setText(act.duradaToString());

        return convertView;
    }


}
