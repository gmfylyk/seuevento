package com.fylyk.eventos;

import android.content.Context;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Date;

import com.fylyk.eventos.Eventos;
/**
 * Created by gustavo on 14-11-2014.
 */
public class Samples {

    public static ArrayList<Eventos> getSampleEvents(Context ctx){
        ArrayList<Eventos> samples = new ArrayList<Eventos>();
        for (int i = 0 ; i < 6 ; i++) {
            DatePicker dp = new DatePicker(ctx);
            dp.init(2014,04,days[i],null);
            Eventos e = new Eventos(images[i],dp,place[i],organizador[i],nome[i],thumbs[i]);
            samples.add(e);
        }

        return samples;
    }

    private static int[] images = new int[]{
            R.drawable.despedida,
            R.drawable.sushi,
            R.drawable.pizza,
            R.drawable.aniversario,
            R.drawable.frag,
            R.drawable.filmes
    };

    private static int[] thumbs = new int[]{
            R.drawable.despedida_thumb,
            R.drawable.sushi_thumb,
            R.drawable.pizza_thumb,
            R.drawable.aniversario_thumb,
            R.drawable.frag_thumb,
            R.drawable.filmes_thumb
    };

    private static String[] nome = {
            "Despedida",
            "Sushi",
            "Pizza",
            "Aniversário",
            "Frag Night",
            "Filmes",
    };

    private static String[] organizador = {
            "João",
            "Mika",
            "Camila",
            "John",
            "Vanessa",
            "Fylyk"
    };

    private static String[] place = {
            "Casa do João",
            "Tay",
            "PizzaHut",
            "Hamburgueria",
            "UTFPR",
            "IMAX"
    };

    private static int[] days = new int[]{
            16,
            14,
            28,
            7,
            3,
            21
    };
}
