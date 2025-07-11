package TheSecretHistories.Utils;

import TheSecretHistories.Content.Powers.Principles.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class PrincipleUtils {

    public static AbstractPrinciple GetPrinciplePowerByTag(AbstractCard.CardTags tags, int amount) {

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

    public static String GetPrincipleIDByTag(AbstractCard.CardTags tags) {

        if(tags.equals(LANTERN)){return Lantern.POWER_ID;}
        if(tags.equals(FORGE)){return Forge.POWER_ID;}
        if(tags.equals(EDGE)){return Edge.POWER_ID;}
        if(tags.equals(WINTER)){return Winter.POWER_ID;}
        if(tags.equals(HEART)){return Heart.POWER_ID;}
        if(tags.equals(GRAIL)){return Grail.POWER_ID;}
        if(tags.equals(MOTH)){return Moth.POWER_ID;}
        if(tags.equals(KNOCK)){return Moth.POWER_ID;}
        if(tags.equals(SECRET_HISTORIES)){return Moth.POWER_ID;}

        return "";
    }
}
