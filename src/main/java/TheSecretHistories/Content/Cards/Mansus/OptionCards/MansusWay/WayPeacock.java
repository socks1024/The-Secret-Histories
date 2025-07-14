package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.ThePeacockDoor;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheRedChurch;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheWormMuseum;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayPeacock extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayPeacock.class.getSimpleName());

    private static final int LEVEL = 10;
    private static final String IMG_NAME = "waypeacock";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, FORGE, EDGE, KNOCK};
    private static final AbstractCard[] LOCATIONS = new AbstractCard[]{
            new TheWormMuseum(),
            new ThePeacockDoor(),
            new TheRedChurch(),
    };

    public WayPeacock() {
        super(ID, IMG_NAME, TAGS, LOCATIONS, LEVEL);
    }
}
