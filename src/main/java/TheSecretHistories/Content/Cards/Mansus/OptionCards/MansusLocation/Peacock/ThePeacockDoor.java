package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractShowedLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class ThePeacockDoor extends AbstractShowedLocation {

    public static final String ID = StringUtils.MakeID(ThePeacockDoor.class.getSimpleName());

    private static final String IMG_NAME = "waypeacock";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            // TODO 伐诃语
            new InfluenceLantern().DoUpgrade(3),
            new FragmentSecretHistories().DoUpgrade(4),
            new Fascination(),
    };

    public ThePeacockDoor() {
        super(ID, IMG_NAME, CARDS);
    }
}
