package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceMoth;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceWinter;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Restlessness;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheWhiteDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheWhiteDoor.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceWinter().DoUpgrade(1),
            new FragmentSecretHistories().DoUpgrade(1),
            new Restlessness(),
    };

    public TheWhiteDoor() {
        super(ID, IMG_NAME, CARDS);
    }
}
