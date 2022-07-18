package org.laplace.systems.soundmanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class SoundManager {

        public HashMap<String, Raylib.Sound> sounds;

        public SoundManager() {
            InitAudioDevice();

            sounds = new HashMap<String, Raylib.Sound>();

            this.LoadSound("battlebeggining", "data/sounds/battle/battlebeggining.wav");

            this.LoadSound("footstep1", "data/sounds/ambient/footstep1.wav");
            this.LoadSound("footstep2", "data/sounds/ambient/footstep2.wav");
            this.LoadSound("footstep3", "data/sounds/ambient/footstep3.wav");

            this.LoadSound("dice1", "data/sounds/battle/dice1.wav");
            this.LoadSound("dice2", "data/sounds/battle/dice2.wav");
            this.LoadSound("shake", "data/sounds/battle/shake.wav");

            this.LoadSound("scream", "data/sounds/ambient/scream.wav");
        }

        public void LoadSound(String name, String path) {
            Raylib.Sound sound = Raylib.LoadSound(path);
            sounds.put(name, sound);
        }

        public void PlaySound(String name, float value) {
            SetSoundVolume(sounds.get(name), value);
            PlaySoundMulti(sounds.get(name));
        }

        public void unloadSound(String name) {
            UnloadSound(sounds.get(name));
        }
}
