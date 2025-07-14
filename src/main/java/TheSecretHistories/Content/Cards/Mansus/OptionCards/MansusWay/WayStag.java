package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.ThePeacockDoor;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheRedChurch;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheWormMuseum;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag.TheAscentOfTheKnives;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag.ThePaintedRiver;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag.TheStagDoor;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayStag extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayStag.class.getSimpleName());

    private static final int LEVEL = 6;
    private static final String IMG_NAME = "waystag_after";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, KNOCK};
    private static final AbstractCard[] LOCATIONS = new AbstractCard[]{
            new ThePaintedRiver(),
            new TheStagDoor(),
            new TheAscentOfTheKnives(),
    };

    public WayStag() {
        super(ID, IMG_NAME, TAGS, LOCATIONS, LEVEL);
    }
}
