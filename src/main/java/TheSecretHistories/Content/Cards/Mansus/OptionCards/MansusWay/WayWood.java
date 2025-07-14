package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.ThePeacockDoor;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheRedChurch;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheWormMuseum;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood.TheTempleOfTheWheel;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood.TheWell;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood.TheWood;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayWood extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayWood.class.getSimpleName());

    private static final int LEVEL = 2;
    private static final String IMG_NAME = "waywood";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, MOTH, KNOCK};
    private static final AbstractCard[] LOCATIONS = new AbstractCard[]{
            new TheWell(),
            new TheWood(),
            new TheTempleOfTheWheel(),
    };

    public WayWood() {
        super(ID, IMG_NAME, TAGS, LOCATIONS, LEVEL);
    }
}
