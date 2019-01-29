package erkaneroglu.com.lolguide.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import erkaneroglu.com.lolguide.DetailActivity;
import erkaneroglu.com.lolguide.Modals.Hero;
import erkaneroglu.com.lolguide.R;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {
    Context context;
    List<Hero> list;

    public HeroAdapter(Context context, List<Hero> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_item_design, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.champion_name.setText(list.get(i).getHeroName());
        Picasso.get().load(list.get(i).getHeroArtImage()).into(myViewHolder.champion_image);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("hero_image", list.get(i).getHeroImage());
                intent.putExtra("hero_name", list.get(i).getHeroName());
                intent.putExtra("hero_long_name", list.get(i).getHeroLongName());
                intent.putExtra("hero_lane", list.get(i).getHeroLane());
                intent.putExtra("hero_nation", list.get(i).getHeroNation());
                intent.putExtra("rp", list.get(i).getRp());
                intent.putExtra("turuncu_oz", list.get(i).getTuruncuOz());
                intent.putExtra("popularity", list.get(i).getPopularity());

                intent.putExtra("hero_story", list.get(i).getStory());

                intent.putExtra("can", list.get(i).getCan());
                intent.putExtra("mana_yenilenmesi", list.get(i).getManaYenilenmesi());
                intent.putExtra("saldiri_hizi", list.get(i).getSaldiriHizi());
                intent.putExtra("can_yenilenmesi", list.get(i).getCanYenilenmesi());
                intent.putExtra("menzil", list.get(i).getMenzil());
                intent.putExtra("zirh", list.get(i).getZirh());
                intent.putExtra("haraket_hizi", list.get(i).getHaraketHizi());
                intent.putExtra("mana", list.get(i).getMana());
                intent.putExtra("saldiri_hasari", list.get(i).getSaldiriHasari());
                intent.putExtra("buyu_direnci", list.get(i).getBuyuDirenci());

                intent.putExtra("passive_name", list.get(i).getPassiveName());
                intent.putExtra("passive_description", list.get(i).getPassiveDescription());
                intent.putExtra("passive_image", list.get(i).getPassiveImage());

                intent.putExtra("q_name", list.get(i).getQName());
                intent.putExtra("q_description", list.get(i).getQDescription());
                intent.putExtra("q_image", list.get(i).getQImage());

                intent.putExtra("w_name", list.get(i).getWName());
                intent.putExtra("w_description", list.get(i).getWDescription());
                intent.putExtra("w_image", list.get(i).getWImage());

                intent.putExtra("e_name", list.get(i).getEName());
                intent.putExtra("e_description", list.get(i).getEDescription());
                intent.putExtra("e_image", list.get(i).getEImage());

                intent.putExtra("r_name", list.get(i).getRName());
                intent.putExtra("r_description", list.get(i).getRDescription());
                intent.putExtra("r_image", list.get(i).getRImage());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView champion_name;
        ImageView champion_image;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            champion_name = itemView.findViewById(R.id.hero_name_id);
            champion_image = itemView.findViewById(R.id.hero_art_image_id);
            cardView = itemView.findViewById(R.id.card_view_id);
        }
    }

    public void updateList(List<Hero> listItem) {
        list = new ArrayList<>();
        list.addAll(listItem);
        notifyDataSetChanged();

    }


}
