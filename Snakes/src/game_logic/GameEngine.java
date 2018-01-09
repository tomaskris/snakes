package game_logic;

import static constants.Constants.FRAME_DELAY;

/**
 *
 * @author Tomáš
 */
public abstract class GameEngine implements Runnable {

    //ako dlho bezal jeden cyklus, pomocna premenna pri synchronizacii FPS
    private long cycleTime;
    
    protected long updateTick = 0;

    public void startGameLoop() {
        Thread t = new Thread(this, "Game");
        t.start();
    }

    @Override
    public void run() {
        cycleTime = System.currentTimeMillis();

        while (shouldRunGameLoop()) {
            update();
            updateTick++;
            
            render();

            syncFrameRate();
        }

        onGameLoopStop();
    }

    /**
     * Synchronize frames
     */
    private void syncFrameRate() {
        cycleTime += FRAME_DELAY;
        long difference = cycleTime - System.currentTimeMillis();
        try {
            Thread.sleep(Math.max(0, difference));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cycleTime = System.currentTimeMillis();
    }

    /**
     * Template method
     *
     * @return
     */
    public abstract boolean shouldRunGameLoop();

    /**
     * Template method
     */
    public abstract void update();

    /**
     * Template method
     */
    public abstract void render();

    /**
     * Hook method
     */
    public void onGameLoopStop() {

    }

}
