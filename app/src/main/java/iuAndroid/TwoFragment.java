package iuAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import timetracker.iuandroid.R;

/**
 * Created by Victor on 30/12/15.
 */

public class TwoFragment extends Fragment{

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_two, container, false); // Sólo para buscar la vista
        ListView tasklist = (ListView) v.findViewById(R.id.listViewT); // Encontramos la vista


        // Un click serveix per navegar per l'arbre de projectes, tasques
        // i intervals. Un long click es per cronometrar una tasca, si és que
        // l'item clicat es una tasca (sinó, no es fa res).

        tasklist.setAdapter(LlistaActivitatsActivity.getTasksAdapter());
        tasklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> arg0, final View arg1,
                                    final int pos, final long id) {

                Intent inte = new Intent(LlistaActivitatsActivity.BAIXA_NIVELL);
                inte.putExtra("posicio", pos);
                getActivity().sendBroadcast(inte);
                if (LlistaActivitatsActivity.llistaDadesTasks.get(pos).isTasca()) {

                    startActivity(new Intent(getActivity(),
                            LlistaIntervalsActivity.class));
                    // en aquesta classe ja es demanara la llista de fills
                } else {
                    // no pot ser!
                    assert false : "activitat que no es projecte ni tasca";
                }
            }
        });

        // Un "long click" serveix per cronometrar, si es tracta d'una tasca.
        // Si es un projecte, no fara res.
       tasklist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> arg0,
                                           final View arg1, final int pos, final long id) {
                    Intent inte;
                    if (!LlistaActivitatsActivity.llistaDadesTasks.get(pos).isCronometreEngegat()) {
                        inte = new Intent(
                                LlistaActivitatsActivity.ENGEGA_CRONOMETRE);
                    } else {
                        inte = new Intent(
                                LlistaActivitatsActivity.PARA_CRONOMETRE);
                    }
                    inte.putExtra("posicio", pos);
                    getActivity().sendBroadcast(inte);
                return true;
            }
        });

        return v;
    }

}
