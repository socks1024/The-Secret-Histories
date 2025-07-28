package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Content.Cards.Starters.Reason;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class ThePaintedRiver extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(ThePaintedRiver.class.getSimpleName());

    private static final String IMG_NAME = "waystag_after";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new FragmentSecretHistories().DoUpgrade(3),
            new Fascination(),
            new Reason().DoUpgrade(1),
    };

    public ThePaintedRiver() {
        super(ID, IMG_NAME, CARDS);
    }
}
