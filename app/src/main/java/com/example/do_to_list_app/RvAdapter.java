package com.example.do_to_list_app;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.do_to_list_app.databinding.EachRvBinding;

public class RvAdapter extends ListAdapter<Note,RvAdapter.ViewHolder> {
    public RvAdapter(){
        super(Callback);
    }
    private static final DiffUtil.ItemCallback<Note>Callback=new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getDisp().equals(newItem.getDisp());
        }
    };
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note=getItem(position);
        holder.binding.titleRv.setText(note.getTitle());
        holder.binding.disRv.setText(note.getDisp());
    }
    public Note getNote(int  position){
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EachRvBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=EachRvBinding.bind(itemView);
        }
    }
}