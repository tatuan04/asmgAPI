package com.example.asmgapi.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.asmgapi.R;
public class test  extends RecyclerView.Adapter<test.ProductViewHolder> {

        private String[] products;


        public test(String[] products) {
            this.products = products;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_san_pham, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.textViewProductName.setText(products[position]);
        }

        @Override
        public int getItemCount() {
            return products.length;
        }

        public static class ProductViewHolder extends RecyclerView.ViewHolder {
            TextView textViewProductName;

            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewProductName = itemView.findViewById(R.id.txtTensp);
            }
        }
    }

