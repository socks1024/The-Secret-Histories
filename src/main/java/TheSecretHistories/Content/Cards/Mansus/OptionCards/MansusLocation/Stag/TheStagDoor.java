package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceWinter;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheStagDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheStagDoor.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(2),
            new InfluenceForge().DoUpgrade(1)
    };

    public TheStagDoor() {
        super(ID, IMG_NAME, CARDS);
    }
}
