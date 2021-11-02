package com.example.cafemenu;

import android.content.Context;

import java.util.ArrayList;

public class FoodData {
    public static ArrayList<Food> getData(Context context) {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food("Batagor", "Batagor adalah masakan Sunda dari Indonesia, dan populer di Asia Tenggara, terdiri dari pangsit ikan goreng, biasanya disajikan dengan saus kacang.", 10000, context.getDrawable(R.drawable.batagor)));
        list.add(new Food("Black Salad", "sehatnya salad buah ditambah dengan manfaat dari Charcoal active cocok banget untuk jadi salah satu alternatif makanan sehari2", 5000, context.getDrawable(R.drawable.black_salad)));
        list.add(new Food("Caphuchino", "Cappuccino adalah minuman kopi berbasis espresso yang berasal dari Italia, dan disiapkan dengan busa susu kukus. Variasi minuman melibatkan penggunaan krim sebagai pengganti susu, menggunakan pengganti susu non-susu dan penyedap dengan kayu manis atau bubuk coklat.", 13000, context.getDrawable(R.drawable.cappuchino)));
        list.add(new Food("Cheesecake", "Cheesecake adalah makanan penutup manis yang terdiri dari satu atau lebih lapisan. Lapisan utama dan paling tebal terdiri dari campuran keju segar yang lembut, telur, dan gula.", 23000, context.getDrawable(R.drawable.cheesecake)));
        list.add(new Food("Cireng", "Tepung Tapioka Goreng alias Cireng adalah makanan tradisional khas Indonesia yang enak yang bisa dijadikan cemilan/makanan pembuka yang mudah dan sederhana dengan saus kacang atau saus rujak.", 1000, context.getDrawable(R.drawable.cireng)));
        list.add(new Food("Donut", "Donat atau donat adalah sejenis adonan goreng yang beragi. Ini populer di banyak negara dan disiapkan dalam berbagai bentuk sebagai camilan manis yang bisa dibuat sendiri atau dibeli di toko roti, supermarket, warung makan, dan vendor khusus waralaba.", 50000, context.getDrawable(R.drawable.donut)));
        list.add(new Food("Kopi Hitam", "Kopi hitam, merupakan hasil ektraksi langsung dari perebusan biji kopi yang disajikan tanpa penambahan perisa apapun. Espreso, merupakan kopi yang dibuat dengan mengekstraksi biji kopi menggunakan uap panas pada tekanan tinggi.", 1000, context.getDrawable(R.drawable.kopi_hitam)));
        list.add(new Food("Mie Goreng", "Mie goreng, also known as bakmi goreng, is an Indonesian style of stir fried noodle dish. It is made with thin yellow noodles stir fried in cooking oil with garlic, onion or shallots, fried prawn, chicken, beef, or sliced bakso, chili, Chinese cabbage, cabbages, tomatoes, egg, and other vegetables.", 15000, context.getDrawable(R.drawable.mie_goreng)));
        list.add(new Food("Nasi Goreng", "Nasi goreng adalah hidangan nasi goreng Asia Tenggara, biasanya dimasak dengan potongan daging dan sayuran.", 21000, context.getDrawable(R.drawable.nasigoreng)));
        list.add(new Food("Sparkling Tea", "Air teh berkarbonasi adalah air teh yang mengandung gas karbon dioksida terlarut, baik yang disuntikkan secara artifisial di bawah tekanan atau terjadi karena proses geologis alami.", 12000, context.getDrawable(R.drawable.sparkling_tea)));

        return list;
    }
}
