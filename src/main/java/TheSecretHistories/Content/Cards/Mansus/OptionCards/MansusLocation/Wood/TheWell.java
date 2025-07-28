package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Others.Rumour;
import TheSecretHistories.Content.Cards.Starters.Health;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheWell extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(TheWell.class.getSimpleName());

    private static final String IMG_NAME = "waywood";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceGrail(),
            new Health(),
            new FragmentSecretHistories().DoUpgrade(1),
            new Rumour(),
    };

    public TheWell() {
        super(ID, IMG_NAME, CARDS);
    }
}
