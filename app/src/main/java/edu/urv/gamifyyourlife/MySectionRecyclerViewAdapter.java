package edu.urv.gamifyyourlife;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.urv.gamifyyourlife.model.ModSection;

import java.util.List;

public class MySectionRecyclerViewAdapter extends RecyclerView.Adapter<MySectionRecyclerViewAdapter.ViewHolder> {

    private final List<ModSection> mValues;
    private final Activity activity;

    public MySectionRecyclerViewAdapter(List<ModSection> items, Activity activity) {
        mValues = items;
        this.activity = (SectionsActivity) activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mContentView.setText(mValues.get(position).content);

        if (holder.mItem.id.equals("1")) {
            holder.mIconSection.setImageResource(R.drawable.sections_1);
        } else if (holder.mItem.id.equals("2")) {
            holder.mIconSection.setImageResource(R.drawable.sections_2);
        } else {
            holder.mIconSection.setImageResource(R.drawable.sections_3);
        }

        if (holder.mItem.level == 0.0) {
            holder.mIconLevel.setImageResource(R.drawable.sad_face);
        } else {
            holder.mIconLevel.setImageResource(R.drawable.happy_face);
        }

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity instanceof SectionsActivity) {
                    ((SectionsActivity) activity).openObjectives(holder.mItem.id);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public final ImageView mIconSection;
        public final ImageView mIconLevel;
        public final CardView mCardView;
        public ModSection mItem;

        public ViewHolder(View view) {
            super(view);
            mContentView = view.findViewById(R.id.content);
            mIconSection = view.findViewById(R.id.iconSection);
            mIconLevel = view.findViewById(R.id.iconLevel);
            mCardView = view.findViewById(R.id.cardView);
        }
    }//

}