package edu.urv.gamifyyourlife;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.urv.gamifyyourlife.model.DataSource;

public class ObjectivesFragment extends Fragment {

    public ObjectivesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_objectives_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            ObjectivesActivity act = (ObjectivesActivity) getActivity();

            if (act != null) {
                recyclerView.setAdapter(new MyObjectivesRecyclerViewAdapter(
                        DataSource.getInstance().getObjectives(act.section_id),
                        act
                ));
            }
        }
        return view;
    }
}