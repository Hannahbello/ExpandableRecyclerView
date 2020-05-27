package com.example.expandablerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.MyViewHolder> {

    List<Model> modelList;

    public VersionAdapter(List<Model> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = modelList.get(position);

        holder.codeText.setText(model.getCodeName());
        holder.versionText.setText(model.getVersion());
        holder.apiText.setText(model.getApiLevel());
        holder.descText.setText(model.getDescription());

        boolean isExpandable = modelList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE:View.GONE);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
         TextView codeText,versionText,apiText,descText;

         LinearLayout linearLayout;
         RelativeLayout expandableLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            codeText = itemView.findViewById(R.id.code_name);
            versionText = itemView.findViewById(R.id.version);
            apiText = itemView.findViewById(R.id.apiLevel);
            descText = itemView.findViewById(R.id.description);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            //here,you set a click listener for the linear layout
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Model model = modelList.get(getAdapterPosition());
                    model.setExpandable(! model.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
