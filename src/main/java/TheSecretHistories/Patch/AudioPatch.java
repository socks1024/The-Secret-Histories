package TheSecretHistories.Patch;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.audio.MainMusic;
import com.megacrit.cardcrawl.audio.TempMusic;

public class AudioPatch {

    @SpirePatch(clz = MainMusic.class, method = "getSong")
    public static class MainMusicPatch {

    }
}
