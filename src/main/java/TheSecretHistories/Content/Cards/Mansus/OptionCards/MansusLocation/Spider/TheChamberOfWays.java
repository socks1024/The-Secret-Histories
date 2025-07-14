package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.*;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheChamberOfWays extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheChamberOfWays.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock().DoUpgrade(3),
            new InfluenceLantern().DoUpgrade(2),
            new InfluenceWinter().DoUpgrade(2),
            new InfluenceMoth().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(2),
            // 入迷
    };

    public TheChamberOfWays() {
        super(ID, IMG_NAME, CARDS);
    }
}
