package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class ThePaintedRiver extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(ThePaintedRiver.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new FragmentSecretHistories().DoUpgrade(3),
            // 入迷
            // 博闻：学有所成
    };

    public ThePaintedRiver() {
        super(ID, IMG_NAME, CARDS);
    }
}
