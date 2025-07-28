package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.*;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheChamberOfWays extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(TheChamberOfWays.class.getSimpleName());

    private static final String IMG_NAME = "wayspider";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock().DoUpgrade(3),
            new InfluenceLantern().DoUpgrade(2),
            new InfluenceWinter().DoUpgrade(2),
            new InfluenceMoth().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(2),
            new Fascination(),
    };

    public TheChamberOfWays() {
        super(ID, IMG_NAME, CARDS);
    }
}
