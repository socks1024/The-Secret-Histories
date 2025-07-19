package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceEdge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceWinter;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Content.Cards.Starters.Reason;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheAscentOfTheKnives extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheAscentOfTheKnives.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceWinter().DoUpgrade(2),
            new InfluenceEdge().DoUpgrade(2),
            new InfluenceGrail().DoUpgrade(1),
            new Fascination(),
            new Reason().DoUpgrade(1),
    };

    public TheAscentOfTheKnives() {
        super(ID, IMG_NAME, CARDS);
    }
}
