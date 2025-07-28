package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Starters.Passion;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheOrchardOfLights extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(TheOrchardOfLights.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceLantern().DoUpgrade(1),
            new InfluenceHeart().DoUpgrade(1),
            new FragmentSecretHistories().DoUpgrade(2),
            new Passion(),
    };

    public TheOrchardOfLights() {
        super(ID, IMG_NAME, CARDS);
    }
}
