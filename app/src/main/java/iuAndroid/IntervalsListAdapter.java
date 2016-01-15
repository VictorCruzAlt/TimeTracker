package iuAndroid;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import timetracker.iuandroid.R;

/**
 * Created by Victor on 13/1/16.
 */
public class IntervalsListAdapter extends ArrayAdapter<DadesInterval> {

    private final Context context;
    private ArrayList<DadesInterval> act;
    private final Integer[] integers;

    public IntervalsListAdapter(Context context, ArrayList<DadesInterval> act, Integer[] integers) {
        super(context, 0, act);

        this.context=context;
        this.act=act;
        this.integers=integers;
    }

    public View getView(int position,View convertView, ViewGroup parent){
        //Obtenemos los datos para esta posicion
        DadesInterval interval = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_interval, parent, false);
        }

        TextView txtFinal = (TextView) convertView.findViewById(R.id.data_final);
        TextView txtInici = (TextView) convertView.findViewById(R.id.data_inici);
        TextView txtDurada = (TextView) convertView.findViewById(R.id.durada_interval);

        txtFinal.setText(interval.finalToString());
        txtInici.setText(interval.iniciToString());
        txtDurada.setText(interval.duradaToString());

        return convertView;
    }


}
