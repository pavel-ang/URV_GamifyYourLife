package edu.urv.gamifyyourlife;

import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import edu.urv.gamifyyourlife.model.ModObjective;
import java.util.List;

public class MyObjectivesRecyclerViewAdapter extends RecyclerView.Adapter<MyObjectivesRecyclerViewAdapter.ViewHolder> {

    private final List<ModObjective> mValues;
    private final ObjectivesActivity activity;

    public MyObjectivesRecyclerViewAdapter(List<ModObjective> items, ObjectivesActivity activity) {
        mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.objective_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(holder.mItem.content);

        holder.mCheck.setOnCheckedChangeListener(null);
        holder.mText.removeTextChangedListener(holder.textWatcher);

        if (holder.mItem.type == ModObjective.ObjType.YES_NO) {
            holder.mCheck.setVisibility(View.VISIBLE);
            holder.mText.setVisibility(View.GONE);
            holder.mCheck.setChecked(holder.mItem.b_value);
        } else {
            holder.mCheck.setVisibility(View.GONE);
            holder.mText.setVisibility(View.VISIBLE);
            holder.mText.setText(String.valueOf(holder.mItem.act_value));
        }

        holder.textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String s1 = s.toString();
                if(s1.trim().isEmpty()) {
                    holder.mItem.act_value = 0;
                } else {
                    try {
                        holder.mItem.act_value = Integer.parseInt(s1);
                    } catch (Exception e) {
                        holder.mItem.act_value = 0;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
        holder.mText.addTextChangedListener(holder.textWatcher);

        holder.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.mItem.b_value = isChecked;
            }
        });
    }

    @Override
    public int getItemCount() { return mValues.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public final EditText mText;
        public final CheckBox mCheck;
        public ModObjective mItem;
        public TextWatcher textWatcher;

        public ViewHolder(View view) {
            super(view);
            mContentView = view.findViewById(R.id.content);
            mText = view.findViewById(R.id.edit_value);
            mCheck = view.findViewById(R.id.check_box);
        }
    }
}