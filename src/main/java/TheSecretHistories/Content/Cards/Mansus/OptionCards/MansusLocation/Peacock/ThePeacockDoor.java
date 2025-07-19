package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class ThePeacockDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(ThePeacockDoor.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
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
