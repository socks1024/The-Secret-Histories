package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.ThePeacockDoor;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheRedChurch;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheWormMuseum;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White.LodgeOfTheSageKnight;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White.TheOrchardOfLights;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White.TheWhiteDoor;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayWhite extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayWhite.class.getSimpleName());

    private static final int LEVEL = 4;
    private static final String IMG_NAME = "waywhite";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, WINTER, HEART, KNOCK};
    private static final AbstractCard[] LOCATIONS = new AbstractCard[]{
            new TheOrchardOfLights(),
            new TheWhiteDoor(),
            new LodgeOfTheSageKnight(),
    };

    public WayWhite() {
        super(ID, IMG_NAME, TAGS, LOCATIONS, LEVEL);
    }
}
