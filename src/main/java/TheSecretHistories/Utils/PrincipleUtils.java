package TheSecretHistories.Utils;

import TheSecretHistories.Content.Powers.Principles.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.HashMap;
import java.util.Map;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class PrincipleUtils {

    public static AbstractPrinciple GetPrinciplePower(AbstractCard.CardTags tags, int amount) {

        if(tags.equals(LANTERN)){return new Lantern(AbstractDungeon.player, amount);}
        if(tags.equals(FORGE)){return new Forge(AbstractDungeon.player, amount);}
        if(tags.equals(EDGE)){return new Edge(AbstractDungeon.player, amount);}
        if(tags.equals(WINTER)){return new Winter(AbstractDungeon.player, amount);}
        if(tags.equals(HEART)){return new Heart(AbstractDungeon.player, amount);}
        if(tags.equals(GRAIL)){return new Grail(AbstractDungeon.player, amount);}
        if(tags.equals(MOTH)){return new Moth(AbstractDungeon.player, amount);}
        if(tags.equals(KNOCK)){return new Knock(AbstractDungeon.player, amount);}
        if(tags.equals(SECRET_HISTORIES)){return new SecretHistories(AbstractDungeon.player, amount);}

        return null;
    }

    public static String GetPrincipleID(AbstractCard.CardTags tags) {

        if(tags.equals(LANTERN)){return Lantern.POWER_ID;}
        if(tags.equals(FORGE)){return Forge.POWER_ID;}
        if(tags.equals(EDGE)){return Edge.POWER_ID;}
        if(tags.equals(WINTER)){return Winter.POWER_ID;}
        if(tags.equals(HEART)){return Heart.POWER_ID;}
        if(tags.equals(GRAIL)){return Grail.POWER_ID;}
        if(tags.equals(MOTH)){return Moth.POWER_ID;}
        if(tags.equals(KNOCK)){return Knock.POWER_ID;}
        if(tags.equals(SECRET_HISTORIES)){return SecretHistories.POWER_ID;}

        return "";
    }

    public static int GetPlayerPrincipleAmount(AbstractCard.CardTags tags) {

        return GetPlayerPrincipleAmount(GetPrincipleID(tags));
    }

    public static int GetPlayerPrincipleAmount(String powerID) {

        return PowerUtils.GetPowerAmount(powerID, AbstractDungeon.player);
    }

    public static Map<AbstractCard.CardTags, Integer> GetPlayerAllPrincipleAmounts() {

        Map<AbstractCard.CardTags, Integer> map = new HashMap<>();

        ModifyPrinciplesMap(map, LANTERN);
        ModifyPrinciplesMap(map, FORGE);
        ModifyPrinciplesMap(map, EDGE);
        ModifyPrinciplesMap(map, WINTER);
        ModifyPrinciplesMap(map, HEART);
        ModifyPrinciplesMap(map, GRAIL);
        ModifyPrinciplesMap(map, MOTH);
        ModifyPrinciplesMap(map, KNOCK);
        ModifyPrinciplesMap(map, SECRET_HISTORIES);

        return map;
    }

    private static void ModifyPrinciplesMap(Map<AbstractCard.CardTags, Integer> map, AbstractCard.CardTags tag) {
        map.put(tag, PrincipleUtils.GetPlayerPrincipleAmount(tag));
    }

    public static boolean PlayerHasEnoughPrinciple(AbstractCard.CardTags tag, int amount) {
        return GetPlayerPrincipleAmount(tag) >= amount;
    }

    public static boolean PlayerHasEnoughPrinciple(ReducePrincipleInfo[] infos) {
        for (ReducePrincipleInfo info : infos) {
            if (!PlayerHasEnoughPrinciple(info.principleTag, info.reduceAmount)) return false;
        }

        return true;
    }

    public static class ReducePrincipleInfo {

        public final AbstractCard.CardTags principleTag;
        public final String principleID;
        public final int reduceAmount;

        public ReducePrincipleInfo(AbstractCard.CardTags principleTag, int reduceAmount) {
            this.principleTag = principleTag;
            this.principleID = PrincipleUtils.GetPrincipleID(principleTag);
            this.reduceAmount = reduceAmount;
        }
    }

    public static AbstractCard.CardTags GetCardPrincipleTag(AbstractCard card){

        if (card.hasTag(LANTERN)) return LANTERN;
        if (card.hasTag(FORGE)) return EDGE;
        if (card.hasTag(EDGE)) return EDGE;
        if (card.hasTag(WINTER)) return WINTER;
        if (card.hasTag(HEART)) return HEART;
        if (card.hasTag(GRAIL)) return GRAIL;
        if (card.hasTag(MOTH)) return MOTH;
        if (card.hasTag(KNOCK)) return KNOCK;
        if (card.hasTag(SECRET_HISTORIES)) return SECRET_HISTORIES;

        return AbstractCard.CardTags.EMPTY;

    }
}
