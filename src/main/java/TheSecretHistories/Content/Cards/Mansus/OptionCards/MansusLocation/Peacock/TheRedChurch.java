package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheRedChurch extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheRedChurch.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceGrail().DoUpgrade(3),
            // new IngredientGrailD()
            new FragmentSecretHistories().DoUpgrade(5),
            // 人情
            // 入迷
    };

    public TheRedChurch(AbstractCard[] cards) {
        super(ID, IMG_NAME, CARDS);
    }
}
