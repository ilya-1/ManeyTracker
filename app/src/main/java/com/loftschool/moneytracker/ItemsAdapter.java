package com.loftschool.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Record> data = new ArrayList<>();

    public ItemsAdapter() {
        createData();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_record, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Record record = data.get(position);
        holder.applyData(record);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void createData() {
        data.add(new Record("Молоко", 35));
        data.add(new Record("Жизнь", 1));
        data.add(new Record("Курсы", 50));
        data.add(new Record("Хлеб", 26));
        data.add(new Record("Тот самый ужин который я оплатил за всех потому что платил картой", 600000));
        data.add(new Record("", 0));
        data.add(new Record("Тот самый ужин", 604));
        data.add(new Record("ракета Falcon Heavy", 1));
        data.add(new Record("Лего Тысячелетний сокол", 100000000));
        data.add(new Record("Монитор", 100));
        data.add(new Record("MacBook Pro", 100));
        data.add(new Record("Шоколадка", 100));
        data.add(new Record("Шкаф", 100));
        data.add(new Record("Молоко", 35));
        data.add(new Record("Жизнь", 1));
        data.add(new Record("Курсы", 50));
    }

     static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Record record) {
            String RUB = "%1$s \u20BD";
            String prs = String.valueOf(record.getPrice());
            title.setText(String.valueOf(record.getTitle()));
            price.setText(String.format(RUB, prs));
        }
    }

}

