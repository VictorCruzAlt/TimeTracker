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

public class OneFragment extends Fragment{

    public OneFragment() {
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

        View v= inflater.inflate(R.layout.fragment_one, container, false); // Sólo para buscar la vista
        ListView projectlist = (ListView) v.findViewById(R.id.listView8); // Encontramos la vista


        // Un click serveix per navegar per l'arbre de projectes, tasques
        // i intervals. Un long click es per cronometrar una tasca, si és que
        // l'item clicat es una tasca (sinó, no es fa res).

        projectlist.setAdapter(LlistaActivitatsActivity.getProjectAdapter());
        projectlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> arg0, final View arg1,
                                    final int pos, final long id) {

                Intent inte = new Intent(LlistaActivitatsActivity.BAIXA_NIVELL);
                inte.putExtra("posicio", pos);
                inte.putExtra("projecte", 1);
                getActivity().sendBroadcast(inte);
                if (LlistaActivitatsActivity.llistaDadesProjectes.get(pos).isProjecte()) {

                    getActivity().sendBroadcast(new Intent(
                            LlistaActivitatsActivity.DONAM_FILLS));

                } else {
                    // no pot ser!
                    assert false : "activitat que no es projecte ni tasca";
                }
            }
        });

        return v;
    }
}
