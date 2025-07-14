package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.ThePeacockDoor;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheRedChurch;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock.TheWormMuseum;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider.TheChamberOfWays;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider.TheMalleary;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider.TheSpiderDoor;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WaySpider extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WaySpider.class.getSimpleName());

    private static final int LEVEL = 8;
    private static final String IMG_NAME = "wayspider";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, GRAIL, KNOCK};
    private static final AbstractCard[] LOCATIONS = new AbstractCard[]{
            new TheChamberOfWays(),
            new TheSpiderDoor(),
            new TheMalleary(),
    };

    public WaySpider() {
        super(ID, IMG_NAME, TAGS, LOCATIONS, LEVEL);
    }
}
