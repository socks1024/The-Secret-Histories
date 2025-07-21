package TheSecretHistories.Patch;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.Soul;
import com.megacrit.cardcrawl.events.shrines.GremlinMatchGame;
import javassist.CtBehavior;

import java.util.ArrayList;

import static TheSecretHistories.Utils.DebugUtils.Log;

public class DebugPatches {

    @SpirePatch(clz = GremlinMatchGame.class, method = "initializeCards")
    public static class MatchEventDebug {

        @SpireInsertPatch(loc = 82, localvars = {"c","retVal"})
        public static void Debug(GremlinMatchGame __instance, AbstractCard c, ArrayList<AbstractCard> retVal) {
            Log("GremlinMatchGameDebug");
            Log(retVal);
            Log(c);
            Log(c.cardID);
        }
    }
}
