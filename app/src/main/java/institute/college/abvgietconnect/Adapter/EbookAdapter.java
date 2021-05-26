package institute.college.abvgietconnect.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import institute.college.abvgietconnect.Models.EbookModel;
import institute.college.abvgietconnect.R;
import institute.college.abvgietconnect.pdfViewerActivity;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder>
{
    private Context context;
    private List<EbookModel>list;

    public EbookAdapter(Context context, List<EbookModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, int position) {
        holder.ebookName.setText(list.get(position).getPdftitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(context, pdfViewerActivity.class);
                intent.putExtra("pdfurl",list.get(position).getPdfurl());
                context.startActivity(intent);
            }
        });
        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfurl()));
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {
        private TextView ebookName;
        private ImageView ebookDownload;

        private ProgressDialog progressDialog;
        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);
            ebookDownload=itemView.findViewById(R.id.ebookDownload);
            ebookName= itemView.findViewById(R.id.ebookName);

        }
    }
}
