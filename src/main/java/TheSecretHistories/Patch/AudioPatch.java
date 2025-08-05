package TheSecretHistories.Patch;

import TheSecretHistories.ModConfig.TSHModConfig;
import com.badlogic.gdx.audio.Music;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.audio.MainMusic;

import static com.megacrit.cardcrawl.audio.MainMusic.newMusic;

public class AudioPatch {

    @SpirePatch(clz = MainMusic.class, method = "getSong")
    public static class MainMusicPatch {

        @SpirePrefixPatch
        public static SpireReturn<Music> GetMusicPatchMethod(MainMusic __mainMusic, String key) {

            if (TSHModConfig.EnableCultistSimulatorMusic){

                Music song = GetCultistSong(key);

                if (song != null) {

                    return SpireReturn.Return(song);

                }

            }

            return SpireReturn.Continue();
        }

        private static Music GetCultistSong(String key) {
            switch (key) {
                case "Exordium":
                    return newMusic(MakeMusicPath("10 Impending Semi-Doom"));
                case "TheCity":
                    return newMusic(MakeMusicPath("11 Red Grail Mimimal"));
                case "TheBeyond":
                    return newMusic(MakeMusicPath("9 Witch and Sister Intense"));
                case "TheEnding":
                    return newMusic(MakeMusicPath("3 Door in Eye 2REV3 (longer)"));
                case "MENU":
                    return newMusic(MakeMusicPath("1 Circular Theme Muse REV3"));
            }
            return null;
        }

        private static String MakeMusicPath(String name) {
            return "TheSecretHistories/audio/music/" + name + ".ogg";
        }
    }
}
