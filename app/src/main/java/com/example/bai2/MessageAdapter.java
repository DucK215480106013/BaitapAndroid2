package com.example.bai2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
    private List<MessageModel> messageList;
    private Context context;

    public MessageAdapter(Context context, List<MessageModel> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        MessageModel message = messageList.get(position);
        holder.tvId.setText("ID: " + message.getId());
        holder.tvTomtat.setText("Tóm tắt: " + message.getTitle());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChiTietActivity.class);
            intent.putExtra("id", message.getId());
            intent.putExtra("userID", message.getUserId());
            intent.putExtra("tomtat", message.getTitle());
            intent.putExtra("fullbody", message.getBody());

            // Kiểm tra nếu context không phải Activity
            if (!(context instanceof android.app.Activity)) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }

            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return messageList.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTomtat;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTomtat = itemView.findViewById(R.id.tv_tomtat);
        }
    }
}
