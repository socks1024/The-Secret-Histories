package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractShowedLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheStagDoor extends AbstractShowedLocation {

    public static final String ID = StringUtils.MakeID(TheStagDoor.class.getSimpleName());

    private static final String IMG_NAME = "waystag_after";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(2),
            new InfluenceForge().DoUpgrade(1)
    };

    public TheStagDoor() {
        super(ID, IMG_NAME, CARDS);
    }
}
