package com.killshadow.exam.profession;

import java.util.*;

/**
 * Play music founcation.
 */
public class MusicPlayer {
    private int currentCap = 0;
    private int addTimer = 0;
    private int playTimer = 0;
    private int capacity;

    private Map<Integer, Music> musicMap = new HashMap<>();

    /**
     * MusicPlayer constructor.
     *
     * @param capacity max music capacity.
     */
    public MusicPlayer(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Add music to music player.
     *
     * @param musicId music identify number.
     * @return -1 if contain, or 0 if doesn't delete music, or musicId if delete music.
     */
    public int addMusic(int musicId) {
        addTimer++;
        if (musicMap.containsKey(musicId)) {
            return -1;
        }
        if (currentCap < capacity) {
            musicMap.put(musicId, new Music(musicId, 0, 0, addTimer));
            currentCap++;
            return 0;
        }
        int oldMusic = deleteOldMusic();
        musicMap.put(musicId, new Music(musicId, 0, 0, addTimer));
        currentCap++;
        return oldMusic;
    }

    /**
     * Play music to user.
     *
     * @param musicId music identify number.
     * @return false if haven't this music, or true if play success.
     */
    public boolean playMusic(int musicId) {
        playTimer++;
        if (!musicMap.containsKey(musicId)) {
            return false;
        }
        Music music = musicMap.get(musicId);
        music.playTimes++;
        if (music.firstPlayTime == 0) {
            music.firstPlayTime = playTimer;
        }
        return true;
    }

    /**
     * Delete music from music player.
     *
     * @param musicId music identify number.
     * @return false if haven't this music, or true if delete success.
     */
    public boolean deleteMusic(int musicId) {
        if (!musicMap.containsKey(musicId)) {
            return false;
        }
        currentCap--;
        musicMap.remove(musicId);
        return true;
    }

    private int deleteOldMusic() {
        List<Music> musicList = new ArrayList<>(musicMap.values());
        musicList.sort((o1, o2) -> {
            if (o1.playTimes == o2.playTimes) {
                if (o1.playTimes != 0) {
                    return o1.firstPlayTime - o2.firstPlayTime;
                }
                return o1.addTime - o2.addTime;
            }
            return o1.playTimes - o2.playTimes;
        });
        int musicId = musicList.get(0).musicId;
        deleteMusic(musicId);
        return musicId;
    }

    class Music {
        // 音乐编号
        int musicId;

        // 播放记录
        int playTimes;

        // 首次播放时间
        int firstPlayTime;

        // 首次添加时间
        int addTime;

        Music(int musicId, int playTimes, int firstPlayTime, int addTime) {
            this.musicId = musicId;
            this.playTimes = playTimes;
            this.firstPlayTime = firstPlayTime;
            this.addTime = addTime;
        }
    }
}
