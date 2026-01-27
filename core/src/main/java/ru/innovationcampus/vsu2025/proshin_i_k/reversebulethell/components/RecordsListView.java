package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSettings;

import java.util.ArrayList;

public class RecordsListView extends TextView {

    public RecordsListView(BitmapFont font, float y) {
        super(font, 0, y, "");
    }

    public void setRecords(ArrayList<Integer> recordsList) {
        text = "";
        if (recordsList == null) return;
        int countOfRows = Math.min(recordsList.size(), 5);
        for (int i = 0; i < countOfRows; i++) {
            text += (i + 1) + ". - " + recordsList.get(i) + "\n";
        }

        GlyphLayout glyphLayout = new GlyphLayout(font, text);
        x = (GameSettings.SCREEN_WIDTH - glyphLayout.width) / 2;
    }

}

