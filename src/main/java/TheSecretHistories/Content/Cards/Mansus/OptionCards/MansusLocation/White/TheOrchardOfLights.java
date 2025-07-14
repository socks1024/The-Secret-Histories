package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheOrchardOfLights extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheOrchardOfLights.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceLantern().DoUpgrade(1),
            new InfluenceHeart().DoUpgrade(1),
            new FragmentSecretHistories().DoUpgrade(2)
            // 灵感
    };

    public TheOrchardOfLights(AbstractCard[] cards) {
        super(ID, IMG_NAME, CARDS);
    }
}
