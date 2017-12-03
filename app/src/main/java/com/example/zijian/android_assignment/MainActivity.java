package com.example.zijian.android_assignment;

import android.content.Intent;
import android.content.pm.FeatureGroupInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.textservice.TextServicesManager;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.zijian.android_assignment.Adapter.MovieAdapter;
import com.example.zijian.android_assignment.Common.Common;
import com.example.zijian.android_assignment.Model.Movie;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

import static com.example.zijian.android_assignment.Common.Common.movieList;

public class MainActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create data
        initData();
        adapter = new MovieAdapter(Common.movieList,this);
        coverFlow = (FeatureCoverFlow)findViewById(R.id.coverFlow);
        mTitle = (TextSwitcher)findViewById(R.id.mtitle);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener()
        {

            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.movieList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie_index",i);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        //Example data
        Movie movie = new Movie("Justice League",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Justice_league_part_one/Justice_League_Keyart_V4_500.jpg",
                "Fueled by his restored faith in humanity and inspired by Superman’s selfless act, Bruce Wayne enlists the help of his newfound ally, Diana Prince, to face an even greater enemy. Together, Batman and Wonder Woman work quickly to find and recruit a team of metahumans to stand against this newly awakened threat. But despite the formation of this unprecedented league of heroes—Batman, Wonder Woman, Aquaman, Cyborg and The Flash—it may already be too late to save the planet from an assault of catastrophic proportions.");
        Common.movieList.add(movie);

        movie = new Movie("Ah Boys To Men 4",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/Asean_China_Film_Festival_2017/Ah_Boys_To_Men_4/AH_BOYS_TO_MEN_4_500.jpg",
                "Singapore's most successful movie franchise is back! After completion of their full-time national service stints, Lobang, Aloysius, Sergeant Ong, and Ken Chow were all busy with their respective careers as civilians. When they are called back for in-camp training in an SAF Armour unit, the boys must juggle between work and their duties as operationally-ready national servicemen. Hilarious situations happen when they are back training together and their military roles reversed. New enemy threats arise as their brotherhood is put to the test.");
        Common.movieList.add(movie);

        movie = new Movie("Coco",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/coco/Coco_keyart_v6_500.jpg",
                "Despite his family’s baffling generations-old ban on music, Miguel (voice of newcomer Anthony Gonzalez) dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz (voice of Benjamin Bratt). Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector (voice of Gael García Bernal), and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history. Directed by Lee Unkrich (“Toy Story 3”), co-directed by Adrian Molina (story artist “Monsters University”) and produced by Darla K. Anderson (“Toy Story 3”), Disney•Pixar’s “Coco” opens in Malaysian cinemas on Nov. 23, 2017.");
                Common.movieList.add(movie);

        movie = new Movie("The Kid From The Big Apple 2: Before We Forget",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/The_Kids_From_Big_Apple_2/The_Kid_From_The_Big_Apple_2_Keyart_V2_500.jpg",
                "Chungen, is a quite reserved father but a more open and loving grandfather. He is very excited reuniting with his daughter and granddaughter after few years. However, some extraordinary things are happen in his life! The family quickly realise that the risk of forgetting the loving memory of a family member is terrifying.They learn that there is a nothing compares to the love of a close-knit family. Given the sudden changes thrust upon them, they choose to stand and fight. Regardless of the outcome, they conclude that as long as they stay together as a family, ultimately they can overcome any adversity! When we are together as a family, happiness will surround us!");
        Common.movieList.add(movie);

        movie = new Movie ("Thor: Ragnarok",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Thor_Ragnarok/Thor_Ragnarok_Keyart_V5_500.jpg",
                "Imprisoned on the other side of the universe without his hammer, Thor has to race against time to return to Asgard to stop Ragnarok - the destruction of his homeworld and the end of Asgardian civilisation. But before he can battle Hela, the ruthless villain who is responsible for the bedlam, Thor finds himself in a deadly gladiatorial contest going up against a former ally and fellow Avenger, the Incredible Hulk.");
        Common.movieList.add(movie);

        movie = new Movie("Beyond Skyline",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Beyond_Skyline/Beyond_Skyline_Keyart_v2_500.jpg",
                "As the aliens move across the planet, feeding off the remnants of humanity, the resilient Mark (FRANK GRILLO) battles through the bizarre environment, uncovering their horrific secrets. Before long, he forges an alliance with an unlikely ally. Together they are able to crash the ship and rescue several abductees, including an infant girl who holds the key to defeating the aliens' power. \n" +
                        "\n" +
                        "They encounter a highly skilled resistance force, led by the deadly Sua (IKO UWAIS). In a race against time, these warriors from different sides of the world must unite to save their families and take back the planet once and for all.");
        Common.movieList.add(movie);

        movie = new Movie("Paddington 2",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Paddington_2/Paddington_2_Keyart_v2_500.jpg",
                "Paddington, now happily settled with the Brown family and a popular member of the local community, picks up a series of odd jobs to buy the perfect present for his Aunt Lucy's 100th birthday, only for the gift to be stolen.");
        Common.movieList.add(movie);

        movie = new Movie("Deep",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Deep/Deep_Keyart_500.jpg",
                "In 2100, when humanity has abandoned the earth, a colony of extravagant creatures still thrives in the deepest abyss of the ocean. Deep, an adventurous \"dumbo\" octopus and the last one of his kind lives there with his two unconditional friends: Evo, a nerdy and clumsy angler fish, and Alice, a neurotic deep-sea shrimp. When an accident destroys their home, the guardian of the abyss, The Kraken, will send Deep and his friends on a perilous journey to find a new home. In their mission, they will be joined by Maura -a voracious moray eel- and together they will travel to amazing places like the submerged city of New York, the Titanic or the Arctic, facing formidable enemies and hilarious situations. Will they be able to bring the oceans back to their former glory?");
        Common.movieList.add(movie);

        movie = new Movie("Jumanji: Welcome To The Jungle",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Jumanji_Welcome_To_The_Jungle/Jumanji_Welcome_To_Jungle_Keyart_v3_500.jpg",
                "In a brand new Jumanji adventure, four high school kids discover an old video game console and are drawn into the game's jungle setting, literally becoming the adult avatars they chose. What they discover is that you don't just play Jumanji - you must survive it. To beat the game and return to the real world, they'll have to go on the most dangerous adventure of their lives, discover what Alan Parrish left 20 years ago, and change the way they think about themselves - or they'll be stuck in the game forever, to be played by others without break.");
        Common.movieList.add(movie);

        movie = new Movie("Bleeding Steel",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Bleeding_Soul/Bleeding_Steel_Keyart_v2_500.jpg",
                "A special forces agent becomes embroiled in a huge conspiracy while protecting a young woman who is an important witness for a major case. Years later, after the publication of an epic sci-fi novel, the parties behind the conspiracy resurface.");
        Common.movieList.add(movie);

        movie = new Movie("Star Wars: The Last Jedi",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2017/Star_Wars_The_Last_Jedi/Star_Wars_The_Last_Jedi_Keyart_V4_500.jpg",
                "Having taken her first steps into a larger world in Star Wars: The Force Awakens (2015), Rey continues her epic journey with Finn, Poe and Luke Skywalker in the next chapter of the saga.");
        Common.movieList.add(movie);

        movie = new Movie("Insidious: Chapter 4",
                "http://cdn4.gsc.com.my/WebLITE/Applications/MovieManagement/uploaded/pics/2018/Insidious_Chapter_4/Insidious_4_Keyart_v2_500.jpg",
                "Taking place right after \"Chapter 3\", the movie goes back to Elise's beginnings, seeing her at a very different point in her life where her quest to find the person that has been haunting her begins.");
        Common.movieList.add(movie);
    }
}
