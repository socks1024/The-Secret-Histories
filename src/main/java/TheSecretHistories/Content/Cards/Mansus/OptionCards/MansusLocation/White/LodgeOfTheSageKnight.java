package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Others.Favour;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Content.Cards.Starters.Passion;
import TheSecretHistories.Content.Cards.Starters.Reason;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class LodgeOfTheSageKnight extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(LodgeOfTheSageKnight.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock().DoUpgrade(1),
            new FragmentSecretHistories().DoUpgrade(2),
            new Passion(),
            new Reason(),
            new Fascination(),
            // new Favour(),
    };

    public LodgeOfTheSageKnight() {
        super(ID, IMG_NAME, CARDS);
    }
}
