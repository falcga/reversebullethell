package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell;
import com.badlogic.gdx.utils.TimeUtils;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.managers.MemoryManager;

import java.util.ArrayList;


public class GameSession {

    public GameState state;
    long nextShipSpawnTime;
    long sessionStartTime;
    long pauseStartTime;
    private int score;
    int destroyedShipsNumber;

    public GameSession() {
    }

    public void startGame() {
        state = GameState.PLAYING;
        score = 0;
        destroyedShipsNumber = 0;
        sessionStartTime = TimeUtils.millis();
        nextShipSpawnTime = sessionStartTime + (long) (GameSettings.STARTING_SHIP_APPEARANCE_COOL_DOWN
                * getShipPeriodCoolDown());
    }

    public void pauseGame() {
        state = GameState.PAUSED;
        pauseStartTime = TimeUtils.millis();
    }

    public void resumeGame() {
        state = GameState.PLAYING;
        sessionStartTime += TimeUtils.millis() - pauseStartTime;
    }

    public void endGame() {
        updateScore();
        state = GameState.ENDED;
        ArrayList<Integer> recordsTable = MemoryManager.loadRecordsTable();
        if (recordsTable == null) {
            recordsTable = new ArrayList<>();
        }
        int foundIdx = 0;
        for (; foundIdx < recordsTable.size(); foundIdx++) {
            if (recordsTable.get(foundIdx) < getScore()) break;
        }
        recordsTable.add(foundIdx, getScore());
        MemoryManager.saveTableOfRecords(recordsTable);
    }

    public void destructionRegistration() {
        destroyedShipsNumber += 1;
    }

    public void updateScore() {
        score = (int) (TimeUtils.millis() - sessionStartTime) / 100 + destroyedShipsNumber * 100;
    }

    public int getScore() {
        return score;
    }

    public boolean shouldSpawnShip() {
        if (nextShipSpawnTime <= TimeUtils.millis()) {
            nextShipSpawnTime = TimeUtils.millis() + (long) (GameSettings.STARTING_SHIP_APPEARANCE_COOL_DOWN
                    * getShipPeriodCoolDown());
            return true;
        }
        return false;
    }

    private float getShipPeriodCoolDown() {
        return (float) Math.exp(-0.001 * (TimeUtils.millis() - sessionStartTime + 1) / 1000);
    }
}
