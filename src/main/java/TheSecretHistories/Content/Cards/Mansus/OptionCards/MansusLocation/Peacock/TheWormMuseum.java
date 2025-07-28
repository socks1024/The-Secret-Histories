package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceWinter;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Dread;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheWormMuseum extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(TheWormMuseum.class.getSimpleName());

    private static final String IMG_NAME = "waypeacock";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceWinter().DoUpgrade(3),
            new FragmentSecretHistories().DoUpgrade(5),
            new Dread(),
    };

    public TheWormMuseum() {
        super(ID, IMG_NAME, CARDS);
    }
}
