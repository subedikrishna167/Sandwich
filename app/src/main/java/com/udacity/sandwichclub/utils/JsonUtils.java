package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static Sandwich sw = new Sandwich();


    public static Sandwich parseSandwichJson(String json) {
        String sandwichMainName = "";
        String sandwichPlaceOfOrigin = "";
        String sandwichDescription = "";
        String sandwichImageUrl = "";
        List<String> ingredient = new ArrayList<String>();
        List<String> alsoKnownAs = new ArrayList<String>();

        try {

            JSONObject jsonRootObject = new JSONObject(json);
            JSONObject name = jsonRootObject.getJSONObject("name");
            sandwichMainName = name.getString("mainName");
            JSONArray alsoKnownAs1 = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAs1.length(); i++) {
                alsoKnownAs.add(alsoKnownAs1.getString(i));
            }
            sandwichPlaceOfOrigin = jsonRootObject.getString("placeOfOrigin");
            sandwichDescription = jsonRootObject.getString("description");
            sandwichImageUrl = jsonRootObject.getString("image");
            JSONArray ingridents = jsonRootObject.getJSONArray("ingredients");
            for (int j = 0; j < ingridents.length(); j++) {
                ingredient.add(ingridents.getString(j));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        sw.setMainName(sandwichMainName);
        sw.setDescription(sandwichDescription);
        sw.setImage(sandwichImageUrl);
        sw.setPlaceOfOrigin(sandwichPlaceOfOrigin);
        sw.setIngredients(ingredient);
        sw.setAlsoKnownAs(alsoKnownAs);
        sw.setImage(sandwichImageUrl);

        return sw;
    }

}
