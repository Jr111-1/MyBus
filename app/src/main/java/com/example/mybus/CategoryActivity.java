package com.example.mybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.mybus.bean.Category;
import com.example.mybus.bean.Movies;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    List<Category> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        textView = (TextView) findViewById(R.id.tw_category);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_category);

        //模拟数据的传输
        for(int j = 0; j<50; j++){
            Category category = new Category();
            category.CategotyName = "类别" + j;
            for(int i = 0; i < 30; i++){
                Movies movies = new Movies("movies"+i, "ipx"+i, R.drawable.jinx,"actor"+i,"分类"+i,"出版社"+i,"制作商"+i,"发行日期"+i,"时长"+i,"系列"+i);
                category.category_movieList.add(movies);
            }
            categoryList.add(category);

        }

        //为recyclerview添加适配器
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        recyclerView.setAdapter(categoryAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(CategoryActivity.this,3);
        recyclerView.setLayoutManager(gridLayoutManager);//表格布局
        DividerItemDecoration mDivider = new
                DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDivider);

    }

    //定义viewHolder
    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_item_id);//为recyclerView绑定item中的控件
        }
    }

    //定义recyclerView的适配器
    class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{

        @NonNull
        @Override
        public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(CategoryActivity.this,R.layout.category_item,null);

            CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);

            return categoryViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
            Category category = categoryList.get(position);
            holder.categoryName.setText(category.getCategotyName());

            //为item添加点击事件并传输数据
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(CategoryActivity.this,MovieListActivity.class);
                    intent.putExtra("category",category);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return categoryList.size();
        }
    }
}